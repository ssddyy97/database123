package chap8;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;


public class test1 { //클래스 선언 
	public static void main(String [] args) {
		try {
			File ko28_f=new File("C:\\Users\\USER\\Desktop\\myjava\\mytest.txt"); //파일 객체 생성 
			FileWriter ko28_fw=new FileWriter(ko28_f); //file writer를 사용하여 해당 파일에 데이터 작성 준비 
			
			ko28_fw.write("안녕 파일\n"); //문자열을 파일에 쓴다 
			ko28_fw.write("hello 헬로\n"); //문자열을 파일에 쓴다 
			
			ko28_fw.close(); //filewriter를 받아 데이터가 저장 되도록 함 
			
			FileReader ko28_fr =new FileReader(ko28_f); //filereader 사용하여  파일을 읽을 준비를 함 
			
			
			int ko28_n=-1; // 읽은 문자의 개수를 저장 하는 초기값 설정 
			char [] ko28_ch; //읽은 문자를 저장할 char 배열 
			 
			while(true) { //반복문 
				ko28_ch = new char[100]; // 한 번에 최대 100글자를 읽을 수 있는 배열 생성
				ko28_n=ko28_fr.read(ko28_ch); 
			
				
				if(ko28_n==-1)break; //더이상 읽을 데이터가 없으면 좋료
				
				for(int ko28_i=0; ko28_i<ko28_n;ko28_i++) { //읽은 문자만큼 반복 
					System.out.printf("%c", ko28_ch[ko28_i]); //한글자씩 출력 
					
				}
			}
			
			ko28_fr.close(); //파일을 닫음 
			System.out.printf("\n FILE READ END");	 //메세지 출력 	
		}catch(Exception ko28_e) { //에러 발생시 
			System.out.printf("나 에러 [%s]\n",ko28_e); //에러 출력 
		}
		
	}
	

}
