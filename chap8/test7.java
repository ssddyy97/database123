package chap8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class test7 { //클래스 선언

	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
		File ko28_f= new File("C:\\Users\\USER\\Desktop\\과제모음\\day_data\\THTSKS010H00.dat"); //파일 객체 설정 
		BufferedReader ko28_br=new BufferedReader(new FileReader(ko28_f)); //BufferedReader는 파일을 효율적으로 읽기 위해 사용
		
		String ko28_readtxt; //문자열 설정 
		int ko28_LineCnt=0; //읽은 줄 수를 세는 변수 초기값 설정 
		int ko28_n=-1; //읽은 문자 개수를 저장하는 변수 초기값 설정 
		StringBuffer ko28_s= new StringBuffer(); //StringBuffer s: 문자열을 저장하는 버퍼 
		while(true) { //무한 루프 
			
			char[] ko28_ch=new char[1000];// 한 번에 최대 1000개의 문자 읽기
			ko28_n= ko28_br.read(ko28_ch);// 파일에서 문자 읽기
			
			if(ko28_n==-1)break;// 파일 끝이면 종료
			
			
			for(char ko28_c:ko28_ch) { //for 구문 
				if(ko28_c=='\n') { // 줄바꿈 문자를 만나면
					System.out.printf("[%s]***\n", ko28_s.toString());// 저장된 문자열 출력
					ko28_s.delete(0, ko28_s.length());// StringBuffer 초기화
				}else { //그외
					ko28_s.append(ko28_c);// 줄바꿈이 아니면 버퍼에 추가
				}
			}
			
			ko28_LineCnt++;
            if (ko28_LineCnt >= 50) break;  // 50줄까지만 출력 후 종료

		}
		
		
		System.out.printf("[%s]***\n",ko28_s.toString());//출력 
		ko28_br.close();// 리소스 해제 
		
	


	}

}
