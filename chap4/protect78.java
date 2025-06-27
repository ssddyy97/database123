package chap4;

public class protect78 { //클래스 선언 
    public static void main(String[] args) {
        String[] ko28_items = {"오징어 땅콩", "미국산 한우 A++", "Morning 버터 200ml"}; //문자열 설정 상품이름 
        int[] ko28_item_prc = {2000, 40000, 2000}; //상품 단가
        int[] ko28_item_qty = {10, 2, 50};//수량 

        System.out.printf("\n\n%25s\n", "곰돌이마트 영수증");//입력값 출력 %25s → "곰돌이마트 영수증"을 오른쪽 정렬하여 출력
        System.out.printf("=================================================================\n");//입력값 출력 %-14s → "품명"을 왼쪽 정렬(-) 후 14자리 확보
        System.out.printf("%-14s%10s%10s%11s\n", "품명", "단가", "수량", "합계");//입력값 출력 
        System.out.printf("=================================================================\n");//입력값 출력 %10s, %10s, %11s → "단가", "수량", "합계"를 오른쪽 정렬

        int ko28_totPrc = 0; //초기값 설정 
        for (int ko28_i = 0; ko28_i < ko28_items.length; ko28_i++) { //for 구문 
            int ko28_itemTot = ko28_item_prc[ko28_i] * ko28_item_qty[ko28_i];//상품 총액(합계) = 단가 × 수량 계산
            System.out.printf("%12s%10s%11s%14s\n",//입력값 출력 
                    bblank(ko28_items[ko28_i], 18), ko28_item_prc[ko28_i], ko28_item_qty[ko28_i], ko28_itemTot); //입력값 출력 bblank 메서드 추가 18
            ko28_totPrc += ko28_itemTot;//총가격 누적계산 
        }

        System.out.printf("=================================================================\n");//입력값 출력 
        System.out.printf("%26s%14d\n", "합계 :", ko28_totPrc);//입력값 출력 
        System.out.printf("=================================================================\n");//입력값 출력 
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