package chap6;

public class test10 { //클래스 ㅅ

    static Elevater2 eLev1;
    static Elevater2 eLev2;
    static Elevater2 eLev3;

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        eLev1 = new Elevater2(); // 기본 엘리베이터
        eLev2 = new Elevater2(20,1,8); // 맞춤 엘리베이터1
        eLev3 = new Elevater2(50,-3,5); // 맞춤 엘리베이터2

        for (int i=0; i<20; i++){
            eLev1.up(); eLev1.msg("1번엘베 한층 오르기");
            // eLev2.up(); eLev2.msg("2번엘베 한층 오르기");
            // eLev3.up(); eLev3.msg("3번엘베 한층 오르기");
        }

        for (int i=0; i<20; i++){
            eLev1.up(2); eLev1.msg("1번엘베 2층씩 오르기");
            // eLev2.up(2); eLev2.msg("2번엘베 2층씩 오르기");
            // eLev3.up(2); eLev3.msg("3번엘베 2층씩 오르기");
        }

        for (int i=0; i<20; i++){
            eLev1.down(3); eLev1.msg("1번엘베 3층씩 내리기");
            // eLev2.down(3); eLev2.msg("2번엘베 3층씩 내리기");
            // eLev3.down(3); eLev3.msg("3번엘베 3층씩 내리기");
        }
    }
}