package chap6;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class practice4 {

    static Calendar ko28_calt = Calendar.getInstance();
    static SimpleDateFormat ko28_sdt = new SimpleDateFormat("YYYY.MM.dd HH:mm:ss");
    
    static int ko28_N = 200; // 총 데이터 개수
    static int ko28_M = 30;  // 페이지당 출력 개수
    static int ko28_totalPages = (ko28_N + ko28_M - 1) / ko28_M; // 총 페이지 수

    static int ko28_total_kor = 0, ko28_total_eng = 0, ko28_total_mat = 0, ko28_total_sum = 0;
    static double ko28_total_ave = 0;
    
    public static void ko28_startprint() {
        System.out.printf("=======================================================\n");
        System.out.printf(" 번호   이름         국어   영어   수학   총점    평균 \n");
        System.out.printf("=======================================================\n");
    }

    public static void ko28_story(int ko28_pageNumber) {
        int ko28_startIdx = (ko28_pageNumber - 1) * ko28_M;
        int ko28_endIdx = Math.min(ko28_pageNumber * ko28_M, ko28_N);
        int ko28_count = ko28_endIdx - ko28_startIdx;

        InputData ko28_inData = new InputData(ko28_count);

        int ko28_page_kor = 0, ko28_page_eng = 0, ko28_page_mat = 0, ko28_page_sum = 0;
        double ko28_page_ave = 0;

        for (int ko28_i = 0; ko28_i < ko28_count; ko28_i++) {
            String ko28_name = String.format("홍길%03d", ko28_startIdx + ko28_i + 1);
            int ko28_kor = (int) (Math.random() * 100);
            int ko28_eng = (int) (Math.random() * 100);
            int ko28_mat = (int) (Math.random() * 100);
            ko28_inData.ko28_SetData(ko28_i, ko28_name, ko28_kor, ko28_eng, ko28_mat);
        }

        for (int ko28_i = 0; ko28_i < ko28_count; ko28_i++) {
        	ko28_page_sum += ko28_inData.ko28_sum[ko28_i];
        	ko28_page_ave += ko28_inData.ko28_ave[ko28_i];
        	ko28_page_kor += ko28_inData.ko28_kor[ko28_i];
        	ko28_page_eng += ko28_inData.ko28_eng[ko28_i];
        	ko28_page_mat += ko28_inData.ko28_mat[ko28_i];

            System.out.printf(" %03d   %-8s  %5d  %5d  %5d  %6d  %7.2f\n", ko28_startIdx + ko28_i + 1,
                    ko28_inData.ko28_name[ko28_i], ko28_inData.ko28_kor[ko28_i], ko28_inData.ko28_eng[ko28_i],
                    ko28_inData.ko28_mat[ko28_i], ko28_inData.ko28_sum[ko28_i], ko28_inData.ko28_ave[ko28_i]);
        }

        ko28_total_kor += ko28_page_kor;
        ko28_total_eng += ko28_page_eng;
        ko28_total_mat += ko28_page_mat;
        ko28_total_sum += ko28_page_sum;
        ko28_total_ave += ko28_page_ave;
         double meanmat=(ko28_page_mat / ko28_count);
         double meankor=(ko28_page_kor / ko28_count);
         double meaneng=(ko28_page_eng / ko28_count);
         double meanmean=(meanmat+meaneng+meankor)/3;
         double summean=(ko28_total_sum/ ko28_count);
         double totalmeanmat=(ko28_total_mat / ko28_endIdx);
         double totalmeankor=(ko28_total_kor / ko28_endIdx);
         double totalmeaneng=(ko28_total_eng / ko28_endIdx);
         double totalsumeman=(ko28_total_sum/ ko28_endIdx);
         double totalmeanmean=(ko28_total_mat+ko28_total_kor+ko28_total_eng)/3;
        System.out.printf("=======================================================\n");
        System.out.printf("현재페이지\n");
        System.out.printf("합계:              %5d  %5d  %5d  %6d  %7.2f\n", ko28_page_kor, ko28_page_eng, ko28_page_mat, ko28_page_sum, ko28_page_ave / ko28_count);
        System.out.printf("평균:              %5.2f  %5.2f  %5.2f  %6.2f %7.2f\n",meanmat, meankor,
        		meaneng, summean,meanmean);
        System.out.printf("=======================================================\n");
        System.out.printf("누적페이지\n");
        System.out.printf("합계:             %5d  %5d  %5d  %6d  %8.2f\n", ko28_total_kor, ko28_total_eng, ko28_total_mat, ko28_total_sum, ko28_total_ave);
        System.out.printf("평균:             %5.2f  %5.2f  %5.2f  %6.2f  %8.2f\n",  totalmeanmat,
        		totalmeankor, totalmeaneng, totalsumeman,totalmeanmean);
        System.out.printf("=======================================================\n");
    }

    public static void main(String[] args) {
        for (int i = 1; i <= ko28_totalPages; i++) {
            System.out.printf("                   성적집계표                            \n");
            System.out.printf("PAGE : %d                 출력일자 : %s \n", i, ko28_sdt.format(ko28_calt.getTime()));
            ko28_startprint();
            ko28_story(i);
          
        }
    }
}