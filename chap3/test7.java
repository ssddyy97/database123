package chap3;

public class test7 { //클래스 선언 
	
	//심심한데 함수한번 만들어볼까?
	//대충 main에 써있는 public static void를 배껴봐""
	//일단 public은 이 클래스 MYTest밖에서도 사용할 수 있다는 의미인데
	//어차피 main은 같은 클래스 안이라서 상관없고..
	//static은 자리를 차지하고... 부를때 new로 부르는게 아니라는거...
	//void는 반환값이 없다는 의미 하지만 우리는 세금값 int를 반환하다.
	//아 복잡 이런거 차츰 연습하다 익숙해지면 알고... 일단 배껴봐
	public static int ko28_netprice(int price, double rate) { // 소비자 가격 price, double 세율 
			return(int)(price/(1+rate)); // int로 변환 세금이 포함된 price 새전 가격을 계산 
			//세전 가격 =소비자 가격 %(1+세율)
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ko28_price=1234; //변수 설정 초기값 설정 소비자 가격  
		double ko28_tax_rate=0.1; // 초기값 설정  세율 (10%)
		
		int ko28_netprice=ko28_netprice(ko28_price, ko28_tax_rate); //초기값 설정 세전 가격 계산 
		int ko28_tax=ko28_price-ko28_netprice; //초기값 설정 세금 계산 
		System.out.printf("***************************\n");//입력값 출력 
		System.out.printf("* 소비자가,  세전가격, 세금 계산 *\n");//입력값 출력 
		System.out.printf(" 소비자가격:%d, 세전가격:%d, 세금:%d\n", ko28_price, ko28_netprice, ko28_tax);//입력값 출력 
		System.out.printf("***************************\n");//입력값 출력 
	}

}
