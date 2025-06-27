package chap4;

public class test8 { //class 선언 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] ko28_iLMD= {31,28,31,30,31,30,31,31,30,31,30,31};//초기값 최대설정  일수 설정 
		//단 배열은 0부터 시작한다는 것에 유의 LastMonthDate
		
		for(int ko28_i=1;ko28_i<13;ko28_i++) {//for문 1~12까지 반복 
			System.out.printf("%d월 =>",ko28_i);//출력값 입력 
			for(int ko28_j=1;ko28_j<32;ko28_j++) { //for문 1~31까지 반복 
				
				System.out.printf("%d",ko28_j);//입력값 출력 
				
				if(ko28_iLMD[ko28_i-1]==ko28_j) break; // if 조건문 일치하면 break
				
				System.out.printf(",");//입력값 출력 , 지우는 방법
				
			}
			System.out.printf("\n"); //입력값 출력 
		}
		

	}

}
