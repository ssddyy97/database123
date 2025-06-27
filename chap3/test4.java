package chap3;

public class test4 { //클래스선언 
	
	//원하는 자릿수 반올림, 버림 처리 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ko28_ii; //변수값 설정 
		ko28_ii=12345; // 초기값 설정   12345원은 10원이하 버려서 처러하기
		int ko28_j=(ko28_ii/10)*10; //초기값 설정 ko28_ii를 10으로 나눈 값에 10 곱하기 
		
		System.out.printf("4-1:%d\n", ko28_j); //입력값 출력 
		
		ko28_ii=12345;//초기값설정 
		ko28_j=((ko28_ii+5)/10)*10; //ko28_ii+5를 10으로 나눈 후 10 곱셉 
		
		System.out.printf("4-1:%d\n", ko28_j); //입력 값 출력
		
		ko28_ii=12344;//초기값 설정 12344원은 10원이하 반올림 처리하기 
		ko28_j=((ko28_ii+5)/10)*10; //규칙 선언 ii+5가 10으로 나눈 값에 10곱셉 이식이 맞는지 검증 해보자 
		
		System.out.printf("#4-2:%d\n", ko28_j); //입력값 출력 
		//반올림 식만들기 
		
		int ko28_k; //변수 설정 
		ko28_k=198987; //초기값 설정 
		int ko28_kk=(ko28_k/100)*100; //100자리 숫자 버림 공식 
		
		System.out.printf("4-5:%d\n", ko28_kk); // 입력값 출력 
		
		int ko28_l; //변수 설정 
		ko28_l=198674; //초기값 설정 
		int ko28_ll=((ko28_l+100)/100)*100;//100자리 숫자 올림 공식 
		
		System.out.printf("4-6:%d\n", ko28_ll); //입력값 출력 
		
		
		int ko28_n; //변수 설정 
		ko28_n=123558; // 초기값 설정  
		int ko28_nn=(ko28_n/1000)*1000; //1000의 자리 숫자 버림 공식 
		
		System.out.printf("4-7:%d\n", ko28_nn); //입력값 출력 
		
		
		int ko28_m; //변수 설정 
		ko28_m=12318246; //초기값 설정 
		
		int ko28_mm=((ko28_m+500)/1000)*1000;// 천의 자리 숫자 반올림 공식 
		
		System.out.printf("4-8:%d\n", ko28_mm); // 입력값 출력 
	}

}
