package chap6;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class pratice2 { //클래스 선언 

    static Calendar ko28_calt = Calendar.getInstance(); //날짜 변수 생성하기 
    static SimpleDateFormat ko28_sdt = new SimpleDateFormat("YYYY.MM.dd HH:mm:ss"); //시스템 상의 날짜 불러 와서 생성하기 

    // 합계와 평균 값을 저장할 전역 변수
    static int ko28_korsum, ko28_engsum, ko28_matsum, ko28_sumsum;
    static double ko28_avesum;

    // 헤더 출력
    public static void ko28_startprint() {
        System.out.printf("                          성적집계표                           \n"); //성적 집계표 출력 
        System.out.printf("                                 출력일자 : %s \n", ko28_sdt.format(ko28_calt.getTime()));//출력일자 출력 
        System.out.printf("===============================================================\n"); //점선 출력 
        System.out.printf("번호  이름      국어   영어   수학   총점   평균  \n"); //번호 이름 국어 영어 수학 총점 평균 출력 
        System.out.printf("===============================================================\n"); //첨선 출력 
    }

    // 데이터 생성 및 출력
    public static void ko28_story() { //새로운 메소드 설정 
        int ko28_iPerson = 30; // iPerson 값만큼 저장소 생성 
        InputData ko28_inData = new InputData(ko28_iPerson); // 클래스 불러오기 

        // 입력 데이터를 무작위로 생성하여 배열에 저장
        for (int ko28_i = 0; ko28_i < ko28_iPerson; ko28_i++) { //for 문 i는 iPerson까지 
            String ko28_name = String.format("홍길%02d", ko28_i + 1); // 홍길01, 홍길02.. 값 출력 .
            int ko28_kor = (int) (Math.random() * 100); //100안에서 랜덤으로 출력 
            int ko28_eng = (int) (Math.random() * 100);//100안에서 랜덤으로 출력 
            int ko28_mat = (int) (Math.random() * 100);//100안에서 랜덤으로 출력 
            ko28_inData.ko28_SetData(ko28_i, ko28_name, ko28_kor, ko28_eng, ko28_mat); //국어 영어 수학 점수를 랜덤으로 생성하여 저장 
        }

        // 합계 및 평균 저장 변수 초기화
        int ko28_bigsum = 0, ko28_bigkor = 0, ko28_bigeng = 0, ko28_bigmat = 0; //초기값 설정 
        double ko28_bigave = 0; //초기값 설정 

        // 데이터 출력 및 합계 계산
        for (int ko28_i = 0; ko28_i < ko28_iPerson; ko28_i++) { //i는iPerson까지 증가
        	ko28_bigsum += ko28_inData.ko28_sum[ko28_i];// 총합계계산 
        	ko28_bigave += ko28_inData.ko28_ave[ko28_i];//평균 합계 계산 
        	ko28_bigkor += ko28_inData.ko28_kor[ko28_i];//국어 합계 계산 
        	ko28_bigeng += ko28_inData.ko28_eng[ko28_i];//영어 합계 계산 
        	ko28_bigmat += ko28_inData.ko28_mat[ko28_i];//수학 합계계산 

            System.out.printf("%03d  %-8s %5d %5d %5d %6d %7.2f%n",
            		ko28_i + 1, ko28_inData.ko28_name[ko28_i], ko28_inData.ko28_kor[ko28_i], ko28_inData.ko28_eng[ko28_i], ko28_inData.ko28_mat[ko28_i],
            		ko28_inData.ko28_sum[ko28_i], ko28_inData.ko28_ave[ko28_i]);//학생별 성적을 출력하면서 전체 합계를 계산.
        }

        // 과목별 평균 계산
        ko28_korsum = ko28_bigkor; //국어 총합 
        ko28_engsum = ko28_bigeng; //영어 총합 
        ko28_matsum = ko28_bigmat; //수학 총합 
        ko28_sumsum = ko28_bigsum; //합계 총합
        ko28_avesum = ko28_bigave / ko28_iPerson; //평균 합계 

        // 합계 및 평균 출력
        System.out.printf("===============================================================\n"); //점선 출력 
        System.out.printf("현재페이지                                                  \n"); //합계 페이지 출력 
        System.out.printf("합계:           %5d %5d %5d %6d %7.2f\n", ko28_korsum, ko28_engsum, ko28_matsum, ko28_sumsum, ko28_bigave); //과목별 총점 
        System.out.printf("평균:           %5d %5d %5d %6d %7.2f\n", ko28_korsum / ko28_iPerson, ko28_engsum / ko28_iPerson, 
        		ko28_matsum / ko28_iPerson, ko28_sumsum / ko28_iPerson, ko28_avesum);//평균 출력 
    }

    // 메인 실행
    public static void main(String[] args) {
    	ko28_startprint(); //초기 메소드 불러오기 
    	ko28_story(); //메인 메소드 불러오기 
    }
}