package chap6;

public class remotecontest2{ //클래스 선언 
    
    static tvremocon2 ko28_eLev1; //객체 설정 
    static tvremocon2 ko28_eLev2; //객체 설정 
    static tvremocon2 ko28_eLev3; //객체 설정 
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    	ko28_eLev1 = new tvremocon2(); // 기본 리모콘 
    	ko28_eLev2 = new tvremocon2(20,10,20,10,8,10); // 맞춤 리모컨1
    	ko28_eLev3 = new tvremocon2(50,20,50,20,5,10); // 맞춤 리모컨2

        for (int i = 0; i < 20; i++) {
        	ko28_eLev1.ko28_up1(5); ko28_eLev1.ko28_msg("1번리모콘 +5 올리기");
            // eLev2.up(); eLev2.msg("2번리모콘 1씩 올리기");
            // eLev3.up(); eLev3.msg("3번리모콘  1씩 올리기");
        }

       
    

        for (int i = 0; i < 20; i++) {
        	ko28_eLev1.ko28_down1(5); ko28_eLev1.ko28_msg("3번리모콘 5씩 내리기");
            // eLev2.down(3); eLev2.msg("2번리모콘 3씩 내리기");
            // eLev3.down(3); eLev3.msg("3번리모콘 3씩 내리기");
        }
        for (int i = 0; i < 20; i++) {
        	ko28_eLev1.ko28_up(10); ko28_eLev1.ko28_msg1("2번채널  +10 올리기");
            // eLev2.up(2); eLev2.msg("2번리모콘 2씩 올리기");
            // eLev3.up(2); eLev3.msg("3번리모콘 2씩 올리기");
    }
        for (int i = 0; i < 20; i++) {
        	ko28_eLev1.ko28_down(10); ko28_eLev1.ko28_msg1("2번채널  -10 내리기");
            // eLev2.up(2); eLev2.msg("2번리모콘 2씩 올리기");
            // eLev3.up(2); eLev3.msg("3번리모콘 2씩 올리기");
    }
    }
}
