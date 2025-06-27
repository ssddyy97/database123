package chap3;

public class test5 { //클래스 설정 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ko28_MyVal=14/5; // 초기값 설정   이값은 2.8이다. 소수점 이하 버리면 2, 반올림하면 3이다.
		
		System.out.printf("#5-1 :%d\n",ko28_MyVal);//입력 값 출력 그냥 연산하고 넣으면 버려진다
		
		double ko28_MyValF; // doubl형태로 형변환 
		
		//머리를 쓰면 저놈을 실수형 ( float,double 형태로 형변환) 계산ㅇ르 한후 0.5를 더한다음 
		//정수형 형변환을 하면 반올림 처리가 된다.
		//실수(Real number)가 뭔지 모르면 집에 가든지 . 몰래 초 중등 수학책을 얼른 보고 오자
		
		ko28_MyValF=14/5; //초기값 설정 
		System.out.printf("#5-2: %f\n", ko28_MyValF); //입력값 출력 형 연산이 되엇을 줄 알았지 ?
		

		ko28_MyValF=14.0/5; //초기값 설정 형태의 표시를 해야 결과의 실수가 나온다 
		System.out.printf("#5-3: %f\n", ko28_MyValF);// 입력값 출력 
		
 
		ko28_MyValF=(14.0)/5+0.5;//초기값 설정 실수형 계산에서 0.5를 더해보자 
		System.out.printf("#5-4: %f\n", ko28_MyValF);//입력값 출력 
		
		ko28_MyValF=(int)((14.0)/5+0.5);//초기값 설정 실수형 계산을 하고 정수형 형변환을 하자.
		System.out.printf("#5-5: %f\n", ko28_MyValF);//입력값 출력 
		
		


	}

}
