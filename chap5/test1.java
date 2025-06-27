package chap5;

public class test1 { //클래스 선언 

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		
		for(int ko28_i=1; ko28_i<10; ko28_i=ko28_i+3) { //for 문 1~9까지 반복
			System.out.printf("***********************\t***********************\t***********************\n"); //각 칸마다 별표로 나누어서 출력 
			System.out.printf("구구단%d단             \t구구단%d단           \t구구단%d단          \t\n",ko28_i,ko28_i+1,ko28_i+2);// 구구단 123의 값으로 입력값 출력
			//첫 번째 실행: "구구단 1단", "구구단 2단", "구구단 3단"
			//두 번째 실행: "구구단 4단", "구구단 5단", "구구단 6단"
			//세 번째 실행: "구구단 7단", "구구단 8단", "구구단 9단"
			System.out.printf("***********************\t***********************\t***********************\n");//각 칸이 끝나면 별표로 선을 나누고 입력값 출력 
			//입력값 출력 
			for(int ko28_j=1;ko28_j<10;ko28_j++) {//for 문 1~9까지 곱셉 반복 
				System.out.printf("%d*%d = %2d\t\t%d*%d = %2d\t\t%d*%d = %2d\n",// 각 칸마다 구구단의 입력값 출력 
						ko28_i,ko28_j,ko28_i*ko28_j,  //가로로 첫번째  곱셉 값 
						(ko28_i+1),ko28_j,(ko28_i+1)*ko28_j,//두번째 곱샙값 
						(ko28_i+2),ko28_j,(ko28_i+2)*ko28_j); //세번째 곱셉값 
	

			}
			System.out.println();//각 단 그룹이 끝난 후 한 줄 띄우기
		}
	}
}


