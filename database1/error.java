public static void main(String[] args) {
    Connection conn = null;      // DB 연결 객체 선언
    Statement stmt = null;       // SQL 실행용 Statement 객체 선언
    ResultSet rs = null;         // SELECT 결과를 담을 ResultSet 객체 선언

    try {
        // JDBC 드라이버 로드
        Class.forName("com.mysql.cj.jdbc.Driver");

        // DB 연결 (비밀번호는 마스킹되어 있음)
        conn = DriverManager.getConnection(
            "jdbc:mysql://192.168.26.***:3306/kopoctc", "root", "***");

        // Statement 객체 생성
        stmt = conn.createStatement();

        // SQL 쿼리 실행 (mytable 테이블의 모든 데이터 조회)
        rs = stmt.executeQuery("SELECT * FROM mytable");

        // 결과 반복 출력: studentid 컬럼 값
        while (rs.next()) {
            System.out.println(rs.getString("studentid"));
        }

    } catch (SQLException e) {
        // SQL 실행 중 오류 발생 시 처리
        System.out.println("데이터베이스 오류: " + e.getMessage());
        System.out.println("데이터베이스 오류번호: " + e.getErrorCode());

    } catch (ClassNotFoundException e) {
        // JDBC 드라이버 로딩 실패 시 처리
        System.out.println("드라이버를 찾을 수 없습니다: " + e.getMessage());

    } finally {
        // 리소스 정리: 예외가 있든 없든 무조건 실행
        try {
            if (rs != null) rs.close();       // ResultSet 닫기
            if (stmt != null) stmt.close();   // Statement 닫기
            if (conn != null) conn.close();   // Connection 닫기
        } catch (SQLException e) {
            System.out.println("리소스를 닫는 도중 오류 발생: " + e.getMessage());
        }
    }
}
