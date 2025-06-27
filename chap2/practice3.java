package chap2;

public class practice3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 for(int ko28_i=10; ko28_i>0; ko28_i--) { //ko28_i = 10에서 시작 ko28_i > 0 동안 반복. (ko28_i--로 1씩 감소
	            String ko28_a = ""; //문자열 추가 
	            for(int ko28_j=0; ko28_j<ko28_i; ko28_j++) {//for 루프에서 ko28_j를 0부터 ko28_i 미만까지 증가시키면서 ko28_a에 *을 추가
	                ko28_a = ko28_a + "*";
	            }
	            System.out.println(ko28_a);// 출력 별(*)의 개수가 10개에서 1개까지 줄어드는 패턴이 출력
	        }

	        int ko28_i = 0;  // 다시 초기화
	        String ko28_a = "@"; //문자열 @ 추가
	        while(true) { //무한 루프 
	            if(ko28_i % 3 == 0) //ko28_i % 3 == 0 → # 추가
	                ko28_a = ko28_a + "#"; 
	            else if (ko28_i % 3 == 1) //ko28_i % 3 == 1 → @ 추가
	                ko28_a = ko28_a + "@";
	            else 
	                ko28_a = ko28_a + "*"; //ko28_i % 3 == 2 → * 추가

	            ko28_i++; //하나씩 증가
	            System.out.println("응용했당" + ko28_i + ":" + ko28_a);// 숫자와 함께 문자열과 같이 출력 
	            if (ko28_i >= 50) break; //ko28_i가 50이 되면 break;로 루프 종료
	        }
	    }
	


	}


