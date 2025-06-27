package database1; // 이 파일이 속한 패키지 이름을 정의

// MySQL과 연결하기 위한 Java SQL 라이브러리를 import 함
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class database2 { // 클래스 정의

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		// MySQL JDBC 드라이버를 메모리에 로드
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// 데이터베이스 연결 설정: IP 주소, 포트, 데이터베이스명, 사용자명, 비밀번호
		Connection conn = DriverManager.getConnection(
			"jdbc:mysql://192.168.23.235:33060/kopoctc", // DB 서버 주소 및 포트
			"root", // 사용자 이름
			"lleejin71" // 비밀번호
		);
		
		// SQL 명령을 실행할 수 있는 Statement 객체 생성
		Statement stmt = conn.createStatement();
		
		stmt.execute("delete from examtable;");

		
		stmt.close(); // Statement 닫기
		conn.close(); // Connection 닫기
	}
}
