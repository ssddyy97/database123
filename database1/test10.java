package database1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class test10 {
    public static void main(String[] args) {
        // DB 접속 정보
        String url = "jdbc:mysql://192.168.23.235:3306/kopoctc?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "lleejin71";

        // CREATE TABLE SQL
        String createTableQuery = 
            "CREATE TABLE stoke2 (" +
            "stnd_iscd VARCHAR(13) NOT NULL," +
            "bsop_date INT NOT NULL," +
            "shrn_iscd VARCHAR(10) NOT NULL," +
            "stck_prpr INT," +
            "stck_oprc INT," +
            "stck_hgpr INT," +
            "stck_lwpr INT," +
            "prdy_vrss_sign CHAR(2)," +
            "prdy_vrss INT," +
            "prdy_ctrt FLOAT," +
            "prdy_vol BIGINT," +
            "acml_vol BIGINT," +
            "acml_tr_pbmn BIGINT," +
            "askp1 INT," +
            "bidp1 INT," +
            "total_askp_rsqn BIGINT," +
            "total_bidp_rsqn BIGINT," +
            "seln_cntg_smtn BIGINT," +
            "shnu_cntg_smtn BIGINT," +
            "seln_tr_pbmn BIGINT," +
            "shnu_tr_pbmn BIGINT," +
            "seln_cntg_csnu INT," +
            "shnu_cntg_csnu INT," +
            "w52_hgpr INT," +
            "w52_lwpr INT," +
            "w52_hgpr_date INT," +
            "w52_lwpr_date INT," +
            "ovtm_untp_bsop_hour INT," +
            "ovtm_untp_prpr INT," +
            "ovtm_untp_prdy_vrss INT," +
            "ovtm_untp_prdy_vrss_sign CHAR(2)," +
            "ovtm_untp_askp1 INT," +
            "ovtm_untp_bidp1 INT," +
            "ovtm_untp_vol BIGINT," +
            "ovtm_untp_tr_pbmn BIGINT," +
            "ovtm_untp_oprc INT," +
            "ovtm_untp_hgpr INT," +
            "ovtm_untp_lwpr INT," +
            "mkob_otcp_vol BIGINT," +
            "mkob_otcp_tr_pbmn BIGINT," +
            "mkfa_otcp_vol BIGINT," +
            "mkfa_otcp_tr_pbmn BIGINT," +
            "mrkt_div_cls_code CHAR(2)," +
            "pstc_dvdn_amt BIGINT," +
            "lstn_stcn BIGINT," +
            "stck_sdpr INT," +
            "stck_fcam FLOAT," +
            "wghn_avrg_stck_prc DOUBLE," +
            "issu_limt_rate FLOAT," +
            "frgn_limt_qty BIGINT," +
            "oder_able_qty BIGINT," +
            "frgn_limt_exhs_cls_code CHAR(2)," +
            "frgn_hldn_qty BIGINT," +
            "frgn_hldn_rate FLOAT," +
            "hts_frgn_ehrt FLOAT," +
            "itmt_last_nav FLOAT," +
            "prdy_last_nav FLOAT," +
            "trc_errt FLOAT," +
            "dprt FLOAT," +
            "ssts_cntg_qty BIGINT," +
            "ssts_tr_pbmn BIGINT," +
            "frgn_ntby_qty BIGINT," +
            "flng_cls_code CHAR(3)," +
            "prtt_rate FLOAT," +
            "acml_prtt_rate FLOAT," +
            "stdv FLOAT," +
            "beta_cfcn FLOAT," +
            "crlt_cfcn FLOAT," +
            "bull_beta FLOAT," +
            "bear_beta FLOAT," +
            "bull_dvtn FLOAT," +
            "bear_dvtn FLOAT," +
            "bull_crlt FLOAT," +
            "bear_crlt FLOAT," +
            "stck_mxpr INT," +
            "stck_llam INT," +
            "icic_cls_code CHAR(3)," +
            "itmt_vol BIGINT," +
            "itmt_tr_pbmn BIGINT," +
            "fcam_mod_cls_code CHAR(3)," +
            "revl_issu_reas_code CHAR(3)," +
            "orgn_ntby_qty BIGINT," +
            "adj_prpr INT," +
            "fn_oprc INT," +
            "fn_hgpr INT," +
            "fn_lwpr INT," +
            "fn_prpr INT," +
            "fn_acml_vol BIGINT," +
            "fn_acml_tr_pbmn BIGINT," +
            "fn_prtt_rate FLOAT," +
            "fn_flng_cls_code CHAR(3)," +
            "buyin_nor_prpr INT," +
            "buyin_nor_prdy_vrss INT," +
            "buyin_nor_vol BIGINT," +
            "buyin_nor_tr_pbmn BIGINT," +
            "buyin_tod_prpr INT," +
            "buyin_tod_prdy_vrss INT," +
            "buyin_tod_vol BIGINT," +
            "buyin_tod_tr_pbmn BIGINT," +
            "PRIMARY KEY (bsop_date, stnd_iscd)" +
            ") DEFAULT CHARSET=utf8mb4;";

        try (
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement()
        ) {
            // 테이블 삭제 먼저
            stmt.execute("DROP TABLE IF EXISTS THTSKS010H00");
            System.out.println("기존 테이블 삭제 완료");

            // 테이블 생성
            stmt.execute(createTableQuery);
            System.out.println("새로운 테이블 생성 완료");

        } catch (Exception e) {
            System.err.println("❗오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
