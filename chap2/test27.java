package chap2;

public class test27 { //클래스

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ko28_i=10;//변수설정 
		byte ko28_b=(byte)ko28_i;//10을 byte로 변환 
		System.out.printf("[int -> byte] i=%d -> b=%d%n", ko28_i, ko28_b); //출력 데이터 손실 없음 
		
		ko28_i=300; //변수 설정 
		ko28_b=(byte)ko28_i ;//300을 byte로 변환
		System.out.printf("[int -> byte] i=%d -> b=%d%n", ko28_i, ko28_b);//출력 데이터손실 발생 
		
		ko28_b=10;// 변수설정 
		ko28_i=(int)ko28_b; //byte → int 변환
		System.out.printf("[int -> byte] i=%d -> b=%d%n", ko28_i, ko28_b);// 출력 데이터 손실 없음 
		
		ko28_b=-2; //변수 설정 
		ko28_i=(int)ko28_b;  //음수 byte → int 변환
		System.out.printf("[int -> byte] i=%d -> b=%d%n", ko28_i, ko28_b); // 출력 값은 그대로 유지됨 
		
		
		System.out.println("ko28_i="+Integer.toBinaryString(ko28_i)); // 출력 int 값을 2진수(Binary) 문자열로 변환하여 출력

	}

}
