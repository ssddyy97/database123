package chap6;

public class elevatertest2 { //클래스 선언 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Elevater4 ko28_elev3; //객체 설정 

        ko28_elev3 = new Elevater4(); //elevater4 는 elevater2의 모든 기능 사용가능 인슽턴스 생성 
        
        // 엘리베이터를 10번 올림
        for (int ko28_upi = 0; ko28_upi < 10; ko28_upi++) { //for 구문 0부터 10까지 증가 
        	ko28_elev3.ko28_up(); //엘레베이터가 올라갈때 
            System.out.printf("MSG elev3[%s]%n", ko28_elev3.ko28_help); //현재층 메세지 출력 
        }

        // 엘리베이터를 10번 내림
        for (int ko28_i = 0; ko28_i < 10; ko28_i++) {//for 구문 0부터 10까지 증가 
        	ko28_elev3.ko28_down(); //엘레베이터가 내려갈때 
            System.out.printf("MSG elev3[%s]%n", ko28_elev3.ko28_help); //현재층의 메세지출력 
        }

        // 엘리베이터를 수리 중 상태로 변경
        ko28_elev3.ko28_Repair(); //객체 설정 
        System.out.printf("MSG elev3[%s]%n", ko28_elev3.ko28_help); //수리충 입력값 출력 
    }
}