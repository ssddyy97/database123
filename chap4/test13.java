package chap4;

public class test13 {//클래스 선언 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		
		int ko28_n,ko28_m; // 초기값 설정 
		ko28_m=20;ko28_n=1; //초기 공백개수(왼쪽 여백) 초기 '*' 개수(첫줄의 별개수
		while(true) { //무한 루프  
		for(int ko28_i=0; ko28_i<ko28_m; ko28_i++)System.out.printf(" ");//for 문 ko28_m 개수만큼 공백( )을 출력하여 별이 오른쪽에 정렬  
			
		for(int ko28_i=0; ko28_i<ko28_n; ko28_i++)System.out.printf("*");//for 문 ko28_n 개수만큼 별(*)을 출력.
		System.out.printf("\n"); //입력값 출력 
		
		ko28_m=ko28_m-1;// 왼쪽 공백 1칸 감소
		ko28_n=ko28_n+2;	// '*' 개수를 2개 증가
				
		if (ko28_m<0)break;//if문 공백(ko28_m)이 0보다 작아지면 루프 종료.
		}

}
}