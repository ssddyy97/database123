package chap4;

public class test6 {//클래스 선언 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int ko28_i=1; ko28_i<13; ko28_i++) { //for 구문 1~12까지
			System.out.printf("%d월=>", ko28_i); //입력값 출력 
			for(int ko28_j=1;ko28_j<32;ko28_j++) { //for 구문 1~31까지
				
				System.out.printf("%d,",ko28_j); //날짜 출력
				
				if(ko28_i==4||ko28_i==6||ko28_i==9||ko28_i==11) { // // 4,6,9,11월 (30일까지)
					if(ko28_j==30) break; //30일때 중지
				}
				
				if(ko28_i==2) { //if 구문 
					if(ko28_j==28) break;//28일때 중지
					
				}
			}
			System.out.printf("\n");//입력값 출력 
		}
		
			System.out.printf("\n");//입력값 출력
			System.out.printf("***********************************************************************************\n");//입력값 출력
			System.out.printf("\n");//입력값 출력
			
			for(int ko28_i=1; ko28_i<13;ko28_i++) { //for구문 1~12까지 반복 
				System.out.printf("%d월 =>", ko28_i);//입력값 출력 
				for(int ko28_j=1; ko28_j<32;ko28_j++) { //for 구문 1~12까지 반복 
					System.out.printf("%d,",ko28_j); //입력값 출력 
					
					if((ko28_i==4||ko28_i==6||ko28_i==9||ko28_i==11)&&(ko28_j==30)) break; // 4,6,9,11월 (30일까지)
					if(ko28_i==2 && ko28_j==28) break; //2월은 28일 중지
					
				}
				System.out.printf("\n"); //입력값 출력 
			}
	}

}
