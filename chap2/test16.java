package chap2;

public class test16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ko28_szText1="안녕aaa녕안"; //szText1.length() → "안녕aaa녕안"의 길이를 구함
		String ko28_szText2="abcdefabc"; //szText2.length() → "abcdefabc"의 길이를 구함
		
		System.out.printf("스트링길이 1[%d] 2[%d]\n", ko28_szText1.length(),ko28_szText2.length());//출력
		
		byte[] ko28_szByte1=ko28_szText1.getBytes();//szText1.getBytes() → "안녕aaa녕안"을 바이트 배열로 변환
		byte[] ko28_szByte2=ko28_szText2.getBytes();//szText2.getBytes() → "abcdefabc"를 바이트 배열로 변환
		
		System.out.printf("바이트 길이 1[%d] 2[%d]\n", ko28_szByte1.length, ko28_szByte2.length);//출력
		
		//한글 문자(UTF-8)는 1글자당 3바이트, 영어 문자(UTF-8)는 1글자당 1바이트로 저장
		
		int ko28_han1=ko28_szByte1.length-ko28_szText1.length();//"안녕aaa녕안": 13(바이트 길이) - 7(문자 길이) = 6
		int ko28_han2=ko28_szByte2.length-ko28_szText2.length();//"abcdefabc": 9(바이트 길이) - 9(문자 길이) = 0
		System.out.printf("저장공간차이 1[%d] 2[%d]\n", ko28_han1,ko28_han2); //출력 
		System.out.printf("포함된 한글갯수 1[%d] 2[%d]\n", ko28_han1/2,ko28_han2/2); //출력
	}

}
