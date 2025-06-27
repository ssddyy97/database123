package ai1;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class dafs {

    public static String apiTestPost(String sendData) { // gpt api 호출 메서드 입력 : json 문자열 
        String apiUrl = "https://api.openai.com/v1/chat/completions"; // api 주소
        String apiKey = "Bearer " + System.getenv("OPENAI_API_KEY");  // 환경 변수에서 키 가져오기

        StringBuilder responseBuffer = new StringBuilder(); //응답을 저장할 버퍼 
        String result = "";

        try {
            // 연결 설정
            URL url = new URL(apiUrl); //객체 생성 
            HttpURLConnection conn = (HttpURLConnection) url.openConnection(); // 연결 객체 생성 
            conn.setRequestMethod("POST"); // post 방식 설정 
            conn.setConnectTimeout(30000); // 연결 타임 아웃(30초)
            conn.setReadTimeout(30000); // 응답 대기 타임아웃 (30초)
            conn.setDoOutput(true);// outputstream 사용하능하게 설정 
            conn.setRequestProperty("Authorization", apiKey); // 권한 설정 
            conn.setRequestProperty("Content-Type", "application/json"); //json 형식으로 파싱 

            // 요청 전송
            try (OutputStream os = conn.getOutputStream();
                 BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"))) { //utf 8로 한국어 변환 
                writer.write(sendData); // json 문자열 작성 
                writer.flush(); // 버퍼 값 비우기 
            }

            // 응답 처리 
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) { //응답 코드가 200인 경우 
                try (BufferedReader reader = new BufferedReader(
                        new InputStreamReader(conn.getInputStream(), "UTF-8"))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        responseBuffer.append(line); // 응답 내용을 문자열로 누적 
                    }
                }

                // JSON 파싱
                JSONParser parser = new JSONParser(); //파서 생성 
                JSONObject json = (JSONObject) parser.parse(responseBuffer.toString()); //응답 문자열을 json  객체로 파싱 

                JSONArray choices = (JSONArray) json.get("choices"); //choice 배열에서 첫 응답 추출 
                if (choices != null && !choices.isEmpty()) {
                    JSONObject choice = (JSONObject) choices.get(0); // 첫번째 선택지 
                    JSONObject message = (JSONObject) choice.get("message"); //message 객체 
                    String content = (String) message.get("content"); // 실제 텍스트 응답추출 
                    result = content; //결과로 저장 
                }

            } else {
                result = "에러 코드: " + conn.getResponseCode() + "\n내용: " + conn.getResponseMessage();
            }

        } catch (Exception e) {
            e.printStackTrace(); //예외 출력 
            result = "Exception 발생: " + e.getMessage(); //에러 메시지 저장 
        }

        return result; //결과 반환 
    }

    public static void main(String[] args) {
        // 요청 JSON 구성
        JSONObject message = new JSONObject(); //사용자 메시지 구성 
        message.put("role", "user"); //역할 사용자 
        message.put("content", "재미있는 과학상식에 대해서 알려줄래-.");  //사용자 질문 

        JSONArray messages = new JSONArray();
        messages.add(message); //메시지를 배열로 묶음 

        JSONObject requestBody = new JSONObject();// 최종 용청 json 구성 
        requestBody.put("model", "gpt-4o");  // 사용할 모델 지정 
        requestBody.put("messages", messages); // 메시지 목록 포함 

        String response = apiTestPost(requestBody.toJSONString());// 호출 및 결과 출력 
        System.out.println("GPT 응답: " + response);
    }
}

