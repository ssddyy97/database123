package chap3;

public class test3 { //클래스 설정 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ko28_ii; //변수 설정 
		// 정수형 변수의 나눗셈은 정수범위에서 버림처러, 올림버림이 뭔지 모르면 집에 가든지 몰래 배워와라
		ko28_ii=1000/3; //초기값 설정 
		System.out.printf("#3-1 :%d\n", ko28_ii);// ii 출력 
		
		ko28_ii=1000%3; // 초기값 설정 
		System.out.printf("#3-2:%d\n", ko28_ii);//ii 출력 
		
		//나머지 연산자의 응용 
		for(int ko28_i=0; ko28_i<20; ko28_i++) { // for 구문 0에서 19까지 계속 증가 
			System.out.printf("#3-3:%d", ko28_i); //i 출력 
			
			if (((ko28_i+1)%5)==0) { //나머지가 0인것은 5번마다 있다. 왜 1을 더했는지 곰곰히 생각해라  (i+1)가 5로 정확히 나누어 진다면 줄 바꿈  
				System.out.printf("\n"); //줄 바꿈 출력  
			}
		}
	}

}
