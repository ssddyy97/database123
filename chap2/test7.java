package chap2;

public class test7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ko28_sum=0; //총합 변수 선언 
		for(int ko28_i=1; ko28_i<101; ko28_i++) { // 반복문 설정 초기값 , 종료여부, 증감값+1 i는 1부터 100까지 반복 
			ko28_sum=ko28_sum+ko28_i; // ko28_i 값을 누적해서 더함
			System.out.printf("과정 -->1~%d까지 합 =%d\n",ko28_i,ko28_sum); //출력 
			//증가치 지정, int i의 선언은 for블럭에서만 유효
			//그래서 위에 i의 선언이 무효이므로 다시 i를 선언
			//하나씩 전체를 더한 값을 표시 
		}
		
		System.out.printf("1~100합=%d\n", ko28_sum);//반복문이 끝난 후 최종 합계를 출력.
		for(int ko28_i=0; ko28_i<50; ko28_i+=4) {  //증가치를 이런식으로 변환 가능 반복문 설정 초기값 , 종료여부, 증감값+4 
			System.out.printf("i의 규칙은 %d\n",ko28_i); //출력
		}
		int ko28_i=0; //변수 설정 
		while(true) { //무한루프 설정 
			System.out.printf("==>i의 규칙은%d\n", ko28_i); //출력
			ko28_i+=3; //ko28_i 값을 3씩 증가
			if (ko28_i>50) break; // 50을 초과하면 반복 종료
			
		}
		//어떻게 이렇게 나오지....
		//헤더 타이틀, 내용리스트, 테일찍기 ->리포트 형태의 기본 
		System.out.printf("**************\n"); //**선 출력 
		for(ko28_i=2;ko28_i<10;ko28_i++) {  // 반복문 설정 초기값, 종료여부 , 증감값  i는 2부터 시작 i는 10보다 작다 
			System.out.printf("구구단 %d 단\n",ko28_i); //구구단 출력
			for(int ko28_j=1;ko28_j<10;ko28_j++) { //반복문 설정 초기값, 종료여부, 증감 값+1 i는 9까지 구구단 진행
				System.out.printf("%d*%d=%d\n",ko28_i,ko28_j,ko28_i*ko28_j); // 출력 
			}
			System.out.printf("\n\n***************\n"); //점선 출력

			}
		}
	}

