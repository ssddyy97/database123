package chap8;
import java.io.*;

public class test10 {
    public static void main(String[] args) throws IOException {
        //  입력 파일 지정
        File ko28_inputFile = new File("C:\\Users\\USER\\Desktop\\myjava\\new.csv"); //파일 객체 설정 
        BufferedReader ko28_br = new BufferedReader(new FileReader(ko28_inputFile));//입력 파일을 읽기 위해 BufferedReader를 생성

        //  출력 파일 지정 (삼성전자 데이터만 저장)
        File ko28_outputFile = new File("C:\\Users\\USER\\Desktop\\myjava\\20150112data.csv"); //파일 객체 설정 
        BufferedWriter ko28_bw = new BufferedWriter(new FileWriter(ko28_outputFile));//출력 파일을 저장하기 위해 BufferedWriter를 생성

        String ko28_readtxt;//문자열 설정
        int ko28_cnt = 0;  // 총 레코드 개수
        int ko28_samsungCnt = 0;  // 삼성전자 데이터 개수

        // 파일을 한 줄씩 읽음
        while ((ko28_readtxt = ko28_br.readLine()) != null) {
            String[] ko28_field = ko28_readtxt.split("%_%"); // 구분자로 분리

            //  "20150112" 데이터를 포함하는 경우만 저장
            if (ko28_field.length > 0 && ko28_field[0].contains("20150112")) {  
            	ko28_bw.write(ko28_readtxt);  // 파일에 저장
            	ko28_bw.newLine();  // 줄바꿈
            	ko28_samsungCnt++;
            }

            ko28_cnt++;  // 전체 레코드 수 증가
        }

        // 📌 리소스 닫기
        ko28_br.close();
        ko28_bw.close();  // 파일 저장 완료
      
        // 📌 결과 출력
        System.out.printf(" 총 레코드 수: %d, 20150112 데이터 수: %d%n", ko28_cnt, ko28_samsungCnt); //총레코드 수 데이터 수 출력 
        System.out.println("20150112 데이터가 20150112.csv 파일에 저장되었습니다."); //파일에 저장되었습니다 출력 
    }
}
