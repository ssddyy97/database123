package chap2;

public class test23 { //클래스 선언

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte  ko28_b=1;   // byte 타입 변수 (1바이트 정수)
		short ko28_s=2;	 // short 타입 변수 (2바이트 정수)
		char  ko28_c='A';  // char 타입 변수 (문자 'A')
		
		int ko28_finger =10;   // 정수형 int 변수
		long ko28_big= 100000000000L; // long 타입 변수 (큰 정수는 L을 붙여야 함)
		long ko28_hex=0xFFFFFFFFFFFFFFFFL; // 16진수 long (L 붙여야 함)
		
		int ko28_octNum =010; // 8진수 (접두사 0 사용)
		int ko28_hexNum= 0x10; // 16진수 (접두사 0x 사용)
		int ko28_binNum= 0b10;  // 2진수 (접두사 0b 사용)
		
		System.out.printf("b=%d%n",ko28_b);//출력 
		System.out.printf("s=%d%n",ko28_s); //출력
		System.out.printf("c=%c,%d %n",ko28_c,(int)ko28_c); //출력	
		System.out.printf("finger=[%5d]%n",ko28_finger);// 오른쪽 정렬 (5칸)
		System.out.printf("finger=[%-5d]%n",ko28_finger); // 왼쪽 정렬 (5칸)
		System.out.printf("finger=[%05d]%n",ko28_finger); // 5자리 숫자, 앞을 0으로 채움
		System.out.printf("big=%d%n",ko28_big); //%d → long 값 출력
		System.out.printf("hex=%#x%n",ko28_hex);//%#x → 16진수 출력 시 앞에 0x를 붙여서 표시
		System.out.printf("octNum=%o,%d%n",ko28_octNum,ko28_octNum);//8진수(%o)와 10진수(%d) 출력
		System.out.printf("octNum=%x,%d%n",ko28_hexNum,ko28_hexNum);//16진수(%x)와 10진수(%d) 출력
		System.out.printf("octNum=%s,%d%n",Integer.toBinaryString(ko28_binNum),ko28_binNum);//2진수 변환(Integer.toBinaryString()) 후 출력
		
		
	
		}

}
