package chap4;


public class test19 { //클래스 선언 

	public static String bblank(String ko28_str, int ko28_print_len) { //문자열 ko28_str을 입력받아 최대 ko28_print_len 길이만큼 출력
		String ko28_ret=""; //변수 선언 
		int ko28_prtCnt=0; //변수 선언 
		for(int ko28_i=0; ko28_i<ko28_str.length();ko28_i++) {//for문 문자열을 한 글자씩 가져옴 
			String ko28_a=ko28_str.substring(ko28_i,ko28_i+1);//규칙 
			if(ko28_a.getBytes().length==1) {//if 문 getBytes().length를 이용해 해당 문자의 바이트 크기 확인.
				if((ko28_prtCnt+1)>ko28_print_len) break; //if 문 영문 → 남은 공간이 1 이상이면 출력.
				//한글(2바이트) → 남은 공간이 2 이상이면 출력.
				ko28_prtCnt=ko28_prtCnt+1;//현재 문자를 ko28_ret에 추가.
				ko28_ret=ko28_ret+ko28_a;//출력된 바이트 수(ko28_prtCnt) 갱신.
				System.out.printf("==> %s{%d}\n",ko28_a,ko28_prtCnt);//입력값 출력 
				
			}else { //그외 결과 값 
				if((ko28_prtCnt+2)>ko28_print_len)break; //한글(2바이트) → 남은 공간이 2 이상이면 출력.
				ko28_prtCnt=ko28_prtCnt+2; //2만큼 증가 
				ko28_ret=ko28_ret+ko28_a;
				System.out.printf("**>%s{%d}\n",ko28_a,ko28_prtCnt);//입력값 출력 
			}
		}
		
		int ko28_cntBlank=ko28_print_len-ko28_prtCnt; //변수 설정 
		System.out.printf("필요빈칸->[%d]{%d}{%d}\n", ko28_cntBlank,ko28_prtCnt,ko28_print_len);//입력값 출력 공백( ) 개수 = 목표 길이 - 현재 출력된 길이
		for(int ko28_i=0; ko28_i<ko28_cntBlank;ko28_i++) ko28_ret=ko28_ret+" "; //입력값 출력 공백( )을 ko28_ret에 추가하여 길이 조정
		
		return ko28_ret; //결과 반환 
		
	}
}
