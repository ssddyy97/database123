package database1;

// 필요한 라이브러리 불러오기
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class test5 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

        //MySQL JDBC 드라이버 메모리에 로드
        Class.forName("com.mysql.cj.jdbc.Driver");

        //MySQL 서버 접속 (DB주소, 사용자명, 비밀번호)
        Connection kopo28_conn = DriverManager.getConnection(
                "jdbc:mysql://192.168.23.235:3306/kopoctc",  // DB 주소
                "root",                                        // 사용자명
                "lleejin71"                                    // 비밀번호
        );

        //SQL 문을 실행할 Statement 객체 생성
        Statement kopo28_stmt = kopo28_conn.createStatement();

        //읽어올 CSV 파일 객체 생성
        File kopo28_f = new File("C:\\Users\\USER\\Desktop\\myjava\\한국교통안전공단_전국공영주차장정보_20191224 (1).csv");

        //파일을 읽어올 BufferedReader 생성
        BufferedReader kopo28_br = new BufferedReader(new FileReader(kopo28_f));

        String readtxt; // 한 줄씩 읽은 문자열 저장 변수

        //첫 줄(헤더) 읽기
        if ((readtxt = kopo28_br.readLine()) == null) { // 파일이 비어 있으면
            System.out.println("빈 파일입니다");
            kopo28_br.close(); // 파일 닫고
            return; // 프로그램 종료
        }

        int kopo28_LineCnt = 0; // 데이터 라인 카운터 

        //본격적으로 파일의 각 줄을 읽으면서 INSERT 진행
        while ((readtxt = kopo28_br.readLine()) != null) { // 한 줄씩 읽어오기
            String[] kopo28_field = readtxt.split(",");    // 콤마(,)로 분리해서 배열에 저장

            //필드 개수 검증 (정상 데이터만 Insert 시도)
            if (kopo28_field.length < 25) {
                System.out.printf("[%d줄] 필드 개수 부족: %d개 → 건너뜀\n", kopo28_LineCnt, kopo28_field.length);
                continue; // 필드 부족하면 다음 줄로 넘어감
            }

            //읽은 데이터를 기반으로 INSERT 쿼리 작성
            String kopo28_QueryTxt = String.format(
                "INSERT INTO parkinglot (" + 
                "parking_lot_management_number, parking_lot_name, longitude, latitude, " +
                "parking_lot_classification, parking_lot_type, parking_lot_number_address, " +
                "parking_lot_roadname_address, parking_lot_number, operating_day, " +
                "weekday_operation_start_time, weekday_operation_end_time, " +
                "saturday_operation_start_time, saturday_operation_end_time, " +
                "holiday_operation_start_time, holiday_operation_end_time, " +
                "charge_information, management_agency_name, contact_information, " +
                "regional_classification, regional_classification_sub, " +
                "regional_center_coordinates_x_coordinates, regional_center_coordinates_y_coordinates, " +
                "regional_code, revision_date" +
                ") VALUES (" +
                "'%s', '%s', %s, %s, '%s', '%s', '%s', '%s', '%s', '%s', " +
                "'%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', " +
                "'%s', '%s', '%s', '%s', '%s'" +
                ")",
                kopo28_field[0], kopo28_field[1], kopo28_field[2], kopo28_field[3],
                kopo28_field[4], kopo28_field[5], kopo28_field[6], kopo28_field[7],
                kopo28_field[8], kopo28_field[9], kopo28_field[10], kopo28_field[11],
                kopo28_field[12], kopo28_field[13], kopo28_field[14], kopo28_field[15],
                kopo28_field[16], kopo28_field[17], kopo28_field[18], kopo28_field[19],
                kopo28_field[20], kopo28_field[21], kopo28_field[22], kopo28_field[23],
                kopo28_field[24]
            );

            //작성한 쿼리를 실행해서 데이터 삽입 시도
            try {
                kopo28_stmt.execute(kopo28_QueryTxt); // SQL 실행
                System.out.printf("[%d번째 항목 Insert OK]\n", kopo28_LineCnt++); // 성공 메시지
            } catch (SQLException e) { // 오류 발생하면
                System.out.printf("[%d번째 항목 Insert 실패]\n쿼리: %s\n오류: %s\n",
                    kopo28_LineCnt++, kopo28_QueryTxt, e.getMessage()); // 실패 메시지 출력
            }
        }

        //파일, Statement, Connection 자원 정리 (닫기)
        kopo28_br.close();   // 파일 닫기
        kopo28_stmt.close(); // Statement 닫기
        kopo28_conn.close(); // DB 연결 종료
    }
}
