package chap6;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class practice3 { //클래스 선언

    static Calendar ko28_calt = Calendar.getInstance(); //객체 설정 현재 시스템의 날짜 및 시간을 가져옴 
    static SimpleDateFormat ko28_sdt = new SimpleDateFormat("YYYY.MM.dd HH:mm:ss");//날짜 형식을 **"YYYY.MM.dd HH:mm:ss"**로 설정.

    // 합계와 평균 값을 저장할 전역 변수
    static int ko28_korsum, ko28_engsum, ko28_matsum, ko28_sumsum; //현재 페이지 성적 합계
    static double ko28_avesum;
    static int ko28_total_kor = 0, ko28_total_eng = 0, ko28_total_mat = 0, ko28_total_sum = 0; //모든 페이지의 누적 합계.
    static double ko28_total_ave = 0; //평균 누적 합계
    static int ko28_pageks=0; //평균 계산을 위한 누적 변수 
    static int ko28_pagees=0;//평균 계산을 위한 누적 변수 
    static int ko28_pagema=0;//평균 계산을 위한 누적 변수 
    static int ko28_pagess=0;//평균 계산을 위한 누적 변수 
   
    

    // 헤더 출력
    public static void ko28_startprint() { //메소드 설정 
        
        System.out.printf("================================================\n"); //점선 출력 
        System.out.printf("번호  이름      국어   영어   수학   총점   평균  \n"); //번호 이름 국어 영어 수학 총점 평균 출력 
        System.out.printf("================================================\n"); //점선 출력
    }

    // 데이터 생성 및 출력
    public static void ko28_story() { //메소드 설정 
        int ko28_iPerson = 30; // iPerson 값만큼 저장소 생성 
        InputData ko28_inData = new InputData(ko28_iPerson); // InputData 인스턴스 설정 

        // 입력 데이터를 무작위로 생성하여 배열에 저장
        for (int ko28_i = 0; ko28_i < ko28_iPerson; ko28_i++) { //0부터 
            String ko28_name = String.format("홍길%02d", ko28_i + 1); // 홍길01, 홍길02...
            int ko28_kor = (int) (Math.random() * 100); //국어 성적 랜덤 생성 
            int ko28_eng = (int) (Math.random() * 100); //영어 성적 랜덤 생성 
            int ko28_mat = (int) (Math.random() * 100); //수학 성정 랜덤 생성 
            ko28_inData.ko28_SetData(ko28_i, ko28_name, ko28_kor, ko28_eng, ko28_mat); //저장 
        }

        // 합계 및 평균 저장 변수 초기화
        int ko28_bigsum = 0, ko28_bigkor = 0, ko28_bigeng = 0, ko28_bigmat = 0; //초기값 설정 
        double ko28_bigave = 0; //초기값 설정 

        // 데이터 출력 및 합계 계산
        for (int ko28_i = 0; ko28_i < ko28_iPerson; ko28_i++) { //for 문 0부터 ko28_iPerson값까지 증가
        	ko28_bigsum += ko28_inData.ko28_sum[ko28_i]; //총점
        	ko28_bigave += ko28_inData.ko28_ave[ko28_i]; //총 평균 
        	ko28_bigkor += ko28_inData.ko28_kor[ko28_i]; //총 국어 성적
        	ko28_bigeng += ko28_inData.ko28_eng[ko28_i]; //총 영어 성적 
        	ko28_bigmat += ko28_inData.ko28_mat[ko28_i]; //총 수학 성적 
            
        	ko28_total_kor += ko28_korsum; //평균 페이지당  국어 총합 
        	ko28_total_eng += ko28_engsum;//평균 페이지당 영어 총합 
        	ko28_total_mat += ko28_matsum; //평균 페이지당 수학 총합 
        	ko28_total_sum += ko28_sumsum; //평균 페이지당 총합 총합 
        	ko28_total_ave += ko28_avesum; //평균 페이지당 평균 총합 

            System.out.printf("%03d  %-8s %5d %5d %5d %6d %7.2f%n",
            		ko28_i + 1, ko28_inData.ko28_name[ko28_i], ko28_inData.ko28_kor[ko28_i], 
            		ko28_inData.ko28_eng[ko28_i], ko28_inData.ko28_mat[ko28_i], ko28_inData.ko28_sum[ko28_i], ko28_inData.ko28_ave[ko28_i]); //학생별 성적 출력하면서 전체 합계 계산 
        }

        // 과목별 평균 계산
        ko28_korsum = ko28_bigkor;
        ko28_engsum = ko28_bigeng;
        ko28_matsum = ko28_bigmat;
        ko28_sumsum = ko28_bigsum;
        ko28_avesum = ko28_bigave / ko28_iPerson;
        ko28_pageks+=(ko28_korsum / ko28_iPerson);
        ko28_pagees+=(ko28_engsum / ko28_iPerson);
        ko28_pagema+=(ko28_matsum / ko28_iPerson);
        ko28_pagess+=(ko28_sumsum / ko28_iPerson);
        // 합계 및 평균 출력
        System.out.printf("================================================\n"); //점선 출력 
        System.out.printf("현재페이지                                                  \n"); //현재 페이지 출력 
        System.out.printf("합계:           %5d %5d %5d %6d %7.2f\n", ko28_korsum, ko28_engsum, 
        		ko28_matsum, ko28_sumsum, ko28_bigave); //현재 페이지의 합계 계산 
        System.out.printf("평균:           %5d %5d %5d %6d %7.2f\n", ko28_korsum / ko28_iPerson, 
        		ko28_engsum / ko28_iPerson, ko28_matsum / ko28_iPerson, ko28_sumsum / ko28_iPerson, ko28_avesum); //현재 페이지의 평균 계산 
    }

    // 메인 실행
    public static void main(String[] args) {
    	
    	int ko28_totalPages=30; //페이지 개수 설정  
    	
    	for(int ko28_i=1; ko28_i<=ko28_totalPages; ko28_i++) { //for문 1부터  ko28_totalPages개수 까지 증가 
  
    		
    	System.out.printf("                    성적집계표                           \n");	//성적 집계표 출력 
    	System.out.printf("PAGE : %d         출력일자 : %s \n",ko28_i, ko28_sdt.format(ko28_calt.getTime()));	//날짜 출력 
    	ko28_startprint();
    	ko28_story();
        System.out.printf("================================================\n"); //점선 출력 
    	}
        double ko28_final_avg = (ko28_pageks / (ko28_totalPages)+ko28_pagees / (ko28_totalPages)+ko28_pagema/ (ko28_totalPages))/3; //누적 페이지 국어 평균+수학 평균 +영어평균 나누기 3 설정 
        
   
       
        System.out.printf("누적페이지\n"); //누적페이지 출력 
        System.out.printf("================================================\n"); //점선 출력 
        System.out.printf("합계:   %7d %7d %7d %7d %8.2f\n", ko28_total_kor, ko28_total_eng, ko28_total_mat, ko28_total_sum, ko28_total_ave); //누적 페이지 합계 출력 
        System.out.printf("평균:   %7d %7d %7d %7d %8.2f\n", ko28_pageks / (ko28_totalPages), ko28_pagees / (ko28_totalPages), 
        		ko28_pagema/ (ko28_totalPages), ko28_pagess / (ko28_totalPages), ko28_final_avg); //누적 페이지 평균 출력 
        System.out.printf("================================================\n"); //점선 출력 
        }
 
    }
