package chap9;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class test3 { //클래스 선언 
	
	public static JSONObject oneRec(String ko28_name, int ko28_studentid, int ko28_kor, int ko28_eng, int ko28_mat ) { //메소드 선언 
		JSONObject ko28_dataObject= new JSONObject(); //객체 설정 JSONObject로 하나의 학생 정보 생성
		ko28_dataObject.put("name", ko28_name); //이름 정보를 받음 
		ko28_dataObject.put("studentid",ko28_studentid);//학번 정보를 받음 
		JSONArray ko28_score= new JSONArray(); //국영수 점수를 받음 
		ko28_score.add(ko28_kor);ko28_score.add(ko28_eng);ko28_score.add(ko28_mat); //추가 
		ko28_dataObject.put("score", ko28_score); 
		
		return ko28_dataObject; //반환 
	
	}

	public static void main(String[] args) {

	    // 최종 완성된 JSONObject 선언 (전체)
	    JSONObject ko28_jsonObject = new JSONObject();

	    // 한명 성적의 JSON 정보를 담을 Array 선언
	    JSONArray ko28_datasArray = new JSONArray();

	    // 한명 정보가 들어갈 JSONObject 선언
	    JSONObject ko28_dataObject = new JSONObject();
	    ko28_dataObject.put("name", "나연"); //이름 값 
	    ko28_dataObject.put("studentid", 209901); //학번 값 

	    // Json Array 생성
	    JSONArray ko28_score = new JSONArray(); //객체 설정 
	    ko28_score.add(90); //90점 추가 
	    ko28_score.add(100); //100점 추가 
	    ko28_score.add(95); //95점 추가 
	    ko28_dataObject.put("score", ko28_score); //총합 정수 추가 
	    ko28_datasArray.add(ko28_dataObject); 

	    // //oneRec() 함수로 간단히 호출하여 각 학생 JSON 객체 생성 및 추가
	    ko28_datasArray.add(oneRec("정연", 209902, 100, 85, 75)); //정연 학번 국어 영어 수학 추가 
	    ko28_datasArray.add(oneRec("모모", 209903, 90, 75, 85));//모모 학번 국어 영어 수학 
	    ko28_datasArray.add(oneRec("사나", 209904, 90, 85, 75));//사나 학번 국어 영어 수학 
	    ko28_datasArray.add(oneRec("지효", 209905, 80, 75, 85));//지효 학번 국어 영어 수학 
	    ko28_datasArray.add(oneRec("미나", 209906, 90, 85, 55));//미나 학번 국어 영어 수학 
	    ko28_datasArray.add(oneRec("다현", 209907, 70, 75, 65));//다현 학번 국어 영어 수학 
	    ko28_datasArray.add(oneRec("채영", 209908, 100, 75, 95));//채영 학번 국어 영어 수학 
	    ko28_datasArray.add(oneRec("쯔위", 209909, 80, 65, 95));//쯔위 학번 국어 영어 수학 


	try {
	    FileWriter ko28_file = new FileWriter("C:\\Users\\USER\\Desktop\\json.json"); //파일 작성 객체 설정  
	    
	    ko28_file.write(ko28_datasArray.toJSONString()); //만들어진 JSONArray를 JSON 문자열로 변환 
	    
	    ko28_file.flush(); //버퍼에 남아 있는 데이터를 강제로 파일에 밀어 넣기 
	    ko28_file.close(); //메모리 누수 방지
	} catch (IOException e) { //오류 일때 넘어감 
	    e.printStackTrace();
	}

	System.out.println("JSON 만든거 : " + ko28_datasArray);//파일 저장 메세지 출력 

}
}