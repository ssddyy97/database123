package database1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test6 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // MySQL 드라이버 로드 (JDBC 연결을 위해 필요)
        Class.forName("com.mysql.cj.jdbc.Driver");

        // MySQL 데이터베이스 연결
        Connection kopo28_conn = DriverManager.getConnection(
            "jdbc:mysql://192.168.23.235:3306/kopoctc", // DB 접속 URL
            "root",  // 사용자명
            "lleejin71"  // 비밀번호
        );

        // SQL 실행을 위한 Statement 객체 생성
        Statement kopo28_stmt = kopo28_conn.createStatement();

        // 기준 위치 설정 (위도/경도)
        double kopo28_lat = 37.3860521;  // 기준 위도
        double kopo28_lng = 127.1214038; // 기준 경도

        //조회 쿼리 작성

        //최단거리 1개만 조회하는 쿼리
        String kopo28_QueryTxt = String.format(
            "SELECT *, " +
            "SQRT(POW(longitude - %f, 2) + POW(latitude - %f, 2)) AS distance " + // 피타고라스 거리 계산
            "FROM parkinglot " + // parkinglot 테이블에서 조회
            "ORDER BY distance ASC " + // 거리 기준 오름차순 정렬
            "LIMIT 1", // 가장 가까운 한 건만 조회
            kopo28_lng, kopo28_lat // 쿼리에 lng, lat 삽입
        );

        //수원시만 조회하는 쿼리
        /*
        String kopo28_QueryTxt = 
            "SELECT * FROM parkinglot " +
            "WHERE parking_lot_number_address LIKE '%수원%' " +
            "   OR parking_lot_roadname_address LIKE '%수원%' " +
            "   OR regional_classification LIKE '%수원%' " +
            "   OR regional_classification_sub LIKE '%수원%'";
        */

        //제주도만 조회하는 쿼리
        /*
        String kopo28_QueryTxt = 
            "SELECT * FROM parkinglot " +
            "WHERE parking_lot_number_address LIKE '%제주%' " +
            "   OR parking_lot_roadname_address LIKE '%제주%' " +
            "   OR regional_classification LIKE '%제주%' " +
            "   OR regional_classification_sub LIKE '%제주%'";
        */

   

        // SQL 쿼리 실행 및 결과(ResultSet) 저장
        ResultSet kopo28_rset = kopo28_stmt.executeQuery(kopo28_QueryTxt);

        int kopo28_iCnt = 0; // 출력 레코드 수 세기용 변수

        // 결과 집합을 순회하면서 데이터 출력
        while (kopo28_rset.next()) {
            System.out.printf("*(%d)****************************\n", kopo28_iCnt++);
            System.out.printf("주차장관리번호: %s\n", kopo28_rset.getString("parking_lot_management_number"));
            System.out.printf("주차장명: %s\n", kopo28_rset.getString("parking_lot_name"));
            System.out.printf("위도: %f\n", kopo28_rset.getDouble("latitude"));
            System.out.printf("경도: %f\n", kopo28_rset.getDouble("longitude"));
            System.out.printf("지번주소: %s\n", kopo28_rset.getString("parking_lot_number_address"));
            System.out.printf("도로명주소: %s\n", kopo28_rset.getString("parking_lot_roadname_address"));
            System.out.printf("지역구분: %s\n", kopo28_rset.getString("regional_classification"));
            System.out.printf("*********************************\n");
        }

  

        // ResultSet, Statement, Connection 객체 순서대로 닫기 (메모리 누수 방지)
        kopo28_rset.close();
        kopo28_stmt.close();
        kopo28_conn.close();
    }

}

