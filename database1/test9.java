package database1;

import java.io.BufferedReader; 
import java.io.File;           
import java.io.FileReader;     
import java.io.IOException;    
import java.sql.Connection;      
import java.sql.DriverManager;   
import java.sql.PreparedStatement; 
import java.sql.SQLException;    

public class test9 { // test9 클래스 시작

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

        //JDBC 드라이버 로드
        Class.forName("com.mysql.cj.jdbc.Driver");

        //MySQL 데이터베이스 연결
        Connection kopo28_conn = DriverManager.getConnection(
                "jdbc:mysql://192.168.23.235:33060/kopoctc?rewriteBatchedStatements=true",
                "root",
                "lleejin71"
        );

        //오토커밋 끄기 (트랜잭션 수동 관리)
        kopo28_conn.setAutoCommit(false);

        //INSERT 쿼리 준비
        String kopo28_insertQuery = "INSERT IGNORE INTO stock (Shortcut_code, date, market_price, high_price, low_price, closing_price, trading_volume, transaction_value) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        //PreparedStatement 생성
        PreparedStatement kopo28_pstmt = kopo28_conn.prepareStatement(kopo28_insertQuery);

        //파일 준비 및 BufferedReader로 읽기
        File kopo28_f = new File("C:\\Users\\USER\\Desktop\\myjava\\new.CSV");
        BufferedReader kopo28_br = new BufferedReader(new FileReader(kopo28_f));

        //필요한 변수 초기화
        String kopo28_readtxt;
        int kopo28_LineCnt = 0; // 총 읽은 줄 수
        int kopo28_batchSize = 10000;  // 배치 크기 1만 건
        int kopo28_batchCnt = 0;       // 현재 배치에 쌓은 건수

        //시작 시간 기록
        long kopo28_startTime = System.currentTimeMillis();

        //파일을 한 줄씩 읽어서 데이터베이스에 삽입
        while ((kopo28_readtxt = kopo28_br.readLine()) != null) {
            String[] kopo28_field = kopo28_readtxt.split(","); // 한 줄을 쉼표로 나누기

            //각 필드를 PreparedStatement에 바인딩
            kopo28_pstmt.setString(1, kopo28_field[2]); // Shortcut_code : C열
            kopo28_pstmt.setString(2, kopo28_field[1]); // date : B열
            kopo28_pstmt.setString(3, kopo28_field[3]); // market_price : D열
            kopo28_pstmt.setString(4, kopo28_field[4]); // high_price : E열
            kopo28_pstmt.setString(5, kopo28_field[5]); // low_price : F열
            kopo28_pstmt.setString(6, kopo28_field[6]); // closing_price : G열
            kopo28_pstmt.setString(7, kopo28_field[11]); // trading_volume : K열
            kopo28_pstmt.setString(8, kopo28_field[12]); // transaction_value : L열

            //배치에 추가
            kopo28_pstmt.addBatch();
            kopo28_batchCnt++;

            //batchSize 만큼 쌓이면 실행 및 커밋
            if (kopo28_batchCnt % kopo28_batchSize == 0) {
            	kopo28_pstmt.executeBatch();
                kopo28_conn.commit();
                System.out.printf("[%d건 배치 실행 및 커밋 완료]\n", kopo28_batchCnt);
            }

            kopo28_LineCnt++; // 총 처리 건수 증가
        }

        //남아있는 데이터 배치 실행
        kopo28_pstmt.executeBatch();
        kopo28_conn.commit();
        System.out.printf("[남은 %d건 배치 실행 및 커밋 완료]\n", kopo28_batchCnt % kopo28_batchSize);

        //종료 시간 기록
        long kopo28_endTime = System.currentTimeMillis();
        long kopo28_elapsedTime = kopo28_endTime - kopo28_startTime; // 전체 소요시간(ms)
        long kopo28_minutes = kopo28_elapsedTime / 1000 / 60; // 분 계산
        long kopo28_seconds = (kopo28_elapsedTime / 1000) % 60; // 초 계산

        //자원 정리 (close 순서 중요)
        kopo28_br.close();
        kopo28_pstmt.close();
        kopo28_conn.setAutoCommit(true); // 다시 오토커밋 모드 복원
        kopo28_conn.close();

        //결과 출력
        System.out.println("\n========= 실행 결과 =========");
        System.out.printf("시작시간(ms): %d\n", kopo28_startTime);
        System.out.printf("종료시간(ms): %d\n", kopo28_endTime);
        System.out.printf("처리레코드 수: %d건\n", kopo28_LineCnt);
        System.out.printf("총 소요시간: %d분 %d초 (%d ms)\n", kopo28_minutes, kopo28_seconds, kopo28_elapsedTime);
    }
}