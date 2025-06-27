package chap2;

public class test12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ko28_i=10; //ko28_i 변수를 10으로 초기화
		String ko28_a="*".repeat(ko28_i); //문자열 생성 후 repeat을 사용하여 별 10개로 초기화
		while(true) { //무한 루프
			if (!ko28_a.isEmpty()) { //
                ko28_a = ko28_a.substring(0, ko28_a.length() - 1); // 문자열에서 마지막 문자 제거
            }
			ko28_i--;//단축해서 썻다 이렇게 언어를 배운다
			System.out.println("하나씩 더해보자 "+ko28_i+":"+ko28_a);
			if(ko28_i<=0) break;
		}
	}
}