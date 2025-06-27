package chap3;

public class test6 {//클래스 선언
	

		public static int taxcal(int ko28_val,int ko28_rate) { 
			// TODO Auto-generated method stub
			int ko28_ret; //반환할 세금 변수 
			
			if( ((double)ko28_val*(double)ko28_rate/100.0)==ko28_val*ko28_rate/100) //조건문  실수(소수점)로 세금을 계산
				ko28_ret=ko28_val*ko28_rate/100; //정수 연산으로 세금을 계산
			else // else문 아닐경우 
				ko28_ret=ko28_val*ko28_rate/100+1; //정수 값 그대로 사용
			return ko28_ret; //리턴 값 올림 처리

		}

		




	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ko28_val =271; //초기값 설정 원래 가격 
		int ko28_rate=3; //초기값 설정  세울 (%)
		
		//우리나라는 세금을 포함한 소비자가격을 기입하는데, 일본가면 세전가격을 소비자가라고 붙여놔서 헷갈린다.
		//100엔이라고 편의점에서 사면 112엔을 받아서 잔돈만 낸다.
		int ko28_tax=taxcal(ko28_val,ko28_rate); // 변수 설정 세금 계산 
		
		System.out.printf("***************************\n"); //입력값 출력 
		System.out.printf("* 단순 세금 계산 *\n"); //입력값 출력 
		System.out.printf("실제 세금 계산: %f\n", ko28_val*ko28_rate/100.0);//입력값 출력 하나라도 double 형식 연산을 하면 실수로 표시,
		System.out.printf("세전가격:%d 세금:%d 세포함가격: %d\n", ko28_val,ko28_tax,ko28_val+ko28_tax);//입력값 출력 
		System.out.printf("***************************\n");//입력값 출력 
	}

}
