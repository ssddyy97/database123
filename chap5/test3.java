package chap5;

public class test3 {//클래스 선언 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] ko28_iEnd= {31,29,31,30,31,30,31,31,30,31,30,31}; //변수 설정 각달의 일 수정리
		int ko28_iweek=5; //5번째 요일 설정 5칸을 공백으로 으로 채우고 시작 
		for(int ko28_iMon=0; ko28_iMon<12; ko28_iMon++) {//for문 ko28_iMon은 0부터 11까지 반복 

			System.out.printf("\n\n           %d월\n",ko28_iMon+1);//월은 0부터 시작하므로 +1 추가 입력값 출력 
			System.out.printf("===========================\n");//칸을 나누어주는 별선의 입력값 출력 
			System.out.printf("일  월  화  수  목  금  토\n");//입력값 출력  요일 헤더
			
			for(int ko28_space=0; ko28_space <ko28_iweek; ko28_space++) { //for 문
				System.out.printf("    ");// ko28_iweek 값만큼 공백을 출력.
				//이전 달의 마지막 요일을 고려하여, 다음 달이 시작되는 위치 조정
			}
			
			
			for(int ko28_i=1;ko28_i<=ko28_iEnd[ko28_iMon];ko28_i++) {//for문 각 월의 1일부터 마지막 날짜까지 반복
				System.out.printf("%2d  ",ko28_i); //월의 일의 입력값 출력 
				ko28_iweek++; //요일 증가 
				
				if(ko28_iweek==7) { //if문 토요일 도달 시 줄 바꿈
					System.out.println(); //입력값 출력 
					ko28_iweek=0; //규칙값 설정 
				}
			}
			
			System.out.println();//입력값 출력 				
		}
					
	}
}


