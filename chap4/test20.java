package chap4;

public class test20 {//클래스 선언 

	public static String bblank(String ko28_str, int ko28_printLength) { //메서드, 변수 설정 
		
		int ko28_proc_Printlen=0;//프린트기준 출력기준 길이
		int ko28_ret_Strlen =0;//글자 기준 실제 문자열길이
		int ko28_asc;//변수 설정  문자열 ko28_str의 총 길이
		
		int ko28_length=ko28_str.length();//초기값 길이 설정 
		for(int ko28_i=1; ko28_i<=ko28_length; ko28_i++) {//for 문 1~길이까지 반복
			ko28_asc=(int) ko28_str.charAt(ko28_i-1); // 문자열의 i번째 문자 ASCII 값 가져오기 글자열 맨앞을 살펴봄
			if (ko28_asc>127) { //이글자가 한글이라면 
				if (ko28_printLength < ko28_proc_Printlen+2)//if 문 한글은 2칸 증가
					break;//만일 이글자를 인쇄할 때 인쇄크기를 넘어가면 그만 
				ko28_proc_Printlen=ko28_proc_Printlen +2; //프린트는 2칸 증가
				ko28_ret_Strlen=ko28_ret_Strlen+1;//글자는 하나 증가 
			} else { //영어 또는 숫자
				if(ko28_printLength < ko28_proc_Printlen+1) //if문 영어, 숫자 등은 1바이트 차지하므로 +1 증가
					break;//만일 이글자를 인쇄할때 인쇄크기를 넘어가면 그만 
				ko28_proc_Printlen=ko28_proc_Printlen+1; //프린트는 1칸 증가
				ko28_ret_Strlen=ko28_ret_Strlen+1; //글자는 하나 증가
			}
	}
	String ko28_retStr=ko28_str.substring(0, ko28_ret_Strlen);//문자열 설정 
	for(int ko28_i=0; ko28_i<(ko28_printLength=ko28_proc_Printlen);ko28_i++) { //for문 남은 길이만큼 공백추가하여 총 ko28_printLength에 맞춤
		ko28_retStr=ko28_retStr+" ";//프린트 갯수보다 모자라는 크기만큼 뒤에 블랭크 
	}
	return ko28_retStr; //결과값 반환 
		}

	}

