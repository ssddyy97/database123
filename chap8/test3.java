package chap8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class test3 { //클래스 선언 
	
	public static void main(String [] args) throws IOException{
		File ko28_f= new File("C:\\Users\\USER\\Desktop\\myjava\\무료와이파이정보.CSV"); //파일 객체 생성 
		BufferedReader ko28_br=new BufferedReader(new FileReader(ko28_f));//파일읽기 모드로 엶
		
		String ko28_readtxt; //문자열 생성 
		
		
		if((ko28_readtxt=ko28_br.readLine())==null) { //readtxt를 읽고 null이면 비어있는 것으로 간주 
			System.out.printf("빈 파일입니다\n"); //빈파일 메세지를 출력  
			return; //반환 
		}
		String[] ko28_field_name=ko28_readtxt.split(","); //천번째 출을 읽어 필드배열로 저장 
		
		int ko28_LineCnt=0; //초기값 설정 
		while((ko28_readtxt=ko28_br.readLine())!=null){//반복문을 사용하여 파일을 끝까지 읽음 
			
			String[]ko28_field=ko28_readtxt.split(","); //각 줄을 split을 이용해 배열로 변환하여 필드 값을 저장
			System.out.printf("**[%d번째 항목]********************\n",ko28_LineCnt); //메세지 출력 
			for (int ko28_j=0; ko28_j<ko28_field_name.length; ko28_j++) { //for문 필드 이름 길이까지 증가  
				System.out.printf(" %s : %s\n", ko28_field_name[ko28_j],ko28_field[ko28_j]); //출력 
				
			}
			System.out.printf("**********************************************\n"); //점선 출력
			if(ko28_LineCnt==100)break; //100개까지 출력 
			ko28_LineCnt++;//계속 증가
			}
		ko28_br.close(); //파일을 다 읽은 후 BufferedReader를 닫아 메모리 누수 방지
		}
	}


