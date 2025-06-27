package chap8;
import java.io.*;

public class practice1 {
    public static void main(String[] args) throws IOException {
        // 📌 입력 파일 지정
        File f = new File("C:\\Users\\USER\\Desktop\\myjava\\new.csv");
        BufferedReader br = new BufferedReader(new FileReader(f));

        String readtxt;
        int cnt = 0;  // 총 레코드 개수
        int samsungCnt = 0;  // 삼성전자 데이터 개수

        // 📌 파일을 한 줄씩 읽음
        while ((readtxt = br.readLine()) != null) {
            String[] field = readtxt.split("%_%"); // 구분자로 분리

            // 📌 "삼성전자" 데이터를 포함하는 경우만 출력
            if (field.length > 0 && field[0].contains("KR7005930003")) {  
                System.out.println(readtxt);  // "삼성전자" 관련 행만 출력
                samsungCnt++;
            }

            cnt++;  // 전체 레코드 수 증가
        }

        // 📌 리소스 닫기
        br.close();
      
        // 📌 결과 출력
        System.out.printf("📌 총 레코드 수: %d, 삼성전자 관련 데이터 수: %d%n", cnt, samsungCnt);
    }
}