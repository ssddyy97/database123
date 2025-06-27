package database1; // 이 파일이 속한 패키지 이름을 정의

// MySQL과 연결하기 위한 Java SQL 라이브러리를 import 함
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class database3 { // 클래스 정의

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
		
		// examtable이 이미 존재할 경우 삭제
		stmt.execute("DROP TABLE IF EXISTS examtable");

		// examtable 새로 생성
		stmt.execute(
			"CREATE TABLE examtable (" +
			"name VARCHAR(20), " +
			"studentid INT NOT NULL PRIMARY KEY, " +
			"kor INT, " +
			"eng INT, " +
			"mat INT" +
			") DEFAULT CHARSET=utf8"
		);

		// 데이터 삽입
		stmt.execute("INSERT INTO examtable VALUES ('안유진',209901,95,100,90)"); //이름 학번 국어성적 수학성적 영어 성적
		stmt.execute("INSERT INTO examtable VALUES ('가을',209902,95,100,90)");//이름 학번 국어성적 수학성적 영어 성적
		stmt.execute("INSERT INTO examtable VALUES ('레이',209903,95,100,90)");//이름 학번 국어성적 수학성적 영어 성적
		stmt.execute("INSERT INTO examtable VALUES ('장원영',209904,95,100,90)");//이름 학번 국어성적 수학성적 영어 성적
		stmt.execute("INSERT INTO examtable VALUES ('리즈',209905,95,100,90)");//이름 학번 국어성적 수학성적 영어 성적
		stmt.execute("INSERT INTO examtable VALUES ('이서',209906,95,100,90)");//이름 학번 국어성적 수학성적 영어 성적

		// 리소스 정리
		stmt.close();
		conn.close();
	}
}

