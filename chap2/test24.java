package chap2;

public class test24 { //클래스 선언 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ko28_url="www.codechobo.com"; //문자열 설정
		
		float ko28_f1=.10f; // 0.10 (앞에 0을 생략할 수 있음)
		float ko28_f2=1e1f; // 1 × 10¹  = 10.0  (지수 표기법)
		float ko28_f3=3.14e3f; // 3.14 × 10³ = 3140.0  (지수 표기법)
		double ko28_d=1.23456789; // double 타입 소수
		
	System.out.printf("f1=%f, %e, %g%n", ko28_f1, ko28_f1,ko28_f1); //출력 %f → 기본 6자리 소수점까지 표시 
	System.out.printf("f2=%f, %e, %g%n", ko28_f2, ko28_f2,ko28_f2); //출력 %f → 기본 6자리 소수점까지 표시 
	System.out.printf("f3=%f, %e, %g%n", ko28_f3, ko28_f3,ko28_f3); //출력 %f → 기본 6자리 소수점까지 표시 
	
	System.out.printf("d=%f%n", ko28_d); //출력 %f → 기본 6자리 소수점까지 표시 
	System.out.printf("d=%14.10f%n", ko28_d);  //출력 %14.10f → 전체 14자리 확보, 소수점 이하 10자리 표시
	
	System.out.printf("[d=1234567890]"); //출력 
	System.out.printf("[%s]%n",ko28_url);//%s->기본 문자열 출력
	System.out.printf("[%20s]%n", ko28_url);//%20s	->오른쪽 정렬(20칸)
	System.out.printf("[%-20s]%n", ko28_url);//%-20s->왼쪽 정렬(20칸)
	System.out.printf("[%.8s]%n", ko28_url);//%.8s	처음 8글자만 출력
	}

}
