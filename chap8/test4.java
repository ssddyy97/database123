package chap8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class test4 {	 //클래스 선언 
		public static void main(String [] args) throws IOException{
			File ko28_f= new File("C:\\Users\\USER\\Desktop\\myjava\\무료와이파이정보.CSV"); //파일 불러 오기 
			BufferedReader ko28_br=new BufferedReader(new FileReader(ko28_f));  //BufferedReader와 FileReader를 사용해 파일을 한 줄씩 읽을 준비
			
			String ko28_readtxt; //문자열 생성 
			
			if((ko28_readtxt=ko28_br.readLine())==null) { //파일에서 첫번째 줄을 읽음 
				System.out.printf("빈 파일입니다\n"); // 메세지 출력 
				return; //반환 
			}
			String[]ko28_field_name=ko28_readtxt.split(","); //헤더를 ,로 구분하여 배열로 저장 
			
			
			double ko28_lat=37.3860521; //초기값 설정 
			double ko28_lng=127.1214038; //초기값 설정 
			 
			int LineCnt=0; //초기값 설정 
			while((ko28_readtxt=ko28_br.readLine())!=null) { //파일에서 한줄씩 읽어 처리 
				
				
				String[] ko28_field =ko28_readtxt.split(",");//CSV 파일의 한 줄을 , 기준으로 나누어 배열에 저장
				System.out.printf("**[%d번째 항목]********************\n",LineCnt); //항목 출력 
				System.out.printf("%s : %s\n",ko28_field_name[10],ko28_field[10]); //소재지 지번 주소 출력 
				System.out.printf("%s : %s\n",ko28_field_name[13],ko28_field[13]); //위도값 
				System.out.printf("%s : %s\n",ko28_field_name[14],ko28_field[14]); //경도 값 

				double ko28_dist=Math.sqrt(Math.pow(Double.parseDouble(ko28_field[13])-ko28_lat,2)
						+Math.pow(Double.parseDouble(ko28_field[14])-ko28_lng,2)); //유클리드 거리 계산법 
				double ko28_dist1= Math.abs(ko28_dist); //거리를 절대값으로 표현 
		       

				System.out.printf("현재지점과 거리 : %f\n",ko28_dist1); //거리 출력 
				System.out.printf("**********************************************\n"); //점선 출력 
				
				LineCnt++;
			}
			ko28_br.close();//BufferedReader를 닫아 리소스 누수를 방지

}
}
