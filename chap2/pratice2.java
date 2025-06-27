package chap2;

public class pratice2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ko28_i=1; //초기값 변수 설정 
		long ko28_result=1; //곱셈을 저장할 변수 설정 
		
		
		while (ko28_i<=10) { //무한 무프 
			ko28_result*=ko28_i;// ko28_result = ko28_result * ko28_i;
			ko28_i++;// ko28_i 값을 1 증가
		}
		
		System.out.println("1부터 10까지의 곱:" +ko28_result); //출력
	}

}
