package database1;


import com.opencsv.CSVReader; // CSV 파일 읽기용 라이브러리
import java.io.FileReader;    // 파일 읽기용
import java.sql.*;            // JDBC 관련
import java.util.Arrays;      // 배열 출력용
import java.util.Collections; // 컬렉션 헬퍼

public class test11 {
    public static void main(String[] args) {

        // CSV 파일 경로
        String kopo28_FILE_PATH = "C:\\Users\\USER\\Desktop\\myjava\\new.CSV"; 
        // 생성할 테이블명
        String kopo28_tableName = "stoke2";

        //  테이블 컬럼명과 데이터 타입 목록 (99개)
     // 테이블 컬럼명과 데이터 타입 목록 (99개)
        String[] kopo28_columns = {
            "stnd_iscd VARCHAR(13) NOT NULL", // 표준 종목코드
            "bsop_date INT NOT NULL",          // 주식 영업일자
            "shrn_iscd VARCHAR(10) NOT NULL",  // 유가증권 단축 종목코드
            "stck_prpr INT",                   // 주식 종가
            "stck_oprc INT",                   // 주식 시가
            "stck_hgpr INT",                   // 주식 최고가
            "stck_lwpr INT",                   // 주식 최저가
            "prdy_vrss_sign CHAR(2)",           // 전일 대비 부호
            "prdy_vrss INT",                   // 전일 대비
            "prdy_ctrt FLOAT",                  // 전일 대비율
            "prdy_vol BIGINT",                  // 전일 거래량
            "acml_vol BIGINT",                  // 누적 거래량
            "acml_tr_pbmn BIGINT",              // 누적 거래 대금
            "askp1 INT",                        // 매도호가 1
            "bidp1 INT",                        // 매수호가 1
            "total_askp_rsqn BIGINT",            // 총 매도호가 잔량
            "total_bidp_rsqn BIGINT",            // 총 매수호가 잔량
            "seln_cntg_smtn BIGINT",             // 매도 체결 합계
            "shnu_cntg_smtn BIGINT",             // 매수 체결 합계
            "seln_tr_pbmn BIGINT",               // 매도 거래 대금
            "shnu_tr_pbmn BIGINT",               // 매수 거래 대금
            "seln_cntg_csnu INT",                // 매도 체결 건수
            "shnu_cntg_csnu INT",                // 매수 체결 건수
            "w52_hgpr INT",                      // 52주 최고가
            "w52_lwpr INT",                      // 52주 최저가
            "w52_hgpr_date INT",                 // 52주 최고가 일자
            "w52_lwpr_date INT",                 // 52주 최저가 일자
            "ovtm_untp_bsop_hour INT",           // 시간외 단일가 최종 시간
            "ovtm_untp_prpr INT",                // 시간외 단일가 현재가
            "ovtm_untp_prdy_vrss INT",           // 시간외 단일가 전일 대비
            "ovtm_untp_prdy_vrss_sign CHAR(2)",  // 시간외 단일가 전일 대비 부호
            "ovtm_untp_askp1 INT",               // 시간외 단일가 매도호가1
            "ovtm_untp_bidp1 INT",               // 시간외 단일가 매수호가1
            "ovtm_untp_vol BIGINT",              // 시간외 단일가 거래량
            "ovtm_untp_tr_pbmn BIGINT",          // 시간외 단일가 거래 대금
            "ovtm_untp_oprc INT",                // 시간외 단일가 시가
            "ovtm_untp_hgpr INT",                // 시간외 단일가 최고가
            "ovtm_untp_lwpr INT",                // 시간외 단일가 최저가
            "mkob_otcp_vol BIGINT",              // 장개시전 시간외종가 거래량
            "mkob_otcp_tr_pbmn BIGINT",          // 장개시전 시간외종가 거래 대금
            "mkfa_otcp_vol BIGINT",              // 장종료후 시간외종가 거래량
            "mkfa_otcp_tr_pbmn BIGINT",          // 장종료후 시간외종가 거래 대금
            "mrkt_div_cls_code CHAR(2)",          // 시장 분류 구분 코드
            "pstc_dvdn_amt BIGINT",              // 주당 배당 금액
            "lstn_stcn BIGINT",                  // 상장 주식 수
            "stck_sdpr INT",                     // 주식 기준가
            "stck_fcam FLOAT",                   // 주식 액면가
            "wghn_avrg_stck_prc DOUBLE",         // 가중 평균 주식 가격
            "issu_limt_rate FLOAT",              // 종목 한도 비율
            "frgn_limt_qty BIGINT",              // 외국인 한도 수량
            "oder_able_qty BIGINT",              // 주문 가능 수량
            "frgn_limt_exhs_cls_code CHAR(2)",    // 외국인 한도 소진 구분 코드
            "frgn_hldn_qty BIGINT",              // 외국인 보유 수량
            "frgn_hldn_rate FLOAT",               // 외국인 보유 비율
            "hts_frgn_ehrt FLOAT",                // HTS 외국인 소진율
            "itmt_last_nav FLOAT",                // 장중 최종 NAV
            "prdy_last_nav FLOAT",                // 전일 최종 NAV
            "trc_errt FLOAT",                     // 추적 오차율
            "dprt FLOAT",                         // 괴리율
            "ssts_cntg_qty BIGINT",               // 공매도차입증권 매도 체결 수량
            "ssts_tr_pbmn BIGINT",                // 공매도차입증권 매도 거래 대금
            "frgn_ntby_qty BIGINT",               // 외국인 순매수
            "flng_cls_code CHAR(3)",               // 락 구분 코드
            "prtt_rate FLOAT",                    // 분할 비율
            "acml_prtt_rate FLOAT",                // 누적 분할 비율
            "stdv FLOAT",                         // 전체융자잔고 비율
            "beta_cfcn FLOAT",                    // 베타 계수 (90일)
            "crlt_cfcn FLOAT",                    // DEL 상관 계수
            "bull_beta FLOAT",                    // DEL 강세 계수
            "bear_beta FLOAT",                    // DEL 약세 계수
            "bull_dvtn FLOAT",                    // DEL 강세 편차
            "bear_dvtn FLOAT",                    // DEL 약세 편차
            "bull_crlt FLOAT",                    // DEL 강세 상관계수
            "bear_crlt FLOAT",                    // DEL 약세 상관계수
            "stck_mxpr INT",                      // 주식 상한가
            "stck_llam INT",                      // 주식 하한가
            "icic_cls_code CHAR(3)",               // 증자 구분 코드
            "itmt_vol BIGINT",                    // 장중 거래량
            "itmt_tr_pbmn BIGINT",                // 장중 거래대금
            "fcam_mod_cls_code CHAR(3)",            // 액면가 변경 구분 코드
            "revl_issu_reas_code CHAR(3)",          // 재평가 종목 사유 코드
            "orgn_ntby_qty BIGINT",                // 기관계 순매수
            "adj_prpr INT",                       // 수정 주가
            "fn_oprc INT",                        // 주식 시가 
            "fn_hgpr INT",                        // 주식 최고가 
            "fn_lwpr INT",                        // 주식 최저가 
            "fn_prpr INT",                        // 주식 종가 
            "fn_acml_vol BIGINT",                  // 누적 거래량 
            "fn_acml_tr_pbmn BIGINT",              // 누적 거래 대금
            "fn_prtt_rate FLOAT",                  // 분할 비율 
            "fn_flng_cls_code CHAR(3)",             // 락 구분 코드 
            "buyin_nor_prpr INT",                  // Buy-in 일반 체결가
            "buyin_nor_prdy_vrss INT",             // Buy-in 일반 종가 대비
            "buyin_nor_vol BIGINT",                // Buy-in 일반 체결량
            "buyin_nor_tr_pbmn BIGINT",            // Buy-in 일반 체결 대금
            "buyin_tod_prpr INT",                  // Buy-in 당일 체결가
            "buyin_tod_prdy_vrss INT",             // Buy-in 당일 종가 대비
            "buyin_tod_vol BIGINT",                // Buy-in 당일 체결량
            "buyin_tod_tr_pbmn BIGINT"             // Buy-in 당일 체결 대금
        };

        int kopo28_columnCount = kopo28_columns.length; //  컬럼 개수
        int kopo28_batchSize = 10000;             // 배치 커밋 단위
        int kopo28_lineCnt = 0;                   //  읽은 줄 수
        int kopo28_batchCnt = 0;                  //  배치 쌓인 줄 수

        long kopo28_startTime = System.currentTimeMillis(); // 시작 시간 기록

        try (
            //  MySQL 연결
            Connection kopo28_conn = DriverManager.getConnection(
                "jdbc:mysql://192.168.23.235:3306/kopoctc?rewriteBatchedStatements=true",
                "root", "lleejin71"
            );
            //  CSV 파일 읽기 준비
            CSVReader kopo28_reader = new CSVReader(new FileReader(kopo28_FILE_PATH));
            // Statement 준비 (DDL용)
            Statement kopo28_stmt = kopo28_conn.createStatement()
        ) {
            // JDBC 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");

            kopo28_conn.setAutoCommit(false); //  자동 커밋 끄기

            //  기존 테이블 있으면 삭제
            kopo28_stmt.execute("DROP TABLE IF EXISTS " + kopo28_tableName);

            // 테이블 생성 쿼리 만들기
            StringBuilder kopo28_createSQL = new StringBuilder();
            kopo28_createSQL.append("CREATE TABLE ").append(kopo28_tableName).append(" (\n");
            for (int i = 0; i < kopo28_columns.length; i++) {
            	kopo28_createSQL.append(kopo28_columns[i]);
                if (i != kopo28_columns.length - 1) {
                	kopo28_createSQL.append(",\n");
                }
            }
            kopo28_createSQL.append(",\nPRIMARY KEY (bsop_date, stnd_iscd)\n");
            kopo28_createSQL.append(") DEFAULT CHARSET=utf8mb4;");

            kopo28_stmt.execute(kopo28_createSQL.toString()); //  테이블 생성 실행
            System.out.println(" 테이블 생성 완료");

            //  INSERT 쿼리 자동 생성
            String kopo28_insertQuery = "INSERT IGNORE INTO " + kopo28_tableName +
                    " VALUES (" + String.join(", ", Collections.nCopies(kopo28_columnCount, "?")) + ")";
            PreparedStatement kopo28_pstmt = kopo28_conn.prepareStatement(kopo28_insertQuery);

            //  CSV 데이터 읽어서 삽입
            String[] kopo28_fields;
            while ((kopo28_fields = kopo28_reader.readNext()) != null) {
                if (kopo28_fields.length != kopo28_columnCount) { //  컬럼 수 불일치 체크
                    System.out.printf("[❌ 필드 수 불일치] 라인 %d: %d개 (%s)\n", kopo28_lineCnt + 1, kopo28_fields.length, Arrays.toString(kopo28_fields));
                    continue;
                }

                //  각 필드를 INSERT 쿼리에 바인딩
                for (int i = 0; i < kopo28_columnCount; i++) {
                    if (kopo28_fields[i] == null || kopo28_fields[i].trim().isEmpty()) {
                    	kopo28_pstmt.setNull(i + 1, Types.VARCHAR); // 빈 값은 NULL 처리
                    } else {
                    	kopo28_pstmt.setString(i + 1, kopo28_fields[i].trim()); // 값은 trim 후 삽입
                    }
                }

                kopo28_pstmt.addBatch(); //  배치에 추가
                kopo28_batchCnt++;
                kopo28_lineCnt++;

                if (kopo28_batchCnt % kopo28_batchSize == 0) {
                	kopo28_pstmt.executeBatch(); //  10,000건마다 실행
                	kopo28_conn.commit();         //  커밋
                    System.out.printf("[%d건 배치 실행 및 커밋 완료]\n", kopo28_batchCnt);
                } 
            }

            // 남은 데이터 최종 삽입
            kopo28_pstmt.executeBatch();
            kopo28_conn.commit();
            System.out.printf("[남은 %d건 배치 실행 및 커밋 완료]\n", kopo28_batchCnt % kopo28_batchSize);

            long kopo28_endTime = System.currentTimeMillis(); // 끝난 시간 기록
            long kopo28_elapsedTime = kopo28_endTime - kopo28_startTime;    // 걸린 시간 계산
            long kopo28_minutes = kopo28_elapsedTime / 1000 / 60;
            long kopo28_seconds = (kopo28_elapsedTime / 1000) % 60;

            // 최종 처리 결과 출력
            System.out.println("\n========= 실행 결과 =========");
            System.out.printf("처리 레코드 수: %d건\n", kopo28_lineCnt);
            System.out.printf("총 소요시간: %d분 %d초 (%d ms)\n", kopo28_minutes, kopo28_seconds, kopo28_elapsedTime);

            //  리소스 정리
            kopo28_pstmt.close();
            kopo28_conn.close();
            kopo28_reader.close();

        } catch (Exception e) {
            //  에러 발생 시 출력
            System.err.println("❗ 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
