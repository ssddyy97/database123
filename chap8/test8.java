package chap8;
import java.io.*;

public class test8 { //클래스 선언 
    public static void main(String[] args) throws IOException {
        // 파일 정제....
        
        // 입력 파일 지정
        File ko28_f = new File("C:\\Users\\USER\\Desktop\\myjava\\day_data\\THTSKS010H00.dat"); //파일 객체 설정 
        BufferedReader ko28_br = new BufferedReader(new FileReader(ko28_f)); //입력 파일(.dat)을 읽기 위해 BufferedReader를 생성

        // 출력 파일 지정
        File f1 = new File("C:\\Users\\USER\\Desktop\\myjava\\new.CSV"); //파일 객체 설정 
        BufferedWriter ko28_bw = new BufferedWriter(new FileWriter(f1));//출력 파일(.CSV)을 저장하기 위해 BufferedWriter를 생성.

        String ko28_readtxt; //문자열 설정 
        int ko28_cnt = 0, ko28_wcnt = 0; //cnt: 읽은 줄 수를 세는 변수
        // wcnt: 출력된(저장된) 줄 수를 세는 변수


        // 파일을 한 줄씩 읽음
        while ((ko28_readtxt = ko28_br.readLine()) != null) {// 파일을 한 줄씩 읽음
            StringBuffer ko28_s = new StringBuffer();  //stringbutter 사용
            String[] ko28_field = ko28_readtxt.split("%_%"); // 구분자로 분리

            // 특정 조건을 만족하는 데이터만 처리
            if (ko28_field.length > 2 && ko28_field[2].replace("^", "").trim().substring(0, 1).equals("A")) {//field[2] 값의 첫 번째 글자가 'A'일 때만 데이터 저장.
            	ko28_s.append(ko28_field[0].replace("^", "").trim());//field[2] 값에서 특수문자 ^을 제거하고 공백을 없앤 후, 첫 글자를 확인

                for (int ko28_j = 1; ko28_j < ko28_field.length; ko28_j++) { //for문 필드의 길이 만큼 증가
                	ko28_s.append(",").append(ko28_field[ko28_j].replace("^", "").trim());//첫 번째 필드는 s.append()를 이용하여 문자열에 추가
                }//나머지 필드는 ,를 붙여 CSV 형식으로 변환하여 추가

                // 결과를 파일에 작성
                ko28_bw.write(ko28_s.toString()); //정제된 데이터를 BufferedWriter를 사용하여 새로운 CSV 파일에 작성
                ko28_bw.newLine(); //줄바꿈을 추가하여 CSV 파일 형식을 유지
                ko28_wcnt++;//출력된 데이터 개수(wcnt) 증가

                // 디버깅용 출력 (주석 처리됨)
                // System.out.printf("write [%d][%d][%s]%n", cnt, wcnt, s.toString());
            }

            ko28_cnt++;
   

        }

        // 리소스 닫기
        ko28_br.close();
        ko28_bw.close();

        // 결과 출력
        System.out.printf("Program End [%d][%d] records%n", ko28_cnt, ko28_wcnt);
    }
}
