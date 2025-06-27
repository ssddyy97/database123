package database1;

import java.sql.*;
import java.io.*;
import java.net.*;
import com.google.gson.*;

public class aiprogramming {

    // DB 설정
    static final String DB_URL = "jdbc:mysql://localhost:33067/ai_test";
    static final String USER = "kopo28";
    static final String PASS = "lleejin71";

    // LM Studio API 설정
    static final String API_URL = "http://localhost:1234/v1/chat/completions";
    static final String API_KEY = "lm-studio";

    public static void main(String[] args) throws Exception {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            rs = stmt.executeQuery("SELECT id, reply FROM reply_text");

            while (rs.next()) {
                int id = rs.getInt("id");
                String reply = rs.getString("reply");

                try {
                    int result = callAPI(reply); // API 호출

                    if (result == 1) {
                        stmt.executeUpdate("UPDATE reply_text SET good = good + 1 WHERE id = " + id);
                        System.out.println("ID " + id + ": 긍정 처리 완료");
                    } else if (result == 2) {
                        stmt.executeUpdate("UPDATE reply_text SET bad = bad + 1 WHERE id = " + id);
                        System.out.println("ID " + id + ": 부정 처리 완료");
                    } else {
                        System.out.println("ID " + id + ": 중립 또는 오류 응답 - " + result);
                    }
                } catch (Exception e) {
                    System.err.println("ID " + id + " 처리 중 오류: " + e.getMessage());
                }
            }

        } catch (SQLException e) {
            System.err.println("데이터베이스 오류: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // 리소스 정리
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.err.println("리소스 정리 중 오류: " + e.getMessage());
            }
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

            // 요청 데이터 JSON
            JsonObject message = new JsonObject();
            message.addProperty("role", "user");
            message.addProperty("content", "다음 문장이 긍정이면 1, 부정이면 2, 중립이면 3으로만 대답하세요: " + context);

            JsonArray messages = new JsonArray();
            messages.add(message);

            JsonObject payload = new JsonObject();
            payload.addProperty("model", "lmstudio-community/Meta-Llama-3-8B-Instruct-GGUF");
            payload.add("messages", messages);
            payload.addProperty("max_tokens", 10);
            payload.addProperty("temperature", 0.1);

            // 요청 전송
            try (OutputStream os = conn.getOutputStream()) {
                os.write(payload.toString().getBytes("UTF-8"));
                os.flush();
            }

            // 응답 읽기
            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new IOException("HTTP 오류: " + responseCode);
            }

            try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"))) {
                JsonObject response = JsonParser.parseReader(in).getAsJsonObject();

                String answer = response
                    .getAsJsonArray("choices")
                    .get(0).getAsJsonObject()
                    .getAsJsonObject("message")
                    .get("content").getAsString().trim();

                try {
                    // 응답에서 숫자만 추출
                    String numericOnly = answer.replaceAll("[^123]", "");
                    if (numericOnly.length() > 0) {
                        return Integer.parseInt(String.valueOf(numericOnly.charAt(0)));
                    } else {
                        System.err.println("예상치 못한 응답: " + answer);
                        return 3; // 중립으로 처리
                    }
                } catch (NumberFormatException e) {
                    System.err.println("숫자 파싱 오류: " + answer);
                    return 3; // 예외는 중립으로 처리
                }
            }

        } finally {
        	
            conn.disconnect();
        }
    }
}

