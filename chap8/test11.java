package chap8;
import java.io.*;

public class test11 { //클래스 선언
    public static void main(String[] args) throws IOException {
        // 입력 파일 지정
        File ko28_inputFile = new File("C:\\Users\\USER\\Desktop\\myjava\\samsung_data.csv"); //파일 객체 생성 
        BufferedReader ko28_br = new BufferedReader(new FileReader(ko28_inputFile)); //파일을 읽기 위한 BufferedReader 생성

        String ko28_readtxt; //문자열 설정 
        int ko28_cnt = 0;  // 총 레코드 개수
        int ko28_year2015Cnt = 0;//2015년도 데이터 개수 초기값 

        double ko28_globalMax = Double.MIN_VALUE;  // 2015년도 종가 기준 최대값 초기화
        double ko28_globalMin = Double.MAX_VALUE;  // 2015년도 종가 기준 최소값 초기화

        String ko28_maxDate = ""; // 최댓값 날짜
        String ko28_minDate = ""; // 최솟값 날짜

        //  파일을 한 줄씩 읽음
        while ((ko28_readtxt = ko28_br.readLine()) != null) {
            String[] ko28_field = ko28_readtxt.split(","); // CSV 형식에서 ',' 기준으로 분리

            //  날짜 값이 존재하고 2015년도인지 확인
            if (ko28_field.length > 3 && ko28_field[1].startsWith("2015")) { // 종가 데이터는 4번째 필드 (field[3])
            	ko28_year2015Cnt++;
                
                try {
                    double ko28_closePrice = Double.parseDouble(ko28_field[3].trim()); // 종가 값을 소수점 포함 숫자로 변환
                    String ko28_currentDate = ko28_field[1].trim(); // 현재 데이터의 날짜

                    //  최대값과 날짜 갱신
                    if (ko28_closePrice > ko28_globalMax) {
                    	ko28_globalMax = ko28_closePrice;
                    	ko28_maxDate = ko28_currentDate; // 최댓값 날짜 갱신
                    }

                    //  최소값과 날짜 갱신
                    if (ko28_closePrice < ko28_globalMin) { 
                    	ko28_globalMin = ko28_closePrice;
                    	ko28_minDate = ko28_currentDate; // 최솟값 날짜 갱신
                    }

                } catch (NumberFormatException e) {
                    // 종가 값이 숫자가 아닐 경우 무시
                }
            }

            ko28_cnt++;  // 전체 레코드 수 증가
        }

        ko28_br.close(); //리소스 해제 

        // 📌 결과 출력
        if (ko28_year2015Cnt > 0) {
            System.out.printf("총 레코드 수: %d, 2015년도 데이터 개수: %d\n", ko28_cnt, ko28_year2015Cnt); // 총레코드 수, 데이터 개수  출력 
            System.out.printf("2015년도 종가 기준 최솟값: %.2f 날짜 :%s\n", ko28_globalMin, ko28_minDate); //종가 기준 최솟값 날짜 출력 
            System.out.printf("2015년도 종가 기준 최댓값: %.2f 날짜 :%s\n", ko28_globalMax, ko28_maxDate); //종가 기준 최댓값 날짜 출력 
        } else {
            System.out.println("2015년도 데이터가 존재하지 않습니다."); //존재하지 않을때 출력 
        }
    }
}
