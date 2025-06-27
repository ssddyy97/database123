package chap4;

public class test2 {//클래스 선언 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ko28_iA, ko28_iB;// 변수값 설정 
		
		ko28_iA=0;//초기값 설정 
		while(true) { //무한 루프 
			ko28_iB=0; //초기값 설정 
			while(true) { //무한루프 
			System.out.printf("*");//입력값 출력 
			
			if(ko28_iA==ko28_iB) break;// if문  ko28_iA==ko28_iB 같으면 종료 
			ko28_iB++;//병을 출력하도록 증가 
			}
			System.out.printf("\n");//입력값 출력 
			ko28_iA++; //다음행 증가 
			if(ko28_iA==30) break; //30줄 출력 후종료 
	}

	}

}