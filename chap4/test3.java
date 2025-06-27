package chap4;

public class test3 { //클래스 선언 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ko28_il; //초기값 설정 
		double ko28_iD; //실수형 변수 선언
		ko28_il=10/3; // 10을 3으로 나눈 결과 
		ko28_iD=10/3.0; //10을 3.0으로 나눈 결과 
				
		if(ko28_il==ko28_iD) { // if문 비교하기  
			System.out.printf("equal\n");//입력값 출력 같으면 equal
		}else {//if 구문 
			System.out.printf("Not equal[%f][%f]\n",(double)ko28_il,ko28_iD);
		}//입력값 출력 아니면 Not equal  
		
		if(ko28_iD==3.333333) System.out.printf("equal\n");//if 구문 
		else System.out.printf("Not equl[3.333333][%f}\n",ko28_iD);// if 구문 
		
		ko28_iD=(int)ko28_iD;//초기값 설정 실수에서 정수형으로 변환  
		if (ko28_il==ko28_iD) System.out.printf("equal\n");// if 구문 
		else System.out.printf("Not eqal[%f][%f]\n",(double)ko28_il,ko28_iD);//아니면  
		
		System.out.printf("int로 인쇄[%d][%f]\n",ko28_il,ko28_iD); //입력값 출력 
		System.out.printf("double로 인쇄[%f][%f]\n",(double)ko28_il,ko28_iD); //입력값 출력 
		
		char ko28_a='c'; //초기값 설정 
		
		
		if(ko28_a=='b')System.out.printf("a는 b이다\n"); //if구문 입력값 출력 
		if(ko28_a=='c')System.out.printf("a는 c이다\n"); //if 구문 입력값 출력 
		if(ko28_a=='d')System.out.printf("a는 d이다\n"); //if 구문  입력값 출력 
			
		String ko28_aa="abcd"; //초기값 설정 
		
		
		if(ko28_aa.equals("abcd")) System.out.printf("aa는 abcd이다\n");//if 구문 입력값 출력 
		else System.out.printf("aa는 abcd이 아니다\n");//if 구문 입력값 출력 
		
		boolean ko28_bb=true;//논리형 연산 
		
		if(!!ko28_bb)System.out.printf("bb가 아니고 아니면 참이다\n");//if 구문 입력값 출력 대 
		else System.out.printf("bb가 아니고 아니면 거짓이다\n");//if 구문 입력값 출력 

	}
	}
