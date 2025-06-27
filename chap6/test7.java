package chap6;

public class test7 { //클래스 선언 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test6 ko28_cc=new test6(); //클래스 객체 설정 
		
		System.out.printf("2개 덧셈이 호출됨 [%d]\n", ko28_cc.ko28_sum(1,2)); // 입력값 출력 메소드오버로딩 불러오기 
		System.out.printf("3개 덧셈이 호출됨 [%d]\n", ko28_cc.ko28_sum(1,2,3));// 입력값 출력 메소드오버로딩 불러오기
		System.out.printf("4개 덧셈이 호출됨 [%d]\n", ko28_cc.ko28_sum(1,2,3,4));// 입력값 출력 메소드오버로딩 불러오기
		System.out.printf("더블 덧셈이 호출됨 [%f]\n", ko28_cc.ko28_sum(1.3,2.4));// 입력값 출력 메소드오버로딩 불러오기

	}

}
