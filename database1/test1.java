package database1; // 이 파일이 포함된 Java 패키지 이름 (폴더 구조와 관련 있음)

// MySQL과 연결하고 SQL 실행을 위한 Java 표준 라이브러리 import
import java.sql.Connection;      // DB 연결 객체
import java.sql.DriverManager;   // 연결을 생성하는 유틸 클래스
import java.sql.ResultSet;       // SELECT 결과를 담는 객체
import java.sql.SQLException;    // SQL 관련 예외 처리 클래스
import java.sql.Statement;       // SQL 명령어 실행 객체

public class test1 { //클래스 정의 

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		// 1. MySQL JDBC 드라이버를 메모리에 로드 
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// 2. MySQL 서버에 연결 (주소: 192.168.23.235, 포트: 33060, DB명: kopoctc)
		Connection kopo28_conn = DriverManager.getConnection(
			"jdbc:mysql://127.0.0.1:33067/kopoctc", // 접속할 MySQL 서버 주소 및 DB
			"root",        // 사용자명
			"lleejin71"    // 비밀번호
		);
		
		//SQL 명령어를 실행할 수 있는 Statement 객체 생성
		Statement kopo28_stmt = kopo28_conn.createStatement();
		kopo28_stmt.execute("DROP TABLE IF EXISTS freewifi"); // 기존 테이블 삭제 (있을 경우)

		kopo28_stmt.execute(
		    "CREATE TABLE freewifi (" +                                          //테이블 생성 
		    "id                      INT NOT NULL PRIMARY KEY, "+    //기본키: 자동 증가 정수형 ID 
		    "inst_place              VARCHAR(100), " + //설치 장소
		    "inst_place_detail       VARCHAR(200), " + //설치 장소 상세
		    "inst_city               VARCHAR(50), " +  //설치 도시
		    "inst_county             VARCHAR(50), " +  //설치 구/ 군
		    "inst_place_flag         VARCHAR(50), " +  //설치 구분
		    "service_provider        VARCHAR(50), " +  //서비스 제공사
		    "wifi_ssid               VARCHAR(100), " + //와이파이 ssid 이름
		    "inst_date               DATE, " +  //설치 날짜 
		    "place_addr_road         VARCHAR(200), " + //도로명
		    "place_addr_land         VARCHAR(200), " + //지번
		    "manage_office           VARCHAR(100), " + //관리 기관명
		    "manage_office_phone     VARCHAR(50), " + //관리 기관 전화번호
		    "latitude                DOUBLE, " +//위도
		    "longitude               DOUBLE, " + //경도
		    "write_date              DATE " +  //데이터 기준일자 
		    ") DEFAULT CHARSET=utf8" //문자 인코딩
		);

		kopo28_stmt.close();  // Statement 닫기
		kopo28_conn.close();  // DB 연결 닫기
	}
}

