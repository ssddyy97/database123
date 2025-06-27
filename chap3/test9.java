package chap3;

public class test9 { //클래스 선언 
    public static void main(String[] args) {
        String[] ko28_item = {"맛동산", "웨하스", "쨩셔요", "라면땅", "사브레"};// 문자열 설정 과자이름 배열
        int[] ko28_price = {1000, 2000, 3000, 2500, 1450}; //숫자열 초기값 설정  개당 가격 배열
        int[] ko28_amount = {10, 2, 1, 3, 5}; //숫자열 초기값  설정  구매한 수량 배열
        double ko28_tax_rate = 0.1; //초기값 설정 세율
        int ko28_total_sum = 0; // 숫자열 초기값 설정  총 금액 저장 변수 


        System.out.printf("********************************************\n");//입력값 출력
        System.out.printf("                너가 지른 과자들             \n"); //입력값 출력 
        System.out.printf("--------------------------------------------\n");// 입력값 출력 
        System.out.printf(" 항목        단가       수량       합계      \n"); //입력값 출력 
        System.out.printf("--------------------------------------------\n"); // 입력값 출력 

        for (int ko28_i = 0; ko28_i < ko28_item.length; ko28_i++) { // for 문을 사용해 모든 과자의 가격과 수량을 곱하여 개별 합계를 계산

            int ko28_sum = ko28_price[ko28_i] * ko28_amount[ko28_i];// 초기값 설정 
            ko28_total_sum = ko28_total_sum + ko28_sum; //규칙 설정 개당 가격 × 수량 = 개별 과자의 총 가격
            System.out.printf(" %.5s   %7d   %7d   %10d\n", ko28_item[ko28_i], ko28_price[ko28_i], ko28_amount[ko28_i], ko28_sum);//입력값 출력 
            //총 금액 누적
        } //%.5s: 과자 이름을 5글자까지만 출력 ,%7d: 가격, 수량을 우측 정렬(7칸), %10d: 합계를 우측 정렬(10칸)

        System.out.printf("--------------------------------------------\n");//입력값 출력 
        System.out.printf(" 지불 금액:       %23d 원\n", ko28_total_sum); //입력값 출력  %23d: 숫자를 23칸 우측 정렬

        int total_net_price = (int) (ko28_total_sum / (1 + ko28_tax_rate)); // 초기값 설정 과세금액의 계산 
        System.out.printf(" 과세 금액:       %23d 원\n", total_net_price); // 입력값 출력 
        int ko28_tax = ko28_total_sum - total_net_price; //초기값 설정 세금 계산 
        System.out.printf(" 세    금:       %23d  원\n", ko28_tax); //입력값 출력 
        System.out.printf("********************************************\n"); //입력값 출력 
    }
}