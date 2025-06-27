package chap5;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class test5 { //클래스 선언 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.printf("           \"국민가게, 다이소\"           \n");//가게 입력값 출력 
		System.out.printf("(주)아성다이소_분당서현점\n");//다이소 점포 이름 입력값 출력 
		System.out.printf("전화:031-702-6016\n");//전화번호 입력값 출력 
		System.out.printf("본사:서울 강남구 남부순환로 2748 (도곡동)\n");//본사 주소 입력값 출력 
		System.out.printf("대표:박정부,신호섭 213-81-52063\n");//대표 이름 입력값 출력 
		System.out.printf("매장:경기도 성남시 분당구 분당로53번길 11\n"); //매장 위치 입력값 출력 
		System.out.printf(" (서현동)\n");
		System.out.printf("=========================================\n");//구별을 위한 별표 입력값 출력 
		System.out.printf("       소비자중심경영(CCM) 인증기업      \n");//인증기업 입력값 출력 
		System.out.printf("     ISO 9001 품질경영시스템 인증기업    \n");//인증기업 입력값 출력 
		System.out.printf("=========================================\n");//구별을 위한 별표 입력값 출력 
		Calendar ko28_calt= Calendar.getInstance();//현재 날씨 및 시간의 공식
		SimpleDateFormat ko28_sdt=new SimpleDateFormat("YYYY.MM.dd HH:mm:ss"); //시간포멧설정 
		SimpleDateFormat ko28_sdfRefund = new SimpleDateFormat("MM월dd일"); //월일 포멧설정
		
		
		Calendar ko28_refundCal = Calendar.getInstance(); //현재날짜
		ko28_refundCal.add(Calendar.DAY_OF_MONTH, 14); //현재날짜에서 14일 후 
        String ko28_refundDate = ko28_sdfRefund.format(ko28_refundCal.getTime()); //변수값 설정 
		
		System.out.printf("      교환/환불 14일(%s)이내,      \n",ko28_refundDate);//교환 환불 가능 일수  입력값 출력 
		System.out.printf("(전자)영수증, 결제카드 지참 후 구입매장에\n");//구앱매장에서 영수증에 관한 지침 입력값 출력
		System.out.printf("가능\n");
		System.out.printf("    포장/가격 택 훼손시 교환/환불 불가   \n");//교환/환불 불가에 대한 입력값 출력
		System.out.printf("      체크카드 취소 시 최대 7일 소요     \n");//체크 카드 취소에 관한 날짜 입력값 출력
		System.out.printf("=========================================\n");//구별을 위한 선의 입력값 출력
		
		DecimalFormat ko28_df = new DecimalFormat("#,###,###,###,###"); //숫자에 콤마 값 설정 
	
		System.out.printf("[POS 1058231]         %s\n", ko28_sdt.format(ko28_calt.getTime())); // 포스에 관한 입력값 출력 후 현재 날짜 입력값 출력 
		System.out.printf("=========================================\n");//구별을 위한 선의 입력값 출력 
		String[]ko28_items= {"퓨어에어 비말차단용마스크","슬라이드식명찰(가로형)","매직흡착 인테리어후크",
				"에끌라 깨끗한 물티슈 150매","VT 리들샷 100페이셜 부여",
				"헬로 데일리 미용티슈 "};//변수설정 상품명 
		int[]ko28_itemcode= {1031615,1008152,1020800,1231221,2346233,5634543}; //상품 코드 설정 
		int[]ko28_price = {3000,1000,1000,2000,5000,2000}; //상품가격 설정 
		int[]ko28_amount = {1,1,1,97,78,1};//수량 설정 
		
		
		int ko28_totalSum=0; //초기값 설정 
		
		
		
		
		
		for(int ko28_i=0; ko28_i<ko28_price.length;ko28_i++){ //for 0부터 price 길이 까지 계산
			int ko28_itemsTot=ko28_price[ko28_i]*ko28_amount[ko28_i]; // 변수 설정 총 아이템 가격
			ko28_totalSum+=ko28_itemsTot;  //규칙 설정 총합에 관한 계산 
			System.out.printf("%10s%6s%4s%8s\n", 
					bblank(ko28_items[ko28_i],23),ko28_df.format(ko28_price[ko28_i]), 
					ko28_df.format(ko28_amount[ko28_i]),ko28_df.format(ko28_itemsTot)); 
			//입력값 출력 상품명 가격 수량 총금액 블랭크로 문자처리 23자리 까지 
			System.out.printf("[%s]\n",ko28_itemcode[ko28_i]); // 상품 코드 한 줄 아래 출력
				
		
			}

		
		double ko28_rate= 0.1;  //세금비율 설정
		int ko28_price1=(int)((ko28_totalSum/(1+ko28_rate))+0.000000001);  //변수 설정 총금액의 합계 나누기 1+세금 비율 나누기  
		int ko28_tax_price=ko28_totalSum-ko28_price1; //변수 설정 총금액에서 세금을 제외한 값을 빼기 
		
		System.out.printf("%-10s%21s\n","            과세합계",ko28_df.format(ko28_price1));//과세 합계입력값 출력 
		System.out.printf("%-10s%21s\n","              부가세",ko28_df.format(ko28_tax_price));// 부가세에 관한 입력값  출력 
		System.out.printf("-----------------------------------------\n");//선을 구별을 위한 별표 입력값 출력
		System.out.printf("%-10s %26s\n","판매합계",ko28_df.format(ko28_totalSum));//판매합계에 관한 입력값 출력
		System.out.printf("=========================================\n");//선을 구별을 위한 별표입력값 출력
		System.out.printf("%-10s %26s\n","신용카드",ko28_df.format(ko28_totalSum));//신용카드 입력값 출력
		System.out.printf("-----------------------------------------\n");//선을 구별을 위한 별표입력값 출력
		System.out.printf("우리카드                 538720**********\n");//카드 번호에 관련된 입력값 출력
		System.out.printf("%-10s%10s\n","승인번호 77982843(0)   승인금액",ko28_df.format(ko28_totalSum));//승인 금액에 관련된 입력값 출력 
		System.out.printf("=========================================\n");//선을 구별을 위한 별표 입력값 출력 
		System.out.printf("      %s 분당서현점     \n", ko28_sdt.format(ko28_calt.getTime()));//입력값 출력
		System.out.printf("상품 및 기타 문의 : 1522-4400\n");//상품 및 기타 문의에 대한 입력값 출력
		System.out.printf("멤버십 및 샵다이소 관련 문의 : 1599-2211\n");//멤버십 및 샵 다이소 관련 문의에 대한 입력값 출력
		System.out.printf("             211280610158231            \n");//바코드의 관한 입력값 출력
		
		
		
		System.out.printf("-----------------------------------------\n");//선을 구별을 위한 별표입력값 출력
		System.out.printf("◈ 다이소 멤버십 앱 또는 홈페이지에 접속하\n");//프로모션을 위한 입력값 출력
		System.out.printf("셔서\n");//입력값 출력
		System.out.printf(" 회원가입 후 다양한 혜택을 누려보세요! ◈\n");//입력값 출력
		}
		

	 public static String bblank(String ko28_str, int ko28_print_len) { //bblank 메서드 설정 
	        String ko28_ret = ""; //문자열 설정 
	        int ko28_prtCnt = 0; //초기값 설정 

	        for (int ko28_i = 0; ko28_i < ko28_str.length(); ko28_i++) { //for 문 .

	            String ko28_a = ko28_str.substring(ko28_i, ko28_i + 1); //문자열 설정 문자열을 한 글자씩 추출
	            if (ko28_a.getBytes().length == 1) {  // 영어(1바이트)
	                if ((ko28_prtCnt + 1) > ko28_print_len) break; //영어 1바이트 
	                ko28_prtCnt += 1;//규칙 설정 
	                ko28_ret += ko28_a;//규칙 설정
	            } else {  // 한글(2바이트)
	                if ((ko28_prtCnt + 2) > ko28_print_len) break; //한글 2바이트 중지
	                ko28_prtCnt += 2;//규칙설정
	                ko28_ret += ko28_a;//규칙설정
	            }
	        }

	        // 부족한 부분을 공백으로 채우기
	        while (ko28_prtCnt < ko28_print_len) { //무한 루프 
	        	ko28_ret += " ";// 출력 길이가 ko28_print_len보다 작다면 공백 추가.
	        	ko28_prtCnt++; //계속 증가
	        }

	        return ko28_ret; //정렬된 상태로 반환 
	    }
	}
		



