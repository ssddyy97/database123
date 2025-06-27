package chap2;

public class test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ko28_i;
		//사칙 연산 순서
		 ko28_i=1+2+3+4;
		System.out.printf("ko28_i=%d\n\n",ko28_i); //ko28의 값을 도출
		
		double k28_a,k28_b,k28_c,k28_x; //float 7자리 수 까지만 double은 16자리까지만 표현할 수 있다 
		
		k28_a=1.0;k28_b=5.0;k28_c=3.0;  //k28_a,b,c 초기값 설정 
		
		k28_x= (-1*k28_b+Math.sqrt(Math.pow(k28_b, 2)-4*k28_a*k28_c) ) / 2*k28_a; // 근의 공식의 코딩 표현 방식 
		
		int k28_xx; double k28_y,k28_z; //int k28을 실수형으로 설정 double 정수형으로 설정
		k28_xx=10/3; k28_y=10/3; k28_z=10/3.; //자연수 정수 실수  %f 소수점 아래 6까지 출력 나눗셈을 표현한 공식 
		
		System.out.printf("k28_xx=%d, k28_y=%f, k28_z=%f\n\n", k28_xx,k28_y,k28_z); //k28 _xx, y,z값을 도출 
		
		k28_xx=10/3*3; k28_y=10/3*3; k28_z=10/3.*3; //자연수 정수 실수  %f 소수점 아래 6까지 출력 나눗셈을 표현한 공식에 3을 곱하기 
		
		System.out.printf("k28_xx=%d, k28_y=%f, k28_z=%f\n\n", k28_xx,k28_y,k28_z);// k28_xx,y,z값을 도출
		
		k28_y=0.1; //k28_y의 값의 설정
		System.out.printf("k28_y=%20.10f\n\n",k28_y);
		//소수점 아래를 정확히 표시하라고 하면 연산 오차가 보인다.
		//0.1은 10 진수로는 소수점 첫째짜ㅣ리가 0.1----로 깔끔하게 표현되지만
		//0.1을 2진수로 표현(컴터 내부)하면 2진수에는
		//마치 파이 원주율 처럼 무한소수로 깔끔히 표현할 수 없다.
		//그러므로 연산을 많이하면 미세한 오차가 발생한다.
		// 포멧팅을 %30.20 f 같이 소수점 아래를 정확히 표시하라고 하면 오차가 보이고 
		// %f와 같이 두루뭉실하게 표현하면 작은 오차를 보정하며 보여준다
		k28_y=0; //k28_y의 값의 설정 
		for(ko28_i=0;ko28_i<10;ko28_i++) k28_y=k28_y+0.1; //for 구문에서 초기값 , 종료 여부 , 종료 값을 설정
		System.out.printf("10 k28_y=%30.20f k28_y=%f\n\n",k28_y,k28_y); //전체를 30짜리를 소수점 9자리인 k28_y 값의 도출 
		
		k28_y=0; //k28_y의 값의 설정 
		for(ko28_i=0; ko28_i<100;ko28_i++) k28_y=k28_y+0.1; //for 구문에서 초기값 , 종료 여부 , 종료 값을 설정 
		System.out.printf("100 k28_y=%30.20f k28_y=%f\n\n", k28_y,k28_y);  // 전체를 30짜리를 소수점 9자리인 k28_y 값의 도출 
		
		k28_y=0; //k28_y의 값의 설정 
		for(ko28_i=0;ko28_i<1000;ko28_i++) k28_y=k28_y+0.1; //for 구문에서 초기값, 종료 여부, 종료 값을 설정 
		System.out.printf("100 k28_y=%30.20f k28_y=%f\n\n", k28_y,k28_y); // 전체를 30짜리를 소수점 9자리인 k28_y 값의 도출 
		
		k28_y=0; //k28_y의 값의 설정 
		for(ko28_i=0;ko28_i<100000;ko28_i++) k28_y=k28_y+0.1;//for 구문에서 초기값, 종료 여부 , 종료 값을 설정 
		System.out.printf("100 k28_y=%30.20f k28_y=%f\n\n", k28_y,k28_y); // 전체를 30짜리를 소수점 9자리인 k28_y 값의 도출 
		
// 부울대수에서 and는 %%, or는 ||, not은 !임을 명심 
//단 비트 연산자는 and &, or |, not은 ^이다 한개임을 명심..
// 즉 if문에서 && 두개 써야 되는걸 &한개 써서 원치않는 결과 주의
boolean k28_e,k28_f,k28_g; // boolean 변수 선언 3개
k28_e=true; k28_f=false; //true와 false 값을 지정 
System.out.printf("and=%b or=%b, not k28_e=%b, not k28_f=%b\n\n",k28_e&&k28_f,k28_e||k28_f, !k28_e, !k28_f); 
// k28_e and k28_f,k28_e or k28_f, not k28_e, not k28_f 결과 값 도출

if (k28_e&&k28_f) System.out.printf("and ok\n"); //조건문 설정  true 일때 출력
if (k28_e||k28_f) System.out.printf("or ok\n"); //조건문 설정  true 일때 출력
if (k28_e||!k28_f) System.out.printf("melong ok\n"); //조건문 설정  true 일때 출력
	}
}
