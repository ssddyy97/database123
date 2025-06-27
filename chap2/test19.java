package chap2;

public class test19 { //클래스 선언
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ko28_x=10; //x변수값을 10으로 초기화
		int ko28_y=20; //y변수값을 20으로 초기화
		int ko28_tmp=0; //tmp 변수값을 0으로 초기화
		
		System.out.println("x:"+ko28_x+"y:"+ko28_y); //x:+x값 y:+ y값
		
		ko28_tmp=ko28_x; //tem을 x값으로 다시 초기화 tmp=10
		ko28_x=ko28_y; //x를 y값으로 다시 초기화 x=20
		ko28_y=ko28_tmp; //y를 tmp값으로 다시 초기화 y=10
		
		System.out.println("x:"+ko28_x+"y:"+ko28_y); // 결과값 도출

	}

}
