package chap6;

public class remocontest1 { //클래스 선언 
	
	    public static void main(String[] args) { //a
	        tvremocon ko28_remote = new tvremocon(); // TvRemocon 객체 생성

	        // 채널 10번 올리기
	        for (int ko28_i = 0; ko28_i < 10; ko28_i++) { //for문 0부터 10까지 증가 
	        	ko28_remote.ko28_ChannelUp(); //채널의 증가
	
	        }

	        // 채널 10번 내리기
	        for (int ko28_i = 0; ko28_i < 10; ko28_i++) {//for문 0부터 10까지 증가 
	        	ko28_remote.ko28_ChannelDn();//채널 감소
	        }

	        // 볼륨 5번 올리기
	        for (int ko28_i = 0; ko28_i < 5; ko28_i++) {//for문 0부터 5까지 증가
	        	ko28_remote.ko28_VolUp(); //볼륨 증가
	        }

	        // 볼륨 5번 내리기
	        for (int ko28_i = 0; ko28_i < 5; ko28_i++) {//for문 0부터 5까지 증가
	        	ko28_remote.ko28_VolDn(); //볼륨 감소
	        }
	    }
	}

