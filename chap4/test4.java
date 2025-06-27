package chap4;

public class test4 { //클래스 설정 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ko28_iVal; //정수형 변수 선언 
		for(int ko28_i=0; ko28_i<300; ko28_i++) { //for 구문 0~299 반복
			ko28_iVal=5*ko28_i; //규칙 설정 
			if(ko28_iVal >=0 && ko28_iVal<10) System.out.printf("일 %d\n",ko28_iVal);//ko28_iVal 값이 0 이상 10 미만 → 일
			else if(ko28_iVal >= 10 && ko28_iVal<100)System.out.printf("십 %d\n", ko28_iVal);//ko28_iVal 값이 10 이상 100 미만 → 십
			else if(ko28_iVal >= 100 && ko28_iVal<1000)System.out.printf("백 %d\n", ko28_iVal); //ko28_iVal 값이 100 이상 1000 미만 → 백 
			else System.out.printf("천 %d\n",ko28_iVal);//ko28_iVal 값이 1000 이상 → 천
		}
	}

}
