package chap2;

public class test2 {

	public static void main(String[] args) {
	
		// TODO Auto-generated method stub
		int ko28_i; //int: 16비트 정수형

	
		ko28_i=1+2+3+4; //i를 전부 더한 값
		System.out.printf("i=%d\n\n\n", ko28_i); // ko28의 값을 도출하는 것
		
		ko28_i=1;  //=같다는 의미가 아니라 삽입의 의미  
		ko28_i=ko28_i+2; // ko28_i 대입 <=ko28_i+2
		ko28_i=ko28_i+3; // ko28_i 대입 <=ko28_i+3
		ko28_i=ko28_i+4;	// ko28_i 대입 <=ko28_i+4
		System.out.printf("ko28_i=%d\n\n\n", ko28_i); // 계속 더하라는 의미 
		
		String ko28_a;
		ko28_a="ko28_a"; //문자를 더하는것 스트링 연산의 문자를 더하는 것에 대한 의미 
		ko28_a=ko28_a+"ko28_b"; // 기존 ko28_a + 대입  <=ko28_b
		ko28_a=ko28_a+"ko28_c"; // 기존 ko28_a + 대입  <=ko28_c
		ko28_a=ko28_a+"ko28_d"; // 기존 ko28_a + 대입  <=ko28_d
		System.out.printf("ko28_a=%s\n\n\n", ko28_a); //계속 더하라는 의미
		
		// string은 변수와 함수를 클래스이다
		ko28_a= ko28_a.replace("ko28_b","ko28_c"); //ko28_b의 값을 c로 변환
		System.out.printf("ko28_a=%s\n\n\n", ko28_a); //ko28의 값을 도출하는 것
	}
}