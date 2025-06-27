package chap4;

public class test15 { //클래스 설정 
	
	public static int ko28_il(int ko28_a, int ko28_b) { //정수 정수 ko28_a, ko28_b를 매개변수 
		int ko28_ret;//초기값 설정 
		ko28_ret=ko28_a+2*ko28_b;//연산 수행 
		return ko28_ret; //결과 반환 
	}
	public static String ko28_s1(int ko28_a, int ko28_b) {//정수 ko28_a, ko28_b를 매개변수로 받음
		String ko28_ret;// 문자열 설정 
		ko28_ret=Integer.toString(ko28_a)+Integer.toString(ko28_b);//각 숫자를 String으로 변환
		return ko28_ret;
	}//두 숫자를 이어붙인 후 반환
	public static void ko28_s2() { //입력 없음 
		System.out.printf("s2함수는 입려도 출력도 없이 안에서 인쇄만..\n"); //입력값 출력 
	}

	public static void main(String[] args) {
		System.out.printf("함수 il[%d]\n",ko28_il(1,2));//입력값 출력 
		System.out.printf("함수 s1[%s]\n", ko28_s1(1,2));//입력값 출력 
		ko28_s2(); //출력 
		// TODO Auto-generated method stub
		

	}

}
