package chap6;

public class tvremocon2 { //클래스 선언 
	
	 private int ko28_limit_up_volume; //최대 음량 설정 
	 private int ko28_limit_down_volume; //최소 음량 설정 
	 private int ko28_limit_up_channel; //최대 채널 설정 
	 private int ko28_limit_down_channel; //최소 채널 설정 
	 private int ko28_currentVolume;//현재 음량
	 private int ko28_currentChannel; //현재 채널  
	 String ko28_help; //현재 상태 메세지 
	
	
	tvremocon2(){ //기본 생성자
		ko28_limit_up_volume=50; //최대 음량 초기값 
		ko28_limit_down_volume=1; //최소 음량 초기값 
		ko28_limit_up_channel=50; //최대 채널 초기값 
		ko28_limit_down_channel=1; //최소 채널 초기값 
		ko28_currentVolume=1;
		ko28_currentChannel=1;// //현재 음량 또는 채널 최소값 
		ko28_help="기본 음량 "; //메세지 출력 
		
	}
	
	tvremocon2(int ko28_up_volume, int ko28_d_volume,int ko28_up_channel,int ko28_down_channel,int ko28_currentVolume1, int ko28_currentChannel1){ 
		// 변수 설정 사용자가 최대/최소 음량, 최대/최소 채널, 초기 설정 값을 지정할 수 있음
		ko28_limit_up_volume=ko28_up_volume; //규칙 선언
		ko28_limit_down_volume=ko28_d_volume; //규칙 선언 
		ko28_limit_up_channel=ko28_up_channel; //규칙 선언 
		ko28_limit_down_channel=ko28_down_channel; //규칙 선언 
		ko28_currentVolume=ko28_currentVolume1; //규칙 선언
		ko28_currentChannel=ko28_currentChannel1;
		ko28_help=" 음량 맞춤 완료"; //음량 맞춤완료로 설정 
	}
	void ko28_up1() { //볼룸이 올라갈때 
		if(ko28_currentVolume==ko28_limit_up_volume) { //최대 음량 도달 
			ko28_help="최대 음량입니다"; //최대 음량 도달 시 메세지 표시 
		}else { //그외 
			ko28_currentVolume++; //계속 증가 
			ko28_help=String.format("[%d]음량입니다",ko28_currentVolume); //현재 음량 출력 
		}
		}
	void ko28_down1() { //볼륨이 내려갈때 
		if(ko28_currentVolume==ko28_limit_down_volume) { //최소 음량 도달 
			ko28_help="기본 음량입니다"; //최소 음량 메세지 표시 
		}else { //그외 
			ko28_currentVolume--; //계속 감소 
			ko28_help=String.format("[%d]음량입니다",ko28_currentVolume);//현재 음량 출력 
		
		}
		
	}
	void ko28_up1(int ko28_u) { //여러단계 음량 증가 
	 for(int ko28_i=0; ko28_i<ko28_u; ko28_i++) this.ko28_up1(); //매개변수 u만큼 증가 
	 
	}
	
	void ko28_down1(int ko28_u) { //여러 단계 음량 감소 
		for(int ko28_i=0;ko28_i<ko28_u; ko28_i++) ko28_down1(); //매개변수 u만큼 감소 
	}
	void ko28_msg(String id1) { 
		System.out.printf("%s=>[%s] 최대음량[%d] 최소음량[%d] 현재음량[%d]\n",
				id1,ko28_help,ko28_limit_up_volume,ko28_limit_down_volume,ko28_currentVolume);//현재 TV의 최대, 최소 , 현재 음량 정보를 출력 
	}

void ko28_up() { //기본 생성자
	if(ko28_currentChannel==ko28_limit_up_channel) { //현재 채널이 limit_up_channel이면
		ko28_help="최대 채널입니다";//최대 채널 도달 메시지 출력
	}else { //그외의 
		ko28_currentChannel++; //계속 증가 
		ko28_help=String.format("[%d]채널입니다",ko28_currentChannel); //현재 채널메세지 출력 
	}
	}
void ko28_down() {//기본생성자
	if(ko28_currentChannel==ko28_limit_down_channel) { //현재 채널이 최소 채널 도달 
		ko28_help="기본 채널입니다";//최소 채널메세지 출력 
	}else {//그외일때 
		ko28_currentChannel--; //계속 감소 
		ko28_help=String.format("[%d]채널입니다",ko28_currentChannel);//현채 채널 메세지 출력 
	
	}
	
}
void ko28_up(int ko28_u) {//여러 단계 채널 증가 
 for(int ko28_i=0; ko28_i<ko28_u; ko28_i++) this.ko28_up();
 
}

void ko28_down(int ko28_u) { //여러단계 채널 감소 
	for(int ko28_i=0;ko28_i<ko28_u; ko28_i++) ko28_down();
}
void ko28_msg1(String ko28_id) {
	System.out.printf("%s=>[%s] 최대채널[%d] 최소채널[%d] 현재채널[%d]\n",
			ko28_id,ko28_help,ko28_limit_up_channel,ko28_limit_down_channel,ko28_currentChannel); //현재 상태 메세지 출력 
}
} 