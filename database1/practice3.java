package database1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class practice3 { //클래스선언
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //JDBC 드라이버 로드
        Class.forName("com.mysql.cj.jdbc.Driver");

        //DB 연결 설정
        Connection kopo28_conn = DriverManager.getConnection(
            "jdbc:mysql://192.168.23.235:33060/kopoctc", 
            "root", 
            "lleejin71"
        );

        //SQL 명령 실행을 위한 Statement 객체 생성
        Statement kopo28_stmt = kopo28_conn.createStatement();

        //테이블이 정보삭제
        kopo28_stmt.execute("delete from examtable;");

        //자원 정리
        kopo28_stmt.close();
        kopo28_conn.close();
    }
}