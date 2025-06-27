package chap6;

public class remotecontest3 { //클래스 선언 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		tvremocon3 ko28_elev3; //객체설정 
		
		ko28_elev3= new tvremocon3(); //tvremocon2의 모든 기능을 가져다가 쓸수 잇음 
		for(int i=0; i<10; i++) { //for문 0부터 10까지 증가 
			ko28_elev3.ko28_up();//채널이 점점 증가함
			System.out.printf("MSG remote3[%s]\n",ko28_elev3.ko28_help); //현재 메세지 출력 
		}
		
		for(int i=0; i<10; i++) { //for문 0부터 10까지 증가 
			ko28_elev3.ko28_down();//채널이 점점 감소함 
			System.out.printf("MSG remote3[%s]\n",ko28_elev3.ko28_help);//현재 메세지 출력 
		

	}
		ko28_elev3.ko28_Repair();//객체 설정 
		System.out.printf("MSG remote3[%s]\n",ko28_elev3.ko28_help);//수리중 메세지 출력 
}
}
