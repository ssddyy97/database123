package chap2;

public class practice4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ko28_a="12345"; //문자열 "12345" 선언
		int ko28_i=Integer.parseInt(ko28_a); // 문자열 a를 정수로 변환
		
		System.out.printf("문자를 숫자로 %d (%d) \n", ko28_i, ko28_i+10);//i + 10 → 변환된 숫자 12345에 10을 더한 값 12355 출력
		
		
		ko28_a=String.format("%d",  ko28_i); //정수 12345를 다시 문자열 "12345"로 변환
		
		System.out.printf("숫자를 문자로 %s (%s) \n", ko28_a,ko28_a+"abcde");// 출력 "abcde"를 더하면, 문자열 "12345abcde"로 연결
		
		
	}


}


