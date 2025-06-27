package chap2;

public class test17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int ko28_i=10;  ko28_i>0; ko28_i--) {// for 문 10부터 시작하여서 점점 줄어듬 
			String  ko28_a="**************"; //14개의 별로 초기화
			ko28_a= ko28_a.substring(0,ko28_i);// i개만 남기고 문자열을 자름
			System.out.println(ko28_a); //출력  10부터 싲가하여 1씩 감소
		}
		//별을 줄여나가는 방식
		for(int ko28_i=10; ko28_i>0;ko28_i--) { //10부터 1씩 감소 (i--)
			String ko28_a="";//문자열 설정 
			for(int ko28_j=0; ko28_j<ko28_i; ko28_j++) {// j=0부터 j<i까지 반복하며 a 문자열에 * 추가
				ko28_a=ko28_a+"*"; //별생성 추가하면서
			}
			System.out.println(ko28_a); //출력
			}//별을 채워나가는 방식 
		}
	}


