package database1; // 이 파일이 포함된 Java 패키지 이름 (폴더 구조와 관련 있음)

// MySQL과 연결하고 SQL 실행을 위한 Java 표준 라이브러리 import
import java.sql.Connection;      // DB 연결 객체
import java.sql.DriverManager;   // 연결을 생성하는 유틸 클래스
import java.sql.ResultSet;       // SELECT 결과를 담는 객체
import java.sql.SQLException;    // SQL 관련 예외 처리 클래스
import java.sql.Statement;       // SQL 명령어 실행 객체

public class database4 { //클래스 정의 

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		// 1. MySQL JDBC 드라이버를 메모리에 로드 
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// 2. MySQL 서버에 연결 (주소: 192.168.23.235, 포트: 33060, DB명: kopoctc)
		Connection kopo28_conn = DriverManager.getConnection(
			"jdbc:mysql://192.168.23.235:33060/kopoctc", // 접속할 MySQL 서버 주소 및 DB
			"root",        // 사용자명
			"lleejin71"    // 비밀번호
		);
		
		//SQL 명령어를 실행할 수 있는 Statement 객체 생성
		Statement kopo28_stmt = kopo28_conn.createStatement();
		
		//examtable 테이블에서 모든 레코드를 조회하는 SELECT 실행
		ResultSet kopo28_rset = kopo28_stmt.executeQuery("select * from examtable;");

		//컬럼 제목 출력
		System.out.printf("  이름\t 학번\t국어\t영어\t수학\n");

		//결과 집합을 한 줄씩 반복하면서 출력
		while(kopo28_rset.next()) {
			// 각 행의 열값들을 꺼내서 정렬된 포맷으로 출력
			System.out.printf("%4s\t%6d\t%3d\t%3d\t%3d \n",
					kopo28_rset.getString(1),  // 이름 컬럼
					kopo28_rset.getInt(2),     // 학번컬럼
					kopo28_rset.getInt(3),     // 국어 점수 
					kopo28_rset.getInt(4),     // 영어 점수 
					kopo28_rset.getInt(5)      // 수학 점수 
			);
		}

		//사용한 리소스 정리 (닫기)
		kopo28_rset.close();  // 결과셋 닫기
		kopo28_stmt.close();  // Statement 닫기
		kopo28_conn.close();  // DB 연결 닫기
	}
}

