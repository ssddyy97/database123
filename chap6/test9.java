package chap6;

public class test9 { //클래스 선언

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		test8 ko28_cc=new test8(); //test 8의 클래스의 인스턴스 메소드 하는 역할
		int []ko28_aa= {100,100,100,100,100};
		System.out.printf("3월 성적표\n"); //입력값 출력 
		System.out.printf("=======================================\n"); //점선 출력 
		System.out.printf("이름 국어 영어 수학 총점 평균\n "); //여러 값 출력 
		System.out.printf("======================================\n"); //첨선 출력
		System.out.printf("폴리융 %3s %3s %3s %3s %3s\n",ko28_aa[0],ko28_aa[1],ko28_aa[2],ko28_cc.ko28_sum(ko28_aa[0],ko28_aa[1],
				ko28_aa[2]),ko28_cc.ko28_mean(ko28_aa[0],ko28_aa[1],ko28_aa[2])); //수학, 국어, 영어 성적만 포함 평균과 합계
		System.out.printf("\n");//칸 띄어 쓰기 
		
		System.out.printf("4월 성적표\n");//입력값 출력 
		System.out.printf("=======================================\n");//점선 출력
		System.out.printf("이름 국어 영어 수학 과학 총점 평균\n ");//여러값 출력 
		System.out.printf("=======================================\n");//점선 출력
		System.out.printf("폴리융%5s%5s%5s%5s%5s%5s\n",ko28_aa[0],ko28_aa[1],ko28_aa[2],ko28_aa[3],ko28_cc.ko28_sum1(ko28_aa[0],ko28_aa[1],
				ko28_aa[2],ko28_aa[3]),ko28_cc.ko28_mean1(ko28_aa[0],ko28_aa[1],ko28_aa[2],ko28_aa[3])); //국어, 수학, 영어, 평균, 합계
		System.out.printf("\n"); //칸 뜨어쓰기 
		
		System.out.printf("5월 성적표\n");//입력값 출력 
		System.out.printf("========================================\n");//점선 출력 
		System.out.printf("이름   국어 영어 수학 과학 사회 총점 평균\n "); //여러값 출력 
		System.out.printf("========================================\n");//점선 출력 
		System.out.printf("폴리융%5s%5s%5s%5s%5s%5s%5s\n",
				ko28_aa[0],ko28_aa[1],ko28_aa[2],ko28_aa[3],ko28_aa[4],ko28_cc.ko28_sum2(ko28_aa[0],ko28_aa[1],
						ko28_aa[2],ko28_aa[3],ko28_aa[4]),ko28_cc.ko28_mean2(ko28_aa[0],ko28_aa[1],ko28_aa[2],ko28_aa[3],ko28_aa[4]));
		//국어 영어 수학 과학 사회, 평균, 합계
		System.out.printf("\n");//칸 띄어쓰기
		
	
		
	}
}
	

