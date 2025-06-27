package chap6;
class tvremocon {
    private int ko28_volume = 1;  // 기본 볼륨 값
    private int ko28_channel = 1; // 기본 채널 값
    private final int ko28_up_volume = 10;  // 최대 볼륨
    private final int ko28_down_volume = 1; // 최소 볼륨
    private final int ko28_up_channel = 5; // 최대 채널
    private final int ko28_down_channel = 1; // 최소 채널
    private String ko28_help; //구문 설정 

    // 볼륨 증가
    public void ko28_VolUp() { 
        if (ko28_volume == ko28_up_volume) { // 최대 음량 같아 질때 
            ko28_help = "최대 음량 입니다"; //음량이 최대라는 문자열 출력 
        } else { //그외일때
            ko28_volume++;   //계속 증가한다
            ko28_help = String.format("현재 볼륨: %d", ko28_volume); //문자열 출력 현재 음량
        }
        System.out.println(ko28_help); // 메시지 출력
    }

    // 볼륨 감소
    public void ko28_VolDn() { 
        if (ko28_volume == ko28_down_volume) {  //최소 음량과 같아질때 
            ko28_help = "최소 음량 입니다";  //최소 음량의 문자열 출력 
        } else { //그 이외 일때 
            ko28_volume--;  //음량은 감소한다
            ko28_help = String.format("현재 볼륨: %d", ko28_volume);//문자열 출력 현재 음량
        }
        System.out.println(ko28_help);
    }

    // 채널 증가
    public void ko28_ChannelUp() {
        if (ko28_channel == ko28_up_channel) {  //현재 채널과 최대 채널이 같아 질때
            ko28_help = "더 이상 채널이 없습니다";  //문자열 출력 
        } else { //그외 일때 
            ko28_channel++;  //채널은 증가한다 
            ko28_help = String.format("현재 채널: %d", ko28_channel);//문자열 출력 현재 채널
        }
        System.out.println(ko28_help); //문자열 출력 
    }

    // 채널 감소
    public void ko28_ChannelDn() { //체널이 감소할때 
        if (ko28_channel == ko28_down_channel) { //최소 채널과 현재 채널이 같아질때
            ko28_help = "더이상  채널이 없습니다"; //문자열 출력 현재 음량 채널
        } else { //그외일때 
            ko28_channel--; //점점 감소한다 
            ko28_help = String.format("현재 채널: %d", ko28_channel); //문자열 출력 
        }
        System.out.println(ko28_help); //입력값 출력 
    }
}


