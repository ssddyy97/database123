package chap3;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class test12 { //클래스 선언 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar ko28_calt= Calendar.getInstance(); //Calendar.getInstance()를 사용하면 현재 시스템의 날짜와 시간
		SimpleDateFormat ko28_sdt=new SimpleDateFormat("YYYY/MM/dd HH:mm;ss"); //SimpleDateFormat을 사용하여 날짜 및 시간의 출력 형식을 지정
		 
		System.out.printf("최종실행시간: %s\n", ko28_sdt.format(ko28_calt.getTime())); // 입력값 출력 
	}

}
