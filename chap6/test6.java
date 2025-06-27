package chap6;

public class test6 { //클래스 선언 
	//클래스 메소드는 아귀먼트(argment,매개변수) 형식이나 갯수가 다르면 이름은 동일하게 사용하여 편리하게 사용할 수 있는데,
	//이따위 짓을 메소드 오버로딩(Overloading)

	public int ko28_sum(int ko28_a,int ko28_b) { //int 타입 두 개(a, b)를 입력받아 더한 값
		return ko28_a+ko28_b; //반환 
	}
	public int ko28_sum(int ko28_a,int ko28_b, int ko28_c) { //int 타입 세 개(a, b, c)를 입력받아 더한 값
		return ko28_a+ko28_b+ko28_c; //반환 
	}
	public int ko28_sum(int ko28_a, int ko28_b, int ko28_c,int ko28_d) {//int 타입 네 개(a, b, c,d)를 입력받아 더한 값.
		return ko28_a+ko28_b+ko28_c+ko28_d; //반환 
	}
	public double ko28_sum(double ko28_a,double ko28_b) {//int 타입 2 개(a, b)를 입력받아 더한 값을 반환함.
		return ko28_a+ko28_b; //반환 
	}

	}

