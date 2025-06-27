package chap2;

public class test29 {//클래스 선언 

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		int ko28_i =91234567;  // 정수형 변수 i 선언
		float ko28_f=(float)ko28_i;  // int → float 변환
		int ko28_i2=(int)ko28_f; // float → int 변환 (형 변환으로 데이터 손실 발생)
		//int 32비트 정수형 (최대 약 21억) 손실값이 유지됨 
		double ko28_d=(double)ko28_i; // int → double 변환
		int ko28_i3=(int)ko28_d; // double → int 변환
		
		float ko28_f2 =1.666f; // 변수 설정 
		int ko28_i4=(int)ko28_f2; // float → int 변환 
		System.out.printf("i=%d\n",ko28_i); //출력 손실없음 
		System.out.printf("f=%f i2=%d\n",ko28_f,ko28_i2);//출력 손실 발생 
		System.out.printf("d=%f i3=%d\n",ko28_d,ko28_i3);//출력  문제없음 
		System.out.printf("(int) %f=%d\n",ko28_f2,ko28_i4);//출력 소수점 이하 삭제

	}

}
