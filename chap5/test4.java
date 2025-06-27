package chap5;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.text.DecimalFormat;

public class test4 {//클래스 선언 

	public static void main(String[] args) {
	
		// TODO Auto-generated method stub
		System.out.printf("신용승인\n"); //입력값 출력 
		System.out.printf("단말기 : 2N68665898     전표번호 : 041218\n");//단말기와 전표 입력값 출력
		System.out.printf("가맹점 : 한양김치찌개\n");//가맹점 이름 입력값 출력 
		System.out.printf("주  소 : 경기 성남시 분당구 황새울로351번\n");//주소 입력값 출력 
		System.out.printf("길 10 ,1층\n"); //짤려서 밑으로 나옴 입력값 출력 
		System.out.printf("대표자 : 유창신\n");//대표자 입력값 출력 
		System.out.printf("사업자 : 752-53-00558       TEL : 7055695\n");//사업자와 전화번호 입력값 출력 
		System.out.printf("-----------------------------------------\n");//별표값 입력값 출력 
		
		DecimalFormat ko28_df = new DecimalFormat("#,###"); //1000단위 콤마 포멧 적용


		int ko28_total=33000; //변수 설정 총 결제 금액 
		
	    double ko28_tax_rate= 0.1; //변수 설정 부가세율 10%
		int ko28_price=(int)((ko28_total/(1+ko28_tax_rate))+0.000000001);//변수 설정 총금액의 합계를 나누기 1+세율은 세금이 적용된 값 오차방지를 위해0.000000001을 추가  
		int ko28_tax_price=ko28_total-ko28_price; //변수 설정 총금액에서 빼기 세금이 적용된 값 =부가세 
		
		System.out.printf("%-15s %20s 원\n", "금  액",ko28_df.format(ko28_price));//금액의 입력값 출력 
		System.out.printf("%-14s %20s 원\n", "부가세",ko28_df.format(ko28_tax_price));//부가세에 대한 입력값 출력 
		System.out.printf("%-15s %20s 원\n", "합  계",ko28_df.format(ko28_total));//합계의 입력값 출력 
		System.out.printf("-----------------------------------------\n");//선을 나누는 별표 입력값 출력 
		System.out.printf("우리카드\n");//입력값 출력 
		System.out.printf("카드번호 : 5387-20**-****-4613(s)  일시불\n");// 가드 번호 입력값 출력 
	
		Calendar ko28_calt= Calendar.getInstance(); //현재 날씨 및 시간의 공식 
		SimpleDateFormat ko28_sdt=new SimpleDateFormat("YYYY/MM/dd HH:mm:ss"); //포맷 사용
		
		System.out.printf("거래일시 : %s\n", ko28_sdt.format(ko28_calt.getTime())); //입력값 출력 현재 시간 
		System.out.printf("승인번호 : 70404427\n");//승인 번호의 입력값 출력 
		System.out.printf("거래번호 : 357734873739\n");//거래 번호의 입력값 출력 
		System.out.printf("매입 : 비씨카드사   가맹 : 720068568\n");//매입과 가맹의 입력값 출력 
		System.out.printf("알림 : EDC매출표\n");//알림 매출표의 입력값 출력 
		System.out.printf("문의 : TEL)1544-4700\n");//문의 입력값 출력 
		System.out.printf("-----------------------------------------\n");//선을 나누는 입력값 출력 
		System.out.printf("              * 감사합니다 *             \n");// 입력값 출력 
		System.out.printf("                       표준v2.08_20200212"); //입력값 출력 
		
		
		
		
	}

}
