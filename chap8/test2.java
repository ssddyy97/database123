package chap8;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.io.BufferedWriter;
public class test2{ //클래스 선언 
	public static void FileWrite() throws IOException {
	
			File ko28_f=new File("C:\\Users\\USER\\Desktop\\myjava\\mytest.txt"); // 파일 객체 생성
			BufferedWriter ko28_bw=new BufferedWriter(new FileWriter(ko28_f));// BufferedWriter 사용하여 파일 쓰기 모드로 엶	
			ko28_bw.write("안녕 파일\n"); // 첫 번째 줄에 문자열 저장
			ko28_bw.newLine();// 개행 (줄 바꿈)
			ko28_bw.write("hello 헬로\n");// 두 번째 줄에 문자열 저장
			ko28_bw.newLine();// 개행 (줄 바꿈)
			ko28_bw.close();// BufferedWriter 닫기 (파일 저장됨)
			
	}
	public static void FileRead() throws IOException {	
			
		File ko28_f= new File("C:\\Users\\USER\\Desktop\\myjava\\mytest.txt"); //파일 객체 생성
		BufferedReader ko28_br=new BufferedReader(new FileReader(ko28_f));// BufferedReader 사용하여 파일을 읽기 모드로 엶
		
		String ko28_readtxt;
		
		while((ko28_readtxt=ko28_br.readLine())!=null) {// 파일을 한 줄씩 읽음
			System.out.printf("%s\n",ko28_readtxt); // 읽은 데이터를 출력
					
				}
		ko28_br.close();// BufferedReader 닫기 (파일 읽기 완료)
			}
			public static void main(String [] args) throws IOException{
				FileWrite();// 파일 생성 및 데이터 저장
				FileRead();// 저장된 데이터 읽기
		}
		
	}
	


