package chap4;

public class test5 {//클래스 설정 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int ko28_i=1; ko28_i<13; ko28_i++) { //for 구문  1부터 12까지
			System.out.printf(" %d월 =>",ko28_i); //입력값 출력 
			String ko28_aa=","; //문자열 설정 
			
			for(int ko28_j=1; ko28_j<32; ko28_j++) {//for 구문 1부터 31까지 
				
				System.out.printf("%d",ko28_j); //입력값 출력 
				
				if (!(ko28_i == 1 && ko28_j == 31) &&
	                    !(ko28_i == 2 && ko28_j == 28) &&
	                    !(ko28_i == 3 && ko28_j == 31) &&
	                    !(ko28_i == 4 && ko28_j == 30) &&
	                    !(ko28_i == 5 && ko28_j == 31) &&
	                    !(ko28_i == 6 && ko28_j == 30) &&
	                    !(ko28_i == 7 && ko28_j == 31) &&
	                    !(ko28_i == 8 && ko28_j == 31) &&
	                    !(ko28_i == 9 && ko28_j == 30) &&
	                    !(ko28_i == 10 && ko28_j == 31) &&
	                    !(ko28_i == 11 && ko28_j == 30) &&
	                    !(ko28_i == 12 && ko28_j == 31)) {
	                    System.out.printf("%s", ko28_aa);
				}
				
				
				if(ko28_i==1  && ko28_j==31)break;
					 //if 구문 1월달이 31달일 경우 중지 
				if(ko28_i==2  && ko28_j==28) break;//if 구문 2월이 30일 경우 중지 
				if(ko28_i==3  && ko28_j==31) break;//if 구문 3월이 31일 경우 중지 
				if(ko28_i==4  && ko28_j==30) break;//if 구문 4월이 31일 경우 중지 
				if(ko28_i==5  && ko28_j==31) break;//if 구문 5월이 30일 경우 중지 
				if(ko28_i==6  && ko28_j==30) break;//if 구문 6월이 31일 경우 중지 
				if(ko28_i==7  && ko28_j==31) break;//if 구문 7월이 31일 경우 중지 
				if(ko28_i==8  && ko28_j==31) break;//if 구문 8월이 31일 경우 중지 
				if(ko28_i==9  && ko28_j==30) break;//if 구문 9월이 30일 경우 중지 
				if(ko28_i==10  && ko28_j==31) break;//if 구문 10월이 31일 경우 중지 
				if(ko28_i==11  && ko28_j==30) break;//if 구문 11월이 30일 경우 중지 
				if(ko28_i==12  && ko28_j==31) break;//if 구문 12월이 31일 경우 중지 
			}
			System.out.printf("\n"); //입력값 출력 
		}
	}

}
