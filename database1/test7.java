package database1; // 패키지 선언

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class test7 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1. JDBC 드라이버 로드
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. MySQL 데이터베이스 연결
        Connection ko28_conn = DriverManager.getConnection(
            "jdbc:mysql://192.168.23.235:33060/kopoctc", // 데이터베이스 URL
            "root", // 사용자명
            "lleejin71" // 비밀번호
        );

        // 3. 테이블 삭제 및 생성
        Statement ko28_stmt = ko28_conn.createStatement(); // SQL 실행을 위한 Statement 객체 생성
        ko28_stmt.execute("DROP TABLE IF EXISTS result"); // 기존 테이블이 있으면 삭제
        ko28_stmt.execute(
            "CREATE TABLE result (" + // 새로운 테이블 생성
            "id INT AUTO_INCREMENT PRIMARY KEY, " + // 자동 증가하는 id 컬럼
            "name VARCHAR(100), " + // 이름(name) 컬럼
            "kor INT, " + // 국어 점수 컬럼
            "eng INT, " + // 영어 점수 컬럼
            "mat INT" + // 수학 점수 컬럼
            ") DEFAULT CHARSET=utf8" // 기본 문자셋 UTF-8 설정
        );

        // 4. 데이터 삽입
        String ko28_insertSQL = "INSERT INTO result (name, kor, eng, mat) VALUES (?, ?, ?, ?)"; // insert SQL 문 작성
        PreparedStatement ko28_pstmt = ko28_conn.prepareStatement(ko28_insertSQL); // PreparedStatement 객체 생성

        int ko28_totalPerson = 200; // 총 200명의 데이터를 삽입
        for (int ko28_i = 0; ko28_i < ko28_totalPerson; ko28_i++) {
            String ko28_name = String.format("홍길%03d",ko28_i + 1); // 이름을 "홍길001" 형태로 생성
            int ko28_kor = (int)(Math.random() * 100); // 0~99 사이의 국어 점수 생성
            int ko28_eng = (int)(Math.random() * 100); // 0~99 사이의 영어 점수 생성
            int ko28_mat = (int)(Math.random() * 100); // 0~99 사이의 수학 점수 생성

            ko28_pstmt.setString(1, ko28_name); // 이름 바인딩
            ko28_pstmt.setInt(2, ko28_kor); // 국어 점수 바인딩
            ko28_pstmt.setInt(3, ko28_eng); // 영어 점수 바인딩
            ko28_pstmt.setInt(4, ko28_mat); // 수학 점수 바인딩
            ko28_pstmt.executeUpdate(); // insert 실행
        }
        ko28_pstmt.close(); // PreparedStatement 자원 해제

        //페이지 설정
        int ko28_pageSize = 30; // 한 페이지에 출력할 데이터 수
        int ko28_selectedPage = 6; // 출력할 최종 페이지
        int ko28_pageCount = (ko28_totalPerson + ko28_pageSize - 1) / ko28_pageSize; // 총 페이지 수 계산
        if (ko28_selectedPage > ko28_pageCount) ko28_selectedPage = ko28_pageCount; // 선택한 페이지가 범위를 초과하면 마지막 페이지로 설정

        Statement ko28_queryStmt = ko28_conn.createStatement(); // 데이터 조회를 위한 Statement 객체 생성

        //페이지별 출력
        for (int ko28_page = 1; ko28_page <= ko28_selectedPage; ko28_page++) { // 1페이지부터 선택한 페이지까지 반복
            int ko28_offset = (ko28_page - 1) * ko28_pageSize; // 오프셋 계산 (페이지 시작 위치)

            // 현재 페이지 데이터 조회용 SQL 작성
            String ko28_dataQuery =
                "SELECT name, kor, eng, mat, " +
                "(kor + eng + mat) AS sum, " + // 총합 계산
                "(kor + eng + mat) / 3.0 AS avg " + // 평균 계산
                "FROM result " +
                "ORDER BY id ASC " + // id 기준 오름차순 정렬
                "LIMIT " + ko28_pageSize + " OFFSET " + ko28_offset; // LIMIT과 OFFSET 사용하여 페이징

            ResultSet ko28_rs = ko28_queryStmt.executeQuery(ko28_dataQuery); // 쿼리 실행

            // 페이지 번호 출력
            System.out.printf("\npage : %d\n", ko28_page);
            System.out.println("=================================================================");
            System.out.printf("%-10s %5s %5s %5s %6s %8s\n", "구분", "국어", "영어", "수학", "총합", "평균");
            System.out.println("=================================================================");

            // 현재 페이지 데이터 출력
            while (ko28_rs.next()) {
                String ko28_name = ko28_rs.getString("name"); // 이름
                int ko28_kor = ko28_rs.getInt("kor"); // 국어 점수
                int ko28_eng = ko28_rs.getInt("eng"); // 영어 점수
                int ko28_mat = ko28_rs.getInt("mat"); // 수학 점수
                int ko28_sum = ko28_rs.getInt("sum"); // 총합
                double ko28_avg = ko28_rs.getDouble("avg"); // 평균

                System.out.printf("%-10s %6d %7d %7d %8d %12.2f\n", ko28_name, ko28_kor, ko28_eng, ko28_mat, ko28_sum, ko28_avg);
            }
            ko28_rs.close(); // ResultSet 자원 해제

            //현재 페이지 합계/평균 계산
            String ko28_pageSummaryQuery =
                "SELECT " +
                    "SUM(kor) AS sum_kor, SUM(eng) AS sum_eng, SUM(mat) AS sum_mat, " + // 과목별 합계
                    "(SUM(kor) + SUM(eng) + SUM(mat)) AS sum_total, " + // 전체 합계
                    "(SUM(kor) + SUM(eng) + SUM(mat)) / 3.0 AS sum_based_avg, " + // 총합 기준 평균
                    "AVG(kor) AS avg_kor, AVG(eng) AS avg_eng, AVG(mat) AS avg_mat, " + // 과목별 평균
                    "(AVG(kor) + AVG(eng) + AVG(mat)) AS avg_total, " + // 과목 평균 합
                    "(AVG(kor) + AVG(eng) + AVG(mat)) / 3.0 AS avg_based_avg " + // 과목 평균 합 기준 평균
                "FROM (" +
                    "SELECT kor, eng, mat " +
                    "FROM result " +
                    "ORDER BY id ASC " +
                    "LIMIT " + ko28_pageSize + " OFFSET " + ko28_offset +
                ") AS subquery"; // 현재 페이지에 해당하는 데이터만 서브쿼리로 가져옴

            ResultSet ko28_pageSummaryRs = ko28_queryStmt.executeQuery(ko28_pageSummaryQuery); // 쿼리 실행
            if (ko28_pageSummaryRs.next()) { // 결과가 있으면 출력
                int ko28_sumKor = ko28_pageSummaryRs.getInt("sum_kor");
                int ko28_sumEng = ko28_pageSummaryRs.getInt("sum_eng");
                int ko28_sumMat = ko28_pageSummaryRs.getInt("sum_mat");
                int ko28_sumTotal = ko28_pageSummaryRs.getInt("sum_total");
                double ko28_sumBasedAvg = ko28_pageSummaryRs.getDouble("sum_based_avg");
                double ko28_avgKor = ko28_pageSummaryRs.getDouble("avg_kor");
                double ko28_avgEng = ko28_pageSummaryRs.getDouble("avg_eng");
                double ko28_avgMat = ko28_pageSummaryRs.getDouble("avg_mat");
                double ko28_avgTotal = ko28_pageSummaryRs.getDouble("avg_total");
                double ko28_avgBasedAvg = ko28_pageSummaryRs.getDouble("avg_based_avg");

                // 현재 페이지 합계 및 평균 출력
                System.out.println("=================================================================");
                System.out.println("현재페이지");
                System.out.printf("합계:    %10d %7d %7d %8d %12.2f\n",
                		ko28_sumKor, ko28_sumEng, ko28_sumMat, ko28_sumTotal, ko28_sumBasedAvg
                );
                System.out.printf("평균:    %10.2f %7.2f %7.2f %8.2f %12.2f\n",
                		ko28_avgKor, ko28_avgEng, ko28_avgMat, ko28_avgTotal, ko28_avgBasedAvg
                );
            }
            ko28_pageSummaryRs.close(); // ResultSet 자원 해제

            //누적 페이지 합계/평균 계산
            String ko28_cumulativeSummaryQuery =
                "SELECT " +
                    "SUM(kor) AS sum_kor, SUM(eng) AS sum_eng, SUM(mat) AS sum_mat, " +
                    "(SUM(kor) + SUM(eng) + SUM(mat)) AS sum_total, " +
                    "(SUM(kor) + SUM(eng) + SUM(mat)) / 3.0 AS sum_based_avg, " +
                    "AVG(kor) AS avg_kor, AVG(eng) AS avg_eng, AVG(mat) AS avg_mat, " +
                    "(AVG(kor) + AVG(eng) + AVG(mat)) AS avg_total, " +
                    "(AVG(kor) + AVG(eng) + AVG(mat)) / 3.0 AS avg_based_avg " +
                "FROM (" +
                    "SELECT kor, eng, mat " +
                    "FROM result " +
                    "ORDER BY id ASC " +
                    "LIMIT " + (ko28_pageSize * ko28_page) +
                ") AS subquery"; // 누적 데이터 서브쿼리 작성

            ResultSet ko28_cumulativeSummaryRs = ko28_queryStmt.executeQuery(ko28_cumulativeSummaryQuery); // 쿼리 실행
            if (ko28_cumulativeSummaryRs.next()) { // 결과가 있으면 출력
                int ko28_sumKor = ko28_cumulativeSummaryRs.getInt("sum_kor");
                int ko28_sumEng = ko28_cumulativeSummaryRs.getInt("sum_eng");
                int ko28_sumMat = ko28_cumulativeSummaryRs.getInt("sum_mat");
                int ko28_sumTotal = ko28_cumulativeSummaryRs.getInt("sum_total");
                double ko28_sumBasedAvg = ko28_cumulativeSummaryRs.getDouble("sum_based_avg");
                double ko28_avgKor = ko28_cumulativeSummaryRs.getDouble("avg_kor");
                double ko28_avgEng = ko28_cumulativeSummaryRs.getDouble("avg_eng");
                double ko28_avgMat = ko28_cumulativeSummaryRs.getDouble("avg_mat");
                double ko28_avgTotal = ko28_cumulativeSummaryRs.getDouble("avg_total");
                double ko28_avgBasedAvg = ko28_cumulativeSummaryRs.getDouble("avg_based_avg");

                // 누적 페이지 합계 및 평균 출력
                System.out.println("누적페이지");
                System.out.printf("합계:    %10d %7d %7d %8d %12.2f\n",
                		ko28_sumKor, ko28_sumEng, ko28_sumMat, ko28_sumTotal, ko28_sumBasedAvg
                );
                System.out.printf("평균:    %10.2f %7.2f %7.2f %8.2f %12.2f\n",
                		ko28_avgKor, ko28_avgEng, ko28_avgMat, ko28_avgTotal, ko28_avgBasedAvg
                );
            }
            ko28_cumulativeSummaryRs.close(); // ResultSet 자원 해제

            System.out.println("=================================================================");
        }

        //연결 종료
        ko28_queryStmt.close(); // Statement 자원 해제
        ko28_stmt.close(); // Statement 자원 해제
        ko28_conn.close(); // Connection 자원 해제
    }
}



