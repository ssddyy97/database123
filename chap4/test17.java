package chap4;

public class test17 { //클래스 선언

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] ko28_a= {"apple","red panda is so cute", "banana"};//문자열 설정 
		
		for(int ko28_i=0; ko28_i< ko28_a.length;ko28_i++){ //for 문 0~길이전까지 반복
			System.out.printf("[%10.10s][%-10.10s]\n",ko28_a[ko28_i],ko28_a[ko28_i]); // 입력값 출력  
			//%10.10s → 10자리 확보 후 출력 (오른쪽 정렬)
			//%-10.10s → 10자리 확보 후 출력 (왼쪽 정렬)
	}
		for(int ko28_i=0; ko28_i< ko28_a.length;ko28_i++){ //for 문 0~길이 전까지 반복 
			System.out.printf("[%s][%s]\n",fblank(ko28_a[ko28_i],10),bblank(ko28_a[ko28_i],10));//fblank(a[i], 10) → 왼쪽에 * 추가
			//bblank(a[i], 10) → 오른쪽에 * 추가
			
	}		
		
		ko28_a=new String[] {"안녕", "오늘은 소풍을 가는날 ", "소풍을 가자가자"};//새로운 문자열 설정
	
		for(int ko28_i=0; ko28_i< ko28_a.length;ko28_i++){ //for문 0~길이 전까지 
		System.out.printf("[%s][%s]\n",fblank(ko28_a[ko28_i],10),bblank(ko28_a[ko28_i],10)); //입력값 출력 
		}
		
	}
	
	public static String fblank(String ko28_a, int ko28_k) {
		String ko28_retS=ko28_a; //문자열 설정 
		byte[] ko28_bA=ko28_a.getBytes(); //문자열을 바이트 배열로 변환 
		//만일 원래 글자열이 보이고 싶은 글자 바이트보다 크다면 그 크기만큼 자른다
		if(ko28_bA.length>=ko28_k) { // 문자열 길이가 `k` 이상이면 자름
			ko28_retS= new String(ko28_bA,0,ko28_k); //string 범위 
			return ko28_retS; //결과 반환 
			
		}
		
		int ko28_bCnt=ko28_k-ko28_bA.length; // 부족한 길이 계산
		
		for(int ko28_i=0; ko28_i<ko28_bCnt; ko28_i++) { //for 문 0부터 ~~길이 전까지 반복 
			ko28_retS="*"+ko28_retS; // 오른쪽에 `*` 추가
			
		}
		return ko28_retS;//결과 반환 
		}
	public static String bblank(String ko28_a, int ko28_k ) { 
		String ko28_retS=ko28_a; //문자열 설정 
		byte[] ko28_bA=ko28_a.getBytes(); //문자열을 바이트 배열로 변환 
		
		
		if(ko28_bA.length>=ko28_k) { // 문자열 길이가 `k` 이상이면 자름
			ko28_retS=new String (ko28_bA,0,ko28_k);//string 범위 
			return ko28_retS;//결과 반환
			
		}
		// TODO Auto-generated method stub
		int ko28_bCnt= ko28_k-ko28_bA.length;// 부족한 길이 계산
		
		for (int ko28_i=0; ko28_i<ko28_bCnt;ko28_i++) {//for 문 0부터 ~~길이 전까지 반복 
			ko28_retS=ko28_retS+"*"; // 오른쪽에 `*` 추가
			
		}
		return ko28_retS;//결과 반환 


	}
}

