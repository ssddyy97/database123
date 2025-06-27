package chap6;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class dd { //클래스 변수 

    static Calendar ko28_calt = Calendar.getInstance(); //캘린더 값 불러오기
    static SimpleDateFormat ko28_sdt = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss"); //변수 설정 날짜 형식 

    static int ko28_N = 200; // 총 데이터 개수
    static int ko28_M = 30;  // 페이지당 출력 개수
    static int ko28_totalPages = (ko28_N + ko28_M - 1) / ko28_M; // 총 페이지 수

    static int ko28_total_kor = 0, ko28_total_eng = 0, ko28_total_mat = 0, ko28_total_sum = 0; //국어 영어  수학 점수 총함 학생들의 누적합 
    static double ko28_total_ave = 0; //전체 평균 누적함 

    public static void ko28_startprint() { //메소드 설정 
        System.out.printf("===========================================================\n"); //점선 출력 
        System.out.printf(" 번호   이름           국어     영어    수학    총점   평균\n"); //번호 이름 국어 영어 수학 총점 평균 출력 
        System.out.printf("===========================================================\n"); //점선 출력 
    }

    public static void ko28_story(int ko28_pageNumber) { //매소드 출력 
        int ko28_startIdx = (ko28_pageNumber - 1) * ko28_M; //해당 페이지에서 시작하는 학생의 인덱스 
        int ko28_endIdx = Math.min(ko28_pageNumber * ko28_M, ko28_N); //해당 페이지에서 끝나는 학생의 인덱스 
        int ko28_count = ko28_endIdx - ko28_startIdx; //현재 페이지에서 출력할 학생 수 

        InputData ko28_inData = new InputData(ko28_count); //inputdata인스턴스 생성

        int ko28_page_kor = 0, ko28_page_eng = 0, ko28_page_mat = 0, ko28_page_sum = 0; //초기값설정 
        double ko28_page_ave = 0; //초기값 설정 

        for (int ko28_i = 0; ko28_i < ko28_count; ko28_i++) { //for 문 0부터 ko28_i < ko28_count까지 증가 
            String ko28_name = String.format("홍길%03d", ko28_startIdx + ko28_i + 1); //홍길 001.002~~~~
            int ko28_kor = (int) (Math.random() * 100); //국어 값을 랜덤으로 생성 
            int ko28_eng = (int) (Math.random() * 100); //영어 값을 랜덤으로 생성 
            int ko28_mat = (int) (Math.random() * 100); //수학 값을 랜덤으로 생성 
            ko28_inData.ko28_SetData(ko28_i, ko28_name, ko28_kor, ko28_eng, ko28_mat); //데이터를 호출하여서 저장 
        }

        for (int ko28_i = 0; ko28_i < ko28_count; ko28_i++) { //for 문 0부터 ko28_i < ko28_count까지 증가 
            ko28_page_sum += ko28_inData.ko28_sum[ko28_i]; // 총합의 총합  계산 
            ko28_page_ave += ko28_inData.ko28_ave[ko28_i]; //평균의 총합 계산 
            ko28_page_kor += ko28_inData.ko28_kor[ko28_i];//국어의 총합 계산 
            ko28_page_eng += ko28_inData.ko28_eng[ko28_i]; //영어의 총합 계산
            ko28_page_mat += ko28_inData.ko28_mat[ko28_i]; //수학의 총합 계산 
           
            
            System.out.printf(" %03d   %-10s  %6d  %6d  %6d  %6d %7.2f\n", //이름의 순서와 학생의 성적 출력 
                ko28_startIdx + ko28_i + 1,
                ko28_inData.ko28_name[ko28_i], 
                ko28_inData.ko28_kor[ko28_i], 
                ko28_inData.ko28_eng[ko28_i],
                ko28_inData.ko28_mat[ko28_i], 
                ko28_inData.ko28_sum[ko28_i], 
                ko28_inData.ko28_ave[ko28_i]);
        }

        ko28_total_kor += ko28_page_kor; 
        ko28_total_eng += ko28_page_eng;
        ko28_total_mat += ko28_page_mat;
        ko28_total_sum += ko28_page_sum;
        ko28_total_ave += ko28_page_ave;
  
        double meanKor = (double) ko28_page_kor / ko28_count; //현재 페이지 국어 평균 
        double meanEng = (double) ko28_page_eng / ko28_count; //현재 페이지영어 평균 
        double meanMat = (double) ko28_page_mat / ko28_count; //현재 페이지수학 평균 
        double meanTotal = (meanKor + meanEng + meanMat) / 3; //현재 페이지 평균 더한값의 평균 
        double sumMean = (double) ko28_page_sum / ko28_count; //현재 페이지총합의 평균 

        double totalMeanKor = (double) ko28_total_kor / ko28_endIdx; //누적 페이지 국어 평균 
        double totalMeanEng = (double) ko28_total_eng / ko28_endIdx; //누적 페이지 영어 평균 
        double totalMeanMat = (double) ko28_total_mat / ko28_endIdx; //누적 페이지 수학 평균 
        double totalSumMean = (double) ko28_total_sum / ko28_endIdx; //누적 페이지 총합의  평균
        double totalMeanTotal = ((ko28_total_mat + ko28_total_kor + ko28_total_eng) /(3.0* ko28_endIdx));//평균을 더한 값의 평균 

        System.out.printf("===========================================================\n");//점선 출력 
        System.out.printf(" 현재 페이지 통계\n"); //현재 페이지 출력 
        System.out.printf(" 합계:              %6d  %6d  %6d  %6d  %7.2f\n", //현재 페이지합계;국어 영어 수학 총합 평균 합계 출력 
            ko28_page_kor, ko28_page_eng, ko28_page_mat, ko28_page_sum, ko28_page_ave);
        System.out.printf(" 평균:              %6.2f  %6.2f  %6.2f  %6.2f  %7.2f\n", //현재 페이지 평균: 국어 영어 수학 평균 합계 평균 출력 
            meanKor, meanEng, meanMat, sumMean, meanTotal);
        System.out.printf("===========================================================\n"); //점선 출력 
        System.out.printf(" 누적 페이지 통계\n"); //입력값 출력 
        System.out.printf(" 합계:              %6d  %6d  %6d  %6d  %7.2f\n", 
            ko28_total_kor, ko28_total_eng, ko28_total_mat, ko28_total_sum, ko28_total_ave);//누적 페이지합계;국어 영어 수학 총합 평균 합계 출력 
        System.out.printf(" 평균:              %6.2f  %6.2f  %6.2f  %6.2f  %7.2f\n", 
            totalMeanKor, totalMeanEng, totalMeanMat, totalSumMean, totalMeanTotal); //누적 페이지 평균: 국어 영어 수학 평균 합계 평균 출력
        System.out.printf("===========================================================\n"); //점선 출력 
    }

    public static void main(String[] args) {
        for (int i = 1; i <= ko28_totalPages; i++) { //for 구문  i <= ko28_totalPages 까지  증가 
            System.out.printf("                    성적집계표                            \n"); //입력값 출력 
            System.out.printf("PAGE : %d                 출력일자 : %s \n", i, ko28_sdt.format(ko28_calt.getTime()));//날짜값 출력
            ko28_startprint(); //메소드 출력 
            ko28_story(i); //메소드 출력 
        }
    }
}
