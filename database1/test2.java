package database1; // 이 파일이 포함된 Java 패키지 이름 (폴더 구조와 관련 있음)

// MySQL과 연결하고 SQL 실행을 위한 Java 표준 라이브러리 import
import java.sql.Connection;      // DB 연결 객체
import java.sql.DriverManager;   // 연결을 생성하는 유틸 클래스
import java.sql.ResultSet;       // SELECT 결과를 담는 객체
import java.sql.SQLException;    // SQL 관련 예외 처리 클래스
import java.sql.Statement;       // SQL 명령어 실행 객체

public class test2 { //클래스 정의 

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
		
		  // 기준 위치 (위도, 경도) — 사용자의 현재 좌표 등
	    double kopo28_lat = 37.3860521;
	    double kopo28_lng = 127.1214038;

	    // SQL 쿼리 문자열 선언
	    String kopo28_QueryTxt;

	    // 가장 가까운 위치 한 곳만 선택 (거리 최소값)
	    

	    // ▼ 아래는 필터 조건 예시들 (사용 안 함, 참고용)
	    //kopo28_QueryTxt = "select * from freewifi";
	    //kopo28_QueryTxt = "select * from freewifi where service_provider='SKT'"; //skt 확인
	kopo28_QueryTxt = "select * from freewifi where inst_county = '수원시'";

	    // 쿼리 실행 후 결과 저장
	    ResultSet kopo28_rset = kopo28_stmt.executeQuery(kopo28_QueryTxt);

	    int kopo28_iCnt = 0;
	    while (kopo28_rset.next()) {
	        // 각 필드 출력 (1~15 컬럼)
	        System.out.printf("*(%d)****************************\n", kopo28_iCnt++);
	        System.out.printf("아이디       : %s\n", kopo28_rset.getString(1));
	        System.out.printf("설치장소명       : %s\n", kopo28_rset.getString(2));
	        System.out.printf("설치장소상세     : %s\n", kopo28_rset.getString(3));
	        System.out.printf("설치시도명       : %s\n", kopo28_rset.getString(4));
	        System.out.printf("설치시군구명     : %s\n", kopo28_rset.getString(5));
	        System.out.printf("설치시설구분     : %s\n", kopo28_rset.getString(6));
	        System.out.printf("서비스제공사명   : %s\n", kopo28_rset.getString(7));
	        System.out.printf("와이파이SSID     : %s\n", kopo28_rset.getString(8));
	        System.out.printf("설치년도         : %s\n", kopo28_rset.getString(9));
	        System.out.printf("소재지도로명주소 : %s\n", kopo28_rset.getString(10));
	        System.out.printf("소재지지번주소   : %s\n", kopo28_rset.getString(11));
	        System.out.printf("관리기관명       : %s\n", kopo28_rset.getString(12));
	        System.out.printf("관리기관전화번호 : %s\n", kopo28_rset.getString(13));
	        System.out.printf("위도             : %f\n", kopo28_rset.getFloat(14));
	        System.out.printf("경도             : %f\n", kopo28_rset.getFloat(15));
	        System.out.printf("데이터기준일자   : %s\n", kopo28_rset.getDate(16));
	        System.out.printf("*********************************\n");
	    }

	    // 리소스 정리
	    kopo28_rset.close();
	    kopo28_stmt.close();
	    kopo28_conn.close();
	}
	
	
}