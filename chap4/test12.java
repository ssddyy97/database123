package chap4;

public class test12 { //클래스 선언 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double ko28_fSin;//변수값 설정 
		
		for(int ko28_i=0; ko28_i<360; ko28_i++) {//for문 0부터 359까지
			ko28_fSin= Math.sin(ko28_i*3.141592/180);//각도를 라디안으로 변환하여 Math.sin()로 사인 값 계산
			
			System.out.printf("%d sin==>%f\n",ko28_i,ko28_fSin); //입력값 출력 
		}
		
		for (int ko28_i=0; ko28_i<360; ko28_i++) { //for 구문 
			ko28_fSin=Math.sin(ko28_i*3.141592/180);//각도를 라디안으로 변환하여 Math.sin()로 사인 값 계산
			
			
			int ko28_iSpace=(int)((1.0+ko28_fSin)*50);// 정수형 값 설정 
			for(int ko28_j=0; ko28_j<ko28_iSpace; ko28_j++) System.out.printf(" ");//for 구문 공백을 출력하여 *의 위치를 조정.
			//왼쪽부터 ko28_iSpace만큼 띄운 후 *을 출력
			System.out.printf("*[%f][%d]\n",ko28_fSin,ko28_iSpace);//입력값 출력
		}
	}

}
