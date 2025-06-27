package chap9;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class test4 { //클래스 선언 
    public static void main(String[] args) {
        JSONParser ko28_parser = new JSONParser();
        
        try {
            // JSON 파일 읽기
            Object ko28_obj = ko28_parser.parse(new FileReader("C:\\Users\\USER\\Desktop\\json.json")); //JSON 파일을 읽어서 Java 객체로 변환
            JSONArray ko28_array = (JSONArray)ko28_obj;//최상위 구조는 JSONArray이므로 캐스팅

            System.out.println("*************************"); //점선 출력
            for (int ko28_i = 0; ko28_i < ko28_array.size(); ko28_i++) { //for 문 JSONArray에 있는 각 학생 정보를 JSONObject로 가져옴
                JSONObject ko28_result = (JSONObject) ko28_array.get(ko28_i);

                // JSON 데이터 가져오기
                String ko28_name = (String) ko28_result.get("name"); //이름 배열 추출 
                long ko28_studentId = (long) ko28_result.get("studentid"); //학번 배열 추출
                JSONArray ko28_score = (JSONArray) ko28_result.get("score"); //점수 배열 추출 

                long ko28_kor = (long) ko28_score.get(0); //0으로 분리 
                long ko28_eng = (long) ko28_score.get(1); //1로 분리 
                long ko28_mat = (long) ko28_score.get(2); //2로 분리 

                // 총점 및 평균 계산
                long ko28_total = ko28_kor + ko28_eng + ko28_mat; //총점 계산 
                double ko28_avg = ko28_total / 3.0; //평균 계산 

                // 출력
                System.out.println("이름   : " + ko28_name); //이름 출력 
                System.out.println("학번   : " + ko28_studentId); //학번 출력 
                System.out.println("국어   : " + ko28_kor); //국어 점수  출력 
                System.out.println("영어   : " + ko28_eng); //영어 점수 출력 
                System.out.println("수학   : " + ko28_mat); //수학 점수 출력 
                System.out.println("총점   : " + ko28_total); //총점 출력 
                System.out.printf("평균   : %.2f\n", ko28_avg); //평균 출력 
                System.out.println("*************************"); //점선 출력 
            }
        } catch (FileNotFoundException ko28_e) {
            System.out.println("❌ 파일을 찾을 수 없습니다: " + ko28_e.getMessage());  //파일을 읽지 못할때 
        } catch (IOException ko28_e) {
            System.out.println("❌ 파일을 읽는 중 오류 발생: " + ko28_e.getMessage()); //파일을 읽는 중 오류 발생할때 
        } catch (ParseException ko28_e) {
            System.out.println("❌ JSON 파싱 오류 발생: " + ko28_e.getMessage()); //파싱 오류 발생 시 
        } catch (Exception ko28_e) {
            System.out.println("❌ 알 수 없는 오류 발생: " + ko28_e.getMessage()); //알수 없는 오류 발생 시 
        }
    }
}
