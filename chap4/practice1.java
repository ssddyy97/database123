package chap4;

public class practice1 {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ko28_jumin="123456-1234567"; //문자열 변수 설정 
		switch(ko28_jumin.charAt(7)) { //주민등록번호의 7번째 자리 값에 따라 switch문 실행
		case '1':// 첫번째 경우
			System.out.printf("20세기전 태어난 남자 사람\n");// 입력값 출력 
			break;//중지
		case '2':// 두번째 경우
			System.out.printf("20세기전 태어난 여자 사람\n"); //입력값 출력 
			break;//중지
		case '3':// 세번째 경우
			System.out.printf("20세기후 태어난 남자 사람\n"); //입력값 출력 
			break;//중지
		case '4':// 네번째 경우
			System.out.printf("20세기후 태어난 여자 사람\n"); //입력값 출력 
			break;//중지
		default :// 다섯번째 경우
			System.out.printf("사람\n"); //입력값 출력 
			break;//중지
		}

	}

}
