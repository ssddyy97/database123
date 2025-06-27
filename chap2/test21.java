package chap2;

public class test21 { //클래스 선언

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println('\''); //출력 '''처럼 할수 없다 단독으로 사용하면 오류가 나옴 \' 작은 따옴표 
		System.out.println("abc\t123\b456"); //출력  \t 탭의 간격이 생긴다 \b 백스페이스 에 의해 3이 지워진다
		System.out.println('\n'); //출력 개행 (new line) 
		System.out.println("\"Hello\""); //출력 큰따옴표를 출력하면  \" 처리해야됨 
		System.out.println("c:\\"); //출력 백슬레이스 출력하려면 \\사용해야된다

	}

}
