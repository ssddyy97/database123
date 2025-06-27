package chap6;

public class test1 { //클래스 선언 

	public static void ko28_iamMethod(){ 
		System.out.printf("메소드라 불러줘요~~\n");
		
		//변수는 변수.. 메서드(method)는 함수를 메서드라고 지칭함 
		//일단 자기 클래스 안에 함수를 정의하면 함수이름만으로 불러올 수 있다.
		//(클래스명.메소드명 이 원칙이지만 클래스명 생략)

	}
	public static void main(String[] args) {
		
		test1.ko28_iamMethod();//클래스 이름을 사용하여 메소드 호출 
		ko28_iamMethod(); // 같은 클래스 내부에서 바로 호출가능
		// TODO Auto-generated method stub

	}

}
