package chap2;

public class test10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ko28_i; //변수설정
		
		ko28_i=1; //초기값 설정 
		while(true) { //무한루프 
			ko28_i=ko28_i+1; // ko28_i 값을 1 증가
			System.out.println("하나씩 더해보자"+(ko28_i)); //ko28_i 값을 출력
			if(ko28_i>=10) break; //ko28_i가 10 이상이 되면 break를 실행하여 반복문 종료
			
		}
		
		System.out.println("********************"); //점선 출력 
		
		ko28_i=0;//초기값 설정 
		while(true) { //무한루프 
			ko28_i=ko28_i+1; // ko28_i 값을 1 증가
			System.out.println("하나씩더해보자"+(ko28_i));//ko28_i 값을 출력
			if (ko28_i>=10) break; //ko28_i가 10 이상이 되면 break를 실행하여 반복문 종료
		}
		
		System.out.println("*******************"); //점선 출력 
		
		ko28_i=1; //초기값 설정 
		while(true) { // 무한 루프 
			System.out.println("하나씩 더해보자"+(ko28_i)); //ko28_i 값을 출력
			ko28_i=ko28_i+1; // ko28_i 값을 1 증가
			if (ko28_i>=10) break; //ko28_i가 10 이상이 되면 break를 실행하여 반복문 종료
			
			
		}
	}

}
