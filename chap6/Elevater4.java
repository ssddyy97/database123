package chap6;

public class Elevater4 extends Elevater2 {

    void ko28_Repair() {  //생성자
        ko28_help = String.format("수리중입니다."); //수리중이라는 메세지 설정 
    }

    void ko28_up() { // 엘리베이터가 올라감
        if (ko28_floor >= ko28_limit_up_floor) { //최대 층에 도달 
        	ko28_help = "마지막층입니다."; //마지막 층의 메세지 출력 
        } else {//그외일때 
        	ko28_floor = ko28_floor + 2; // 최상층이 아닐 때 두 층씩 올라감
        	ko28_help = String.format("%d층입니다.", ko28_floor); //현재층의 메세지 출력 
        }
        this.ko28_down(); // 만일 이렇게 하면 두 칸 올라가고 한 칸 내려가는 결과가...
    }

    void ko28_down() { // 엘리베이터가 내려감
        super.ko28_down();
        System.out.printf("클래스 안에서 찍고있는 MSG [%s]%n", this.ko28_help); //입력값 출력 
        // this.down(); 재귀호출시 무한루프 발생 가능...
    }
}