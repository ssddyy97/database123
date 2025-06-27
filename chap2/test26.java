package chap2;

public class test26 { //클래스 선언 

	public static void main(String[] args) {
		double ko28_d= 85.4; // double 타입 변수 d에 85.4 저장.
		int  ko28_score =(int) ko28_d;//실수를 정수로 변환 
		
		System.out.println("score="+ ko28_score); //소수점이 버려진 값으로 출력
		System.out.println("d="+ ko28_d); //원래 실수 값으로 출력
	}

}
