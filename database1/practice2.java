package database1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class practice2 { //클래스선언
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

        //테이블이 이미 존재할 경우 삭제
        kopo28_stmt.execute("DROP TABLE IF EXISTS examtable");

        //테이블 생성
        kopo28_stmt.execute(
            "CREATE TABLE examtable (" +
            "name VARCHAR(20), " +                        // 이름 (최대 20자)
            "studentid INT NOT NULL PRIMARY KEY, " +      // 학번 (기본키)
            "kor INT, " +                                  // 국어 점수
            "eng INT, " +                                  // 영어 점수
            "mat INT " +                                   // 수학 점수
            ") DEFAULT CHARSET=utf8"
        );

        //자원 정리
        kopo28_stmt.close();
        kopo28_conn.close();
    }
}
