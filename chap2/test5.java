package chap2;


import java.util.Scanner;

public class test5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			//스캐너의 값을 입력하는 것 
			Scanner sc=new Scanner(System.in); //스캐너의 객체 설정 
			System.out.printf("자바시험 몇점 받았는지 입력하시오"); //사용자에게 입력을 요청하는 메시지 출력.
			int ko28_i=sc.nextInt(); //정수 입력 받기 
			
			if(ko28_i>90) System.out.printf("아이구 이쁜 강아지"); // 시험 숫자가 ko28_i>90이면 출력
			else if(ko28_i>80) System.out.printf("아이구 쪼금 이쁜 강아지"); //시험숫자가 ko28_i>80이면 출력 
			else if(ko28_i>70) System.out.printf("건강하게만 자라라");//시험숫자가 ko28_i>60 이면 출력
			else if(ko28_i>60) System.out.printf("학교 잘 다녀왓으면 밥먹자");// 시험숫자가 ko28_i>60이면 출력
			else System.out.printf("좀 맞자"); // 그외 다른 것일 경우
			
		
} 
}


