package database1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class test4 { //클래스 선언

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //MySQL JDBC 드라이버 로드
        Class.forName("com.mysql.cj.jdbc.Driver");

        // MySQL 서버 연결 (주소, 사용자명, 비밀번호)
        Connection kopo28_conn = DriverManager.getConnection(
                "jdbc:mysql://192.168.23.235:3306/kopoctc",  // 데이터베이스 주소 및 포트
                "root",                                        // 사용자명
                "lleejin71"                                    // 비밀번호
        );

        // Statement 객체 생성 (SQL 실행용)
        Statement kopo28_stmt = kopo28_conn.createStatement();

        //기존 parkinglot 테이블이 있으면 삭제
        kopo28_stmt.execute("DROP TABLE IF EXISTS parkinglot");

        //parkinglot 테이블 새로 생성
        kopo28_stmt.execute(
            "CREATE TABLE parkinglot (" +
            "parking_lot_management_number INT NOT NULL PRIMARY KEY, " + // 주차장 관리번호
            "parking_lot_name VARCHAR(200), " +              // 주차장 이름
            "longitude DOUBLE, " +                           // 경도 (X 좌표)
            "latitude DOUBLE, " +                            // 위도 (Y 좌표)
            "parking_lot_classification VARCHAR(50), " +     // 주차장 구분
            "parking_lot_type VARCHAR(50), " +               // 주차장 타입
            "parking_lot_number_address VARCHAR(50), " +     // 지번 주소
            "parking_lot_roadname_address VARCHAR(50), " +   // 도로명 주소
            "parking_lot_number VARCHAR(100), " +            // 주차 구역 번호
            "operating_day VARCHAR(20), " +                  // 운영 요일
            "weekday_operation_start_time TIME, " +          // 평일 운영 시작 시간
            "weekday_operation_end_time TIME, " +            // 평일 운영 종료 시간
            "saturday_operation_start_time TIME, " +         // 토요일 운영 시작 시간
            "saturday_operation_end_time TIME, " +           // 토요일 운영 종료 시간
            "holiday_operation_start_time TIME, " +          // 공휴일 운영 시작 시간
            "holiday_operation_end_time TIME, " +            // 공휴일 운영 종료 시간 
            "charge_information VARCHAR(50), " +             // 요금 정보
            "management_agency_name VARCHAR(50), " +         // 관리 기관명
            "regional_classification VARCHAR(50), " +        // 지역 구분
            "regional_classification_sub VARCHAR(50), " +    // 지역 구분 서브
            "regional_center_coordinates_x_coordinates VARCHAR(50), " + // 지역 중심 X 좌표
            "regional_center_coordinates_y_coordinates VARCHAR(50), " + // 지역 중심 Y 좌표 
            "regional_code VARCHAR(50), " +                  // 지역 코드
            "contact_information VARCHAR(50), " +            // 연락처
            "revision_date DATE" +                           // 데이터 수정일
            ") DEFAULT CHARSET=utf8"                         // 기본 문자셋 utf8 설정
        );

        //사용한 Statement와 Connection 객체 닫기 
        kopo28_stmt.close();
        kopo28_conn.close();
    }
}

