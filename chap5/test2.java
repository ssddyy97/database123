package chap5;

public class test2{ //클래스 선언 


		public static void main(String[] args) {
			// TODO Auto-generated method stub


			
			for(int ko28_i=1; ko28_i<=3; ko28_i++) { //for 문 각 그룹의 첫 번째 단을 의미 
				System.out.printf("***********************\t***********************\t***********************\n"); // 칸을 나누는 별의 입력값 출력  
				System.out.printf("구구단%d단       \t구구단%d단         \t구구단%d단         \t\n",ko28_i,ko28_i+3,ko28_i+6);//구구단의 각 항의 단 입력값 출력
				System.out.printf("***********************\t***********************\t***********************\n");//칸을 나누는 별의 입력값 출력 입력값 출력 
				//입력값 출력 
				for(int ko28_j=1;ko28_j<10;ko28_j++) {//for 문 1~9까지 곱셉 반복 
					System.out.printf("%d*%d = %2d\t\t%d*%d = %2d\t\t%d*%d = %2d\n",//곱하는 값과 곱셉 값을  출력 
							
							ko28_i,ko28_j,ko28_i*ko28_j, // 첫번째 규칙 선언 ko28_i 곱셉식 
							ko28_i+3,ko28_j,(ko28_i+3)*ko28_j,// 규칙선언 ko28_i+3곱셉식 
							ko28_i+6,ko28_j,(ko28_i+6)*ko28_j); //규칙 선언 ko28_i+6 곱셉식 
		

				}
				System.out.println();//입력값 출력 

		}

		}
}

