package database1; // 이 파일이 속한 패키지의 이름을 정의합니다

// MySQL 데이터베이스와 연결하기 위해 필요한 자바 SQL 관련 라이브러리들을 import 합니다
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class database1 { // Java 프로그램의 진입점 클래스 정의

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//MySQL JDBC 드라이버를 메모리에 로드
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//MySQL 데이터베이스에 연결 (IP 주소, 포트번호, DB명, 계정 정보)
		Connection kopo28_conn = DriverManager.getConnection(
			"jdbc:mysql://192.168.23.235:33060/kopoctc", // DB 서버 주소:포트/스키마명
			"root",  // 사용자 ID
			"lleejin71" // 비밀번호
		);
		
		//SQL 실행을 위한 Statement 객체 생성
		Statement kopo28_stmt = kopo28_conn.createStatement();
		
		kopo28_stmt.execute("delete from examtable;"); //데이터 삭제

		
		kopo28_stmt.execute("INSERT INTO examtable VALUES ('안유진',209901,95,100,90)"); //데이터 입력 이름 학번 국어 영어 수학
		kopo28_stmt.execute("INSERT INTO examtable VALUES ('가을',209902,95,56,90)");//데이터 입력 이름 학번 국어 영어 수학
		kopo28_stmt.execute("INSERT INTO examtable VALUES ('레이',209903,96,89,93)");//데이터 입력 이름 학번 국어 영어 수학
		kopo28_stmt.execute("INSERT INTO examtable VALUES ('장원영',209904,99,100,95)");//데이터 입력 이름 학번 국어 영어 수학
		kopo28_stmt.execute("INSERT INTO examtable VALUES ('리즈',209905,100,72,98)");//데이터 입력 이름 학번 국어 영어 수학
		kopo28_stmt.execute("INSERT INTO examtable VALUES ('이서',209906,92,100,92)");//데이터 입력 이름 학번 국어 영어 수학
		
		//사용한 Statement 객체 닫기
		kopo28_stmt.close();

		//DB 연결 종료
		kopo28_conn.close();
	}
}
