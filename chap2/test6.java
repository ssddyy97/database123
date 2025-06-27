package chap2;

import java.util.Scanner;

public class test6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.printf("\n\n==================\n\n"); //점선 출력 
		Scanner ko28_sc = new Scanner(System.in); //스캐너 객체 설정 
		System.out.printf("학교 시험을 봤는데 점수가 몇점입니까"); //출력
		String ko28_s= ko28_sc.next(); //사용자로부터 문자열 입력(String s)을 받음.
		
		//스위치 문은 각 값을 지정해야 한다
		//좀 어렵지만 글자만 받는 char형으로 형변환 한다
		//어울려 break; 문장이 없으면 곤란하다
		//default의 역활을 이해해야 한다
		
		switch(ko28_s.charAt(0) ) { //ko28_s.charAt(0) → 입력한 문자열 ko28_s의 첫 번째 문자(0번째 인덱스)를 가져옴
		case 'A' : //A점수 입력된 경우
			System.out.printf("나쁘지는 않네요"); //출력 
			break; //멈춤 
		case 'B' : //B점수 입력된 경우
			System.out.printf("참 잘했어요");//출력
			break; //멈춤
		case 'C' : //C점수 입력된 경우
			System.out.printf("보통이네요 분발해야겠네요");//출력
			break; //멈춤
		case 'D' : //D점수 입력된 경우
			System.out.printf("더 연습이 필요하겠어요");//출력
			break; //멈춤
		case 'F' : //F점수 입력된 경우
			System.out.printf("처음부터 개념을 다시 배워야겠네?");//출력
			break; //멈춤
		default: //다른 문자가 입력된 경우
			System.out.printf("입력규칙을 좀 맞추시오");//출력
			break; //멈춤
		}
	}

}
