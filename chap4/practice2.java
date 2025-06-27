package chap4;

public class practice2 { //클래스 선언 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ko28_sum=0;//초기값 설정 
		for(int ko28_i=0; ko28_i<10; ko28_i++) { //for 문 0부터 9까지 반복 
			ko28_sum=ko28_sum+ko28_i;//0~9까지의 합 저장 
		}
		System.out.printf("sum %d\n",ko28_sum);//입력값 출력 
		
		for(int ko28_i=1; ko28_i<10; ko28_i++) { //for 문 1~9까지 반복
			System.out.printf("**********************************\n",ko28_i); //입력값 출력  
			System.out.printf("		구구단	%d 단\n",ko28_i);
			System.out.printf("**********************************\n",ko28_i); //입력값 출력 
			for(int ko28_j=1;ko28_j<10;ko28_j++) {//for 문 1~9까지 곱셉 반복 
				System.out.printf(" %d*%d=%d\n",ko28_i,ko28_j,ko28_i*ko28_j); //입력값 출력 
			}
		}
	}

}
