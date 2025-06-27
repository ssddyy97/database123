package chap6;

public class test2 {//클래스 선언 
	
	static int ko28_iStatic; //정적 변수 선언 메소드에서 공유됨 
	
	public static void  ko28_add(int  ko28_i) {
		 ko28_iStatic++; // 클래스 변수 증가 
		 ko28_i++;  //지역 변수 증가 
		System.out.printf("add메소드에서->iStatic=[%d]\n", ko28_iStatic); //입력값 출력 ko28_iStatic++ ->정적 변수 증가 
		//(모든 메소드에서 영향 받음)
		System.out.printf("add메소드에서->i=[%d]\n", ko28_i); //입력값 출력 ko28_i++→ 지역 변수로, main에서는 영향 없음
		
		
	}

	public static int  ko28_add2(int  ko28_i){
		 ko28_iStatic++; //클래스 변수 증가 
		 ko28_i++;// 지역 변수 증가 
		System.out.printf("add메소드에서->iStatic=[%d]\n", ko28_iStatic); //입력값 출력 ko28_iStatic++ → 정적 변수이므로 계속 증가
		System.out.printf("add메소드에서->i=[%d]\n", ko28_i); //입력값 출력 ko28_i++ → 증가된 값을 반환
		return  ko28_i; //변경된 i값을 반환 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int  ko28_iMain; //지역 변수 선언 
		
		 ko28_iMain=1; //main에서만 유효한 지역변수  
		 ko28_iStatic=1; //모든 메소드에서 공유 
		
		System.out.printf("**************************************\n"); //입력값 출력 점선 출력 
		System.out.printf("메소드호출전 메인에서->iStatic=[%d]\n", ko28_iStatic); //iStatic 입력값 출력 
		System.out.printf("메소드호출전 메인에서->iMain=[%d]\n", ko28_iMain); //imain 입력값 출력 
		System.out.printf("**************************************\n"); //점선 입력값 출력 
		
		 ko28_add( ko28_iMain); //변수 설정 
		
		System.out.printf("**************************************\n"); //점선 출력 
		System.out.printf("메소드 호출후 메인에서->iStatic=[%d]\n", ko28_iStatic); // 입력값 출력 istatic은 증가한다
		System.out.printf("메소드 호출후 메인에서->iMain=[%d]\n", ko28_iMain);//입력값 출력 imain에는 변화가 없다
		System.out.printf("**************************************\n"); //점선 출력 
		
		
		 ko28_iMain= ko28_add2( ko28_iMain); //변수 설정 ko28_iStatic++ → 3이 됨
		// ko28_i++ → 증가 후 반환되므로 main에서 변경됨
		
		System.out.printf("**************************************\n"); //점선 출력 
		System.out.printf("메소드 호출후 메인에서->iStatic=[%d]\n", ko28_iStatic); //공유된 변수 입력값 출력 
		System.out.printf("메소드 호출후 메인에서->iMain=[%d]\n", ko28_iMain);//반환 값을 저장했으므로 변경
		System.out.printf("**************************************\n"); //점선 출력 
		

	}

}
