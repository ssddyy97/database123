package chap7;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class test2 { //클래스 선언 

	public static void main(String[] args) {

		
		
		 DecimalFormat ko28_df = new DecimalFormat("#,###,###,###,###");
		
		//구매 입력 날짜 입력값 및 포스값 번호 출력 
		System.out.printf("-----------------------------------------\n"); //구분을 위한 선 입력값 출력 
		System.out.printf("  상 품 명         단  가  수량    금  액\n");//상품명 단가 수량 금액 입력값 출력
		System.out.printf("-----------------------------------------\n");//구분을 위한 선입력값 출력
		 //변수설정 숫자에 콤마 찍기 
				
		String[]ko28_items= {
				"엄마는외계인아이스크림","글루타치온MAX 1000mg 120정", "구아검 가수분해물 플러스 200g 분말 가루","폴리코사놀 쿠바산 54mg ULTRA MAX 60정 ","세인트 존스워트 테아닌 정 60정",
				"블루바이오 식물성 멜라토닌 멜라솔브드 600mg 60정","포도추출물 레스베라트롤 MAX 600mg","미슬토 겨우살이 추출물 MAX 600mg 60정","식약청 바나바잎 추출물 플러스 600mg60정 ","모로오렌지 글루타치온 콜라겐 600mg 60정",
				"식약처 양춘사 추출물 MAX 600mg 60정 사인 축사씨 축사밀","아누카사과추출90%90정600mg","환타 포도","환타 오렌지","처음처럼",
				"위스키","성인잡지","더위사냥","돼지바","빼빼로",
				"버섯스프","밀크티","흑설탕","볶음김치","하리보젤리",
				"짱구","스타킹","커피밀크","액상과당"}; //상품명 변수 설정
		
		int []ko28_price1=ko28_price[].replace(700,600);
		
		int[]ko28_price= {700,679,50,33,250,3,5,4,6,49800, //변수 설정 상품가격 
				420,600,50,500,60,20,100,400,40,90,
				2800,10,50,20,400,50,92,670,4};

		int[]ko28_amount = {2,2,70,1,2,15,7,27,8,2, //변수 설정 상품량
				6,4,1,6,1,8,9,12,1,5,
				2,1,2,6,7,1,4,3,2};
	
		boolean[] ko28_taxFree = { //면세 물품 설정  true-> 면세 물품
	            false, true, false, false, false,
	            false, true, false, true, true,
	            true, false, false, false, false, 
	            false, true, false, false, false,
	            false, false, true, false, false,
	            true, false,false,true};
				
		
		int ko28_taxabletotal=0; //변수 초기화
		int ko28_taxfreetotal=0; //변수 초기화
        int ko28_totalSum=0; //변수 초기화
		int ko28_totalQuantity=0; //변수 초기화
		
		

		for(int ko28_i=0; ko28_i<ko28_items.length;ko28_i++){ //for 구문 0부터 상품의 길이까지 증가
			int ko28_itemsTot=ko28_price[ko28_i]*ko28_amount[ko28_i]; //상품의 가격
			String ko28_itemName = ko28_taxFree[ko28_i] ? "*" + ko28_items[ko28_i] :" "+ko28_items[ko28_i];//문자열 설정 
			//면세 품목(* 표시)과 과세 품목을 구분하여 출력
			 if (ko28_taxFree[ko28_i]) {//if 문 true라면
				 ko28_taxfreetotal += ko28_itemsTot; // 세금 면제 상품 총 가격을 누적
	            } else {//false이면
	            	ko28_taxabletotal += ko28_itemsTot; // 과세 대상 상품 총 가격
	            }
				System.out.printf("%s%10s%3s%12s\n", 
						bblank(ko28_itemName,16),ko28_df.format(ko28_price[ko28_i]),ko28_df.format(ko28_amount[ko28_i]),
						ko28_df.format(ko28_itemsTot));//입력값 출력 상품명 단가 수량 금액 설정 블랭크를 사용하여서 16까지 정해주기
				
				ko28_totalSum+=ko28_itemsTot; //누적해서 상품의 가격을 더함
				ko28_totalQuantity += ko28_amount[ko28_i]; //품목의 수량을 더함
				int ko28_i2=ko28_i+1; //ko28_i는 0이라서 +1 설정 
					if(ko28_i2%5==0)System.out.printf("-----------------------------------------\n");//구분을 위한 선 출력
				} //if문 i2가 5의 배수일때 점선 출력 
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
