package chap4;

public class test7 { //클래스 선언 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int ko28_i=1; ko28_i<13;ko28_i++) { //for 구문 월반복
			System.out.printf("%d월=>",ko28_i); // 월출력 
			Loop:for(int ko28_j=1; ko28_j<32; ko28_j++) { //break Loop: 현재 실행 중인 for 문(Loop) 전체를 종료
				
			System.out.printf("%d,",ko28_j); //입력값 출력 
			
			
			switch(ko28_i) { //switch  문 
			case 4:case 6:case 9:case 11://현재 월이 특정한 값이면 case 실행 .
				if(ko28_j==30) break Loop; //if 구문  30이면 중단  
				
				break; //중지
			case 2://case 2의 경우 
			if(ko28_j==28) break Loop; //if 구문 28일면 중지 
			break;
			
			
			}
		
		}
			System.out.printf("\n"); //입력값 출력 
}
}
}