package chap4;

public class test10 { //클래스 설정 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ko28_iNumVal=1943251230; //초기값 설정 
		
		String ko28_sNumVal=String.valueOf(ko28_iNumVal);//int 값->문자열 변환 
		
		String ko28_sNumVoice=""; //문자열 설정 
		
		System.out.printf("==> %s [%d자리]\n",ko28_sNumVal, ko28_sNumVal.length());//자릿수 출력 
		
		int ko28_i,ko28_j;//초기값 설정 
		
		String []ko28_units= {"영", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구"};//문자열 출력 
		String []ko28_unitX= {"","십","백","천","만","십","백","천","억","십"};//문자열 출력 
		
		ko28_i=0;//현재 처리중인 숫자의 위치 
		ko28_j=ko28_sNumVal.length()-1;//현재 숫자의 자릿수
		
		while(true) { //무한 루프 
			if (ko28_i>=ko28_sNumVal.length()) break;//for문 한자리씩 숫자 변환 


			System.out.printf("%s[%s]", //입력값 출력 
					ko28_sNumVal.substring(ko28_i,ko28_i+1),//현재 숫자의 문자열
					ko28_units[Integer.parseInt(ko28_sNumVal.substring(ko28_i,ko28_i+1))]);//정수로 변환 후 ko28_units에서 한글 숫자로 변환
			if(ko28_sNumVal.substring(ko28_i,ko28_i+1).equals("0")) { //if 구문 
				
				if(ko28_unitX[ko28_j].equals("만")||ko28_unitX[ko28_j].equals("억")){//if 구문  만이랑 억일때 
					//해당자리가 0일땐 단위값을 안붙이는데 억,만 자리는 붙인다.
					//이백 사만 이십.. 이백 만원
					//억,만 자리가 아니면 아무짓도 않암 
					ko28_sNumVoice=ko28_sNumVoice+""+ko28_unitX[ko28_j];
					//해당자리가 0이면 단위만 붙여줌 
				}else { //아무것도 안함 
					
					
					
				}
						
			}else { //숫자가 0이 아닐때 실행 
				ko28_sNumVoice=ko28_sNumVoice
						+ko28_units[Integer.parseInt(ko28_sNumVal.substring(ko28_i,ko28_i+1))]// 현재 자리의 숫자를 문자열로 가져옴
								//문자열을 정수로 변환 
						+ko28_unitX[ko28_j];//자릿수 추가 
			}
			ko28_i++; ko28_j--; //증감 
		
			}
		ko28_sNumVoice = ko28_sNumVoice.replace("억만", "억");
		
				

			
			System.out.printf("\n %s[%s]\n",ko28_sNumVal,ko28_sNumVoice);//입력값 출력 
			
		 
			
		
		
				
	}
}

