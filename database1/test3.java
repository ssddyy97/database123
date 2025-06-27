package database1; // 패키지 선언

import java.io.BufferedReader;  // 텍스트 파일을 효율적으로 읽기 위한 클래스
import java.io.File;            // 파일 객체를 다루기 위한 클래스
import java.io.FileReader;      // 파일을 읽기 위한 클래스
import java.io.IOException;     // 입출력 예외 처리를 위한 클래스
import java.sql.Connection;     // DB 연결 객체
import java.sql.DriverManager;  // DB 연결을 위한 클래스
import java.sql.SQLException;   // SQL 예외 처리를 위한 클래스
import java.sql.Statement;      // SQL 실행을 위한 클래스

public class test3 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

        // MySQL JDBC 드라이버를 메모리에 로드
        Class.forName("com.mysql.cj.jdbc.Driver");

        // MySQL 데이터베이스 연결 설정 (IP주소:포트/DB명, 사용자명, 비밀번호)
        Connection kopo28_conn = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:33067/kopoctc",
                "root",
                "lleejin71"
        );

        // SQL 실행을 위한 Statement 객체 생성
        Statement kopo28_stmt = kopo28_conn.createStatement();

        // CSV 파일 객체 생성
        File kopo28_f = new File("C:\\Users\\USER\\Desktop\\myjava\\무료와이파이정보.CSV");

        // 파일을 읽기 위한 BufferedReader 객체 생성
        BufferedReader kopo28_br = new BufferedReader(new FileReader(kopo28_f));

        String readtxt;

        // 첫 번째 줄(헤더)을 읽고, 내용이 없으면 종료
        if ((readtxt = kopo28_br.readLine()) == null) {
            System.out.printf("빈 파일입니다\n");
            kopo28_br.close();
            return;
        }

        int kopo28_LineCnt = 0;  // 읽은 줄 수 카운트

        // 파일 끝까지 한 줄씩 읽음
        while ((readtxt = kopo28_br.readLine()) != null) {
            // 각 줄을 콤마(,) 기준으로 분리
            String[] kopo28_field = readtxt.split(",");

            // 필드 개수가 16개 미만이면 건너뜀 (데이터 불충분)
            if (kopo28_field.length < 16) {
                System.out.printf("[%d줄] 필드 개수 부족: %d개 → 건너뜀\n", kopo28_LineCnt, kopo28_field.length);
                continue;
            }

            // INSERT 쿼리 문자열 생성 (각 필드를 DB 컬럼에 매핑)
            String kopo28_QueryTxt = String.format(
            	    "INSERT INTO freewifi (id, inst_place, inst_place_detail, inst_city, inst_county, inst_place_flag, " +
            	    "service_provider, wifi_ssid, inst_date, place_addr_road, place_addr_land, " +
            	    "manage_office, manage_office_phone, latitude, longitude, write_date) " +
            	    "VALUES ('%s','%s','%s','%s','%s','%s'," +
            	    "'%s','%s','%s','%s','%s'," +
            	    "'%s','%s',%s,%s,'%s')",
            	    kopo28_field[0],  // id
            	    kopo28_field[1],  // 설치장소명
            	    kopo28_field[2],  // 설치장소상세
            	    kopo28_field[3],  // 설치시도명
            	    kopo28_field[4],  // 설치시군구명
            	    kopo28_field[5],  // 설치시설구분
            	    kopo28_field[6],  // 서비스제공사명
            	    kopo28_field[7],  // 와이파이SSID
            	    kopo28_field[8],  // 설치연월
            	    kopo28_field[9],  // 도로명주소
            	    kopo28_field[10], // 지번주소
            	    kopo28_field[11], // 관리기관명
            	    kopo28_field[12], // 관리기관전화번호
            	    kopo28_field[13], // 위도 (숫자형, 따옴표 없음)
            	    kopo28_field[14], // 경도 (숫자형, 따옴표 없음)
            	    kopo28_field[15]  // 데이터기준일자
            	);

            try {
                // 쿼리 실행 (INSERT)
                kopo28_stmt.execute(kopo28_QueryTxt);
                System.out.printf("[%d번째 항목 Insert OK] %s\n", kopo28_LineCnt++, kopo28_QueryTxt);
            } catch (SQLException e) {
                // SQL 실행 중 오류 발생 시 에러 메시지 출력
                System.out.printf("[%d번째 항목 Insert 실패] %s\n오류: %s\n", kopo28_LineCnt++, kopo28_QueryTxt, e.getMessage());
            }
        }

        // 자원 정리 (파일, Statement, DB 연결 종료)
        kopo28_br.close();
        kopo28_stmt.close();
        kopo28_conn.close();
    }
}

