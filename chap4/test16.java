package chap4;

public class test16 { //클래스 선언 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] ko28_items= {"오징어 땅콩          ", "미국산 한우 A++      ","Morning 버터 200ml"};//문자열 설정 
		
		 
		int[] ko28_item_prc= {2000,40000,2000};// 상품 단가
		int[] ko28_item_qty= {10,2,50};// 상품 수량
		
		System.out.printf("\n\n%25s\n", "곰돌이마트 영수증");//입력값 출력 
		System.out.printf("=================================================================\n");//입력값 출력 
		System.out.printf("%10.10s%10.10s%10.10s%10.10s\n", "품명","단가","수량","합계");//입력값 출력 
		System.out.printf("=================================================================\n");//입력값 출력 
		
		int ko28_totPrc=0;// 총 금액 변수 초기화
		for(int ko28_i=0; ko28_i<ko28_items.length;ko28_i++) {//for 구문 상품 개수만큼 반복
			int ko28_itemTot=ko28_item_prc[ko28_i]*ko28_item_qty[ko28_i];//합계 계산 
			System.out.printf("%9.9s%10.10s%11.11s%14.14s\n", //표형식에 맞게 출력 
				ko28_items[ko28_i],ko28_item_prc[ko28_i],ko28_item_qty[ko28_i],ko28_itemTot); //나열 
			ko28_totPrc=ko28_totPrc+ko28_itemTot; //총 금액 누적 
		}
		
		System.out.printf("=================================================================\n"); //입력값 출력 
		System.out.printf("%20.20s%15s\n", "합계 :",ko28_totPrc);
		System.out.printf("=================================================================\n"); //입력값 출력 
		}
		
	}

