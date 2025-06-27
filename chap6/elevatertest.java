package chap6;

public class elevatertest { //클래스 선언
    
    static Elevater2 ko28_eLev1;
    static Elevater2 ko28_eLev2;
    static Elevater2 ko28_eLev3;
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    	ko28_eLev1 = new Elevater2(); // 기본 엘리베이터
    	ko28_eLev2 = new Elevater2(20,1,8); // 맞춤 엘리베이터1
    	ko28_eLev3 = new Elevater2(50,-3,5); // 맞춤 엘리베이터2

        for (int ko28_i = 0; ko28_i < 20; ko28_i++) {
        	ko28_eLev1.ko28_up(); ko28_eLev1.ko28_msg("1번엘베 한층 오르기");
            // eLev2.up(); eLev2.msg("2번엘베 한층 오르기");
            // eLev3.up(); eLev3.msg("3번엘베 한층 오르기");
        }

        for (int i = 0; i < 20; i++) {
        	ko28_eLev1.ko28_up(2); ko28_eLev1.ko28_msg("1번엘베 2층씩 오르기");
            // eLev2.up(2); eLev2.msg("2번엘베 2층씩 오르기");
            // eLev3.up(2); eLev3.msg("3번엘베 2층씩 오르기");
        }

        for (int i = 0; i < 20; i++) {
        	ko28_eLev1.ko28_down(3); ko28_eLev1.ko28_msg("1번엘베 3층씩 내리기");
            // eLev2.down(3); eLev2.msg("2번엘베 3층씩 내리기");
            // eLev3.down(3); eLev3.msg("3번엘베 3층씩 내리기");
        }
    }
}