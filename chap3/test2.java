package chap3;

public class test2 { //클래스 선언 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ko28_sum; //c는 맨앞에서만 선언해야 하지만, c++. java는 필요할 때 선언해도 됨, 하지만 지저분 
		
		ko28_sum=0; //누적, 루프는 꼭 초기화 
		
		
		//1부터 100까지 더해보자. 아직 안배운 for문이 나오지만 c에서 했지?
		for(int ko28_i=1; ko28_i<101;ko28_i++) //for구문 1에서 100까지 증가
		{	
			ko28_sum=ko28_sum+ko28_i; //ko28_sum 규칙 설정 
		}
		System.out.printf("#2: %d\n", ko28_sum);//sum 출력 
		//평균을 처리한다면 여기서 다더한다음 해야지
		System.out.printf("2-2:%d\n", ko28_sum/100);//sum/100 출력 
		//c에서 배열을 배웠으니 응용해 보자 
		int [] ko28_v= {1,2,3,4,5,}; // ko28_v  초기값 설정 
		int ko28_vSum; //변수 설정 
		
		ko28_vSum=0; //초기화 설정 
 		
		for(int ko28_i=0; ko28_i<5; ko28_i++) { //for 구문 0부터 4까지 증가 
			ko28_vSum=ko28_vSum+ko28_v[ko28_i]; //규칙 설정 
		}
		
		System.out.printf("#2-3 :%d\n", ko28_vSum); // vSum 출력 
		}
	}


