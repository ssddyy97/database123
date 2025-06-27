package chap2;

import java.util.Scanner;

public class test22 { //클래스 설정 


	public static void main(String[] args) {
		Scanner  ko28_scanner = new Scanner(System.in); //System.in을 이용하여  Scanner 객체 설정
			System.out.print("두자리 정수를 하나 입력해주세여.>"); //출력
			String ko28_input=  ko28_scanner.nextLine(); // 사용자가 입력한 한줄을 문자열로 받음 
			int  ko28_num=Integer.parseInt( ko28_input); // 문자열을 정수로 변환 
			
			System.out.println("입력내용:"+ ko28_input); //입력된 문자열 출력 
			System.out.printf("num=%d%n",  ko28_num); //정수값 출력  ( %d정수 출력 형식 %n 줄바꿈)
		 

		}
				
		
			
			
	}


