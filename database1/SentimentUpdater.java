package database1;

import java.sql.*;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class SentimentUpdater {

    // DB 설정
    static final String DB_URL = "jdbc:mysql://localhost:33067/ai_test";
    static final String USER = "root";
    static final String PASS = "lleejin71";

    // LM Studio API 설정
    static final String API_URL = "http://localhost:1234/v1/chat/completions";
    static final String API_KEY = "lm-studio";

    // 데이터를 저장할 클래스
    static class ReplyData {
        int id;
        String reply;
        
        ReplyData(int id, String reply) {
            this.id = id;
            this.reply = reply;
        }
    }

    public static void main(String[] args) throws Exception {
        Connection conn = null;
        Statement selectStmt = null;
        PreparedStatement updateStmt = null;
        ResultSet rs = null;
        
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            // 1단계: 모든 데이터를 먼저 읽어서 메모리에 저장
            selectStmt = conn.createStatement();
            rs = selectStmt.executeQuery("SELECT id, reply FROM reply_text");
            
            List<ReplyData> replyList = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String reply = rs.getString("reply");
                replyList.add(new ReplyData(id, reply));
            }
            
            // ResultSet과 Statement 닫기
            rs.close();
            selectStmt.close();
            
            System.out.println("총 " + replyList.size() + "개의 데이터를 처리합니다.");

            // 2단계: PreparedStatement로 업데이트 준비
            String updateGoodSql = "UPDATE reply_text SET good = good + 1 WHERE id = ?";
            String updateBadSql = "UPDATE reply_text SET bad = bad + 1 WHERE id = ?";
            
            PreparedStatement updateGoodStmt = conn.prepareStatement(updateGoodSql);
            PreparedStatement updateBadStmt = conn.prepareStatement(updateBadSql);

            // 3단계: 각 데이터에 대해 API 호출 및 업데이트
            int processedCount = 0;
            for (ReplyData data : replyList) {
                try {
                    System.out.println("처리 중: ID " + data.id + " (" + (processedCount + 1) + "/" + replyList.size() + ")");
                    
                    int result = callAPI(data.reply); // API 호출

                    if (result == 1) {
                        updateGoodStmt.setInt(1, data.id);
                        updateGoodStmt.executeUpdate();
                        System.out.println("ID " + data.id + ": 긍정 처리 완료");
                    } else if (result == 2) {
                        updateBadStmt.setInt(1, data.id);
                        updateBadStmt.executeUpdate();
                        System.out.println("ID " + data.id + ": 부정 처리 완료");
                    } else {
                        System.out.println("ID " + data.id + ": 중립 또는 오류 응답 - " + result);
                    }
                    
                    processedCount++;
                    
                } catch (Exception e) {
                    System.err.println("ID " + data.id + " 처리 중 오류: " + e.getMessage());
                }
                
                // API 호출 간격 조절 (서버 부하 방지)
                Thread.sleep(500);
            }
            
            System.out.println("처리 완료: 총 " + processedCount + "개 처리됨");
            
            // PreparedStatement 닫기
            updateGoodStmt.close();
            updateBadStmt.close();

        } catch (SQLException e) {
            System.err.println("데이터베이스 오류: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // 리소스 정리
            try {
                if (rs != null) rs.close();
                if (selectStmt != null) selectStmt.close();
                if (updateStmt != null) updateStmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.err.println("리소스 정리 중 오류: " + e.getMessage());
            }
        }
    }

    // 간단한 JSON 문자열 생성
    private static String createJsonPayload(String content) {
        // JSON 특수문자 이스케이프
        String escapedContent = content.replace("\"", "\\\"")
                                      .replace("\n", "\\n")
                                      .replace("\r", "\\r")
                                      .replace("\t", "\\t")
                                      .replace("\\", "\\\\");
        
        return "{"
            + "\"model\": \"lmstudio-community/gemma-3-1b-it\","
            + "\"messages\": ["
            + "{"
            + "\"role\": \"user\","
            + "\"content\": \"다음 문장이 긍정이면 1, 부정이면 2, 중립이면 3으로만 대답하세요: " + escapedContent + "\""
            + "}"
            + "],"
            + "\"max_tokens\": 10,"
            + "\"temperature\": 0.1"
            + "}";
    }

    // 간단한 JSON 응답 파싱
    private static String parseJsonResponse(String jsonResponse) {
        try {
            // "content": "값" 패턴을 찾아서 값 추출
            String searchPattern = "\"content\"";
            int contentIndex = jsonResponse.indexOf(searchPattern);
            if (contentIndex == -1) return "";
            
            // content 다음의 첫 번째 따옴표 찾기
            int searchStart = contentIndex + searchPattern.length();
            int startQuote = jsonResponse.indexOf("\"", searchStart);
            if (startQuote == -1) return "";
            
            // 값의 시작점
            int valueStart = startQuote + 1;
            int endQuote = jsonResponse.indexOf("\"", valueStart);
            if (endQuote == -1) return "";
            
            return jsonResponse.substring(valueStart, endQuote);
        } catch (Exception e) {
            System.err.println("JSON 파싱 오류: " + e.getMessage());
            return "";
        }
    }

    // LM Studio API 호출 함수
    private static int callAPI(String context) throws IOException {
        URL url = new URL(API_URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        try {
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "Bearer " + API_KEY);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setConnectTimeout(30000);
            conn.setReadTimeout(30000);
            conn.setDoOutput(true);

            // JSON 페이로드 생성
            String jsonPayload = createJsonPayload(context);

            // 요청 전송
            try (OutputStream os = conn.getOutputStream()) {
                os.write(jsonPayload.getBytes("UTF-8"));
                os.flush();
            }

            // 응답 읽기
            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                System.err.println("HTTP 오류: " + responseCode);
                return 3; // 오류 시 중립으로 처리
            }

            StringBuilder response = new StringBuilder();
            try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"))) {
                String line;
                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
            }

            // 응답에서 content 값 추출
            
            String answer = parseJsonResponse(response.toString()).trim();
            System.out.println("API 응답: " + answer);

            try {
                // 응답에서 숫자만 추출
                String numericOnly = answer.replaceAll("[^123]", "");
                if (numericOnly.length() > 0) {
                    int result = Integer.parseInt(String.valueOf(numericOnly.charAt(0)));
                    if (result >= 1 && result <= 3) {
                        return result;
                    }
                }
                
                System.err.println("예상치 못한 응답: " + answer);
                return 3; // 중립으로 처리
                
            } catch (NumberFormatException e) {
                System.err.println("숫자 파싱 오류: " + answer);
                return 3; // 예외는 중립으로 처리
            }

        } catch (IOException e) {
            System.err.println("API 호출 오류: " + e.getMessage());
            return 3; // 오류 시 중립으로 처리
        } finally {
            conn.disconnect();
        }
    }
}