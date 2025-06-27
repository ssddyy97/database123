package chap2;

public class test11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ko28_i=2147483647; //초기값 설정
		System.out.println(ko28_i); //ko28_d+1 출력
		System.out.println(ko28_i+1); //ko28_d+1 출력
		//int는 4바이트(32비트) 정수형이며, 표현 가능한 최대값은 2147483647
		//ko28_i + 1을 하면 최대값을 초과하여 오버플로우 발생.
		//오버플로우 결과: 2147483647 + 1 = -2147483648 (최소값으로 순환됨).
		//더블은 좀더 많은 숫자를 표현한다. 큰숫자는 뒤에 f붙이기
		//단 앞에서부터 15자리까지 유효숫자의 승수로 표현 
		double ko28_d=9223372036854775808.123456f; // double은 8바이트(64비트) 실수형으로 ko28_d을 출력
		
		System.out.printf("%30.10f\n",ko28_d); //ko28_d을 30자리 공간을 확보한 후, 소수점 이하 10자리까지 출력
		System.out.printf("%30.10f\n",ko28_d+1);//ko28_d+1을 30자리 공간을 확보한 후, 소수점 이하 10자리까지 출력 
		
		//float 형도 doulble과 다를바 없음 ... 현 java 버전에서 
		//이전에는 유효숫자가 작았을듯 컴퓨터의 한계
		float ko28_d2=9223372036854775808.123456f; //float은 4바이트(32비트) 실수형으로 ko28_d을 출력 
		
		System.out.printf("%30.10f\n",ko28_d2); //k028_d2의 30자리 공간을 확보한 후, 소수점 이하 10자리까지 출력
		System.out.printf("%30.10f\n",ko28_d2+1);//ko28_d2+1의 30자리 공간을 확보한 후, 소수점 이하 10자리까지 출력
		
	}

}
