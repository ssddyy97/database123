package chap3;

import java.text.DecimalFormat;

public class test11 { //클래스 선언 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  int ko28_i_totalcom = 5000; // 총 수수료 
	        double ko28_usd = 100.5; // 환전한 미화 금액 
	        double ko28_ComperOne = 1320.5; // 달러당 수수료 
	        int ko28_MYWon = 150000; // 환전할 한화 금액
	        double ko28_MoneyEx = 1300; // 환율 
	        int ko28_remain; // 잔돈 계산 변수
DecimalFormat ko28_df= new DecimalFormat("###,###,###,###,###"); //DecimalFormat을 사용하여 큰 숫자에 콤마 추가

System.out.printf("*****************************************\n"); //입력값 출력 
System.out.printf("*		콤마찍기,날짜적용				  *\n");//입력값 출력

System.out.printf("총 수수료: %s원=> 미화:	%s달러, 달러당 수수료:	%f원\n", //입력값 출력
		ko28_df.format(ko28_i_totalcom),//ko28_df.format을 사용하여 숫자에 콤마 추가
		ko28_df.format(ko28_usd),//ko28_df.format을 사용하여 숫자에 콤마 추가
		ko28_ComperOne );//ko28_ComperOne은 소수점 그대로 출력



ko28_remain=(int) (ko28_MYWon-ko28_usd*ko28_MoneyEx- ko28_i_totalcom); //잔돈 = 환전할 원화 - (환전한 미화 × 환율) - 총 수수료
System.out.printf("총 한화환전 금액 %s원=> 미화: %s달러, 수수료칭구:%s원 잔돈: %s원\n",
		ko28_df.format(ko28_MYWon), ko28_df.format(ko28_usd), ko28_df.format(ko28_i_totalcom), ko28_df.format(ko28_remain) );//입력값 출력 


}
	}
