package chap4;

public class test9 { //클래스 설정 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] ko28_units= {"영", "일","이","삼","사","오","육","칠","팔","구"}; //문자열 설정 
		for(int ko28_i=0; ko28_i<101; ko28_i++) { //for구문 0부터 100까지 반복 
			
			if(ko28_i>=0 && ko28_i<10) { //if 구문 
				System.out.printf("일의자리:%s\n",ko28_units[ko28_i]); //입력값 출력 
			
			}
			else if(ko28_i>=10 && ko28_i<100) {//if 구문 그외 
				int ko28_i10,ko28_i0;//정수값 설정 
				ko28_i10=ko28_i/10;//십의 자리 
				ko28_i0=ko28_i%10;//일의 자리 
				if(ko28_i0==0) { //if 구문 일의자리가 0일경우 
					System.out.printf("십의 자리:%s십\n",ko28_units[ko28_i10]); //입력값 출력 
				}else {//if 구문 일의 자리가 아닐 경우
					
					System.out.printf("십의 자리:%s십%s\n",ko28_units[ko28_i10],ko28_units[ko28_i0]);//입력값 출력
					
				}
								
	}
			else System.out.printf("==>%d\n",ko28_i);//100이상의 숫자는 변환하지 않고 그대로 출력
			}
		}
 	}

