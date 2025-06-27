package database1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class practice { //클래스 선언

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        // JDBC 드라이버 로드 (new version)
        Class.forName("com.mysql.cj.jdbc.Driver");

        // MySQL 서버에 접속 (IP주소, 포트, DB명, 사용자명, 비밀번호)
        // *** 비밀번호는 보안상 코드에 직접 쓰는 것보다 환경변수 등으로 관리하는 것이 좋음
        Connection kopo28_con = DriverManager.getConnection(
            "jdbc:mysql://192.168.26.235:33060/kopoctc", // 서버 주소/포트/DB명
            "root",                                     // 사용자명
            "lleejin71"                                       // 비밀번호
        );

        // SQL 명령 실행을 위한 Statement 객체 생성
        Statement kopo28_stmt = kopo28_con.createStatement();

        // "show databases" 쿼리를 실행하고 결과를 ResultSet으로 받음
        ResultSet kopo28_rset = kopo28_stmt.executeQuery("show databases");

        // 결과를 반복하면서 하나씩 출력
        while (kopo28_rset.next()) {
            // 첫 번째 컬럼 값을 문자열로 받아 출력
            System.out.printf("값 : %s \n", kopo28_rset.getString(1));
        }

        // 리소스 해제 (사용한 객체 닫기)
        kopo28_rset.close();
        kopo28_stmt.close();
        kopo28_con.close();
    }
}
