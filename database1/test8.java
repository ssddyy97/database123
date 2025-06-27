package database1; // 이 파일이 속한 Java 패키지 이름 


import java.sql.Connection;     
import java.sql.DriverManager;  
import java.sql.ResultSet;       
import java.sql.SQLException;    
import java.sql.Statement;       

public class test8 { // test8이라는 이름의 클래스 정의 시작

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//MySQL JDBC 드라이버를 메모리에 로드
		Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL과 Java를 연결해주는 드라이버를 JVM에 등록

		//MySQL 서버에 연결 (IP: 192.168.23.235, 포트: 33060, DB명: kopoctc)
		Connection kopo28_conn = DriverManager.getConnection(
			"jdbc:mysql://192.168.23.235:33060/kopoctc", // 접속할 MySQL 서버 주소와 DB 이름
			"root",        // 데이터베이스 접속 아이디
			"lleejin71"    // 데이터베이스 접속 비밀번호
		);
		
		//SQL 명령어를 실행할 Statement 객체 생성
		Statement kopo28_stmt = kopo28_conn.createStatement(); // SQL 문을 보내기 위한 준비

		//기존에 stock 테이블이 존재하면 삭제
		kopo28_stmt.execute("DROP TABLE IF EXISTS stock"); 
		// 테이블이 이미 있을 경우 삭제해서 중복 에러 방지

		//새로운 stock 테이블 생성
		kopo28_stmt.execute(
			"CREATE TABLE stock ( " +                      // 테이블 이름: stock
			"Shortcut_code VARCHAR(10), " +                // 종목 코드 
			"date DATE, " +                             // 날짜
			"market_price INT(200), " +                // 시가
			"high_price INT(50), " +                   // 고가 
			"low_price INT(50), " +                    // 저가 
			"closing_price INT(50), " +                // 종가 
			"trading_volume INT(50), " +               // 거래량 
			"transaction_value INT(50), " +            // 거래대금 
			"PRIMARY KEY (date, Shortcut_code) " +         // 기본키: 날짜 + 종목코드 (중복 저장 방지)
			") DEFAULT CHARSET=utf8;"                      // 테이블 기본 문자 인코딩을 UTF-8로 설정
		);

		//Statement 객체 닫기 (자원 해제)
		kopo28_stmt.close();  

		//DB 연결(Connection) 닫기 (자원 해제)
		kopo28_conn.close();  
	}
}
