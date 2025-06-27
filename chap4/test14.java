package chap4;

import java.text.DecimalFormat;

public class test14 { //클래스 선언 
	
	

public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ko28_item="사과"; //문자열 출력 품목이름 
		int ko28_unit_price=5000;//단가
		int ko28_num=500;//수량
		int ko28_total=0;//합계 
		
		DecimalFormat ko28_df=new DecimalFormat("###,###,###,###,###");//숫자를 3자리마다 ,를 추가하는 형식으로 변환
		System.out.printf("===========================================================\n");//입력값 출력 
		System.out.printf("%20.20s%8.8s%8.8s%8.8s\n", "품목","단가","수량","합계"); //입력값 출력 
		System.out.printf("===========================================================\n"); //입력값 출력 
		
		System.out.printf("%20.20s%10.10s%10.10s%10.10s\n",//%20.20s → 품목을 20자리 확보 후 출력 입력값 출력 
				//%10.10s → 각 숫자를 10자리 확보 후 출력
				//ko28_df.format(값) → 천 단위 , 추가하여 숫자 출력
				ko28_item,ko28_df.format(ko28_unit_price),ko28_df.format(ko28_num), ko28_df.format(ko28_unit_price*ko28_num));//printf 포멧 설정 
		System.out.printf("===========================================================\n"); //입력값 출력 

	}

}
