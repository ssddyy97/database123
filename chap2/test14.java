package chap2;

public class test14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ko28_i=0; //초기값 설정 
		String ko28_a="*"; //문자열 *로 출력
		while (true) { // 무한 루프 
			ko28_a=ko28_a+"*"; //문자열 `a`에 `*` 하나 추가
			ko28_i++; //`i` 값 증가
			System.out.println("하나씩 더해보자"+ko28_i+":"+ko28_a); // i 값을 1씩 증가시키면서 문자열과 함께 출력 
			if (ko28_i>=10) break; // i가 10이 되면 break로 루프 종료
			
			
		}
	

		ko28_i=0; //초기값 설정 
		ko28_a="*"; //초기화 
		while(true) { //무한 루프 
			if(ko28_i%2==0) ko28_a=ko28_a+"#"; // i가 짝수면 `#` 추가
			else ko28_a=ko28_a+"*"; // i가 홀수면 `*` 추가
			
			ko28_i++; //`i` 값 증가
			System.out.println("응용했당 "+ko28_i+":"+ko28_a ); // i가 10이 될 때까지 계속 문자열 출력
			if (ko28_i>=10) break; // `i`가 10 이상이면 종료
		}
	}
}



