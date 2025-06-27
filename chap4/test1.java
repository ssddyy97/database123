package chap4;

import java.util.Scanner;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner ko28_sc=new Scanner(System.in); //스캐너의 객체 설정 
		System.out.printf("자바시험 몇점 받았는지 입력하시오"); //사용자에게 입력을 요청하는 메시지 출력.
		int ko28_score=ko28_sc.nextInt(); //정수 입력 받기 
		if(ko28_score>90) { //if 문 
		System.out.println("A"); // 입력값 출력 
		}else if(ko28_score>=80 && ko28_score <=90) { //if문 다른조건 
		System.out.println("B");// 입력값 출력 
		}else if (ko28_score >=70 && ko28_score <80) { //if문 다른 조건 
			System.out.printf("c");//출력 
		}else {//그외의 
			System.out.println("D");//출력 
		}
		
	}

}
