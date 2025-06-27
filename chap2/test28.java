package chap2;

public class test28 { //클래스 선언 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float ko28_f= 9.1234567f;  // float(4바이트) 타입 실수
		double ko28_d=9.1234567; // double(8바이트) 타입 실수
		double ko28_d2=(double)ko28_f; // float을 double로 변환
		
		System.out.printf("f=%20.18f\n", ko28_f); // 출력 %20.18f 전체 20자리 확보, 소수점 아래 18자리 출력
		System.out.printf("f=%20.18f\n", ko28_d);// 출력 %20.18f 전체 20자리 확보, 소수점 아래 18자리 출력
		System.out.printf("f=%20.18f\n", ko28_d2);// 출력 %20.18f 전체 20자리 확보, 소수점 아래 18자리 출력

	}
//float 값(ko28_f)을 출력할 때 예상했던 값과 약간의 오차가 발생
	// double(ko28_d)은 더 정밀하게 값이 유지됨
	//float → double 변환(ko28_d2) 시, float의 한계를 그대로 유지함


}
