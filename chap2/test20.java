package chap2;

public class test20 { //클래스 선언

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ko28_name="Ja"+"va"; // "Ja"+"va" = java
		String ko28_str= ko28_name +8.0; // "Java" + 8.0 → "Java8.0"  
		//string str ""정확히 지키기
		
		System.out.println(ko28_name); //출력 이름+ java
		System.out.println(ko28_str); //출력문자 +숫자
		System.out.println(7+" "); //출력 숫자 7 + 공백 문자열 → "7 "
		System.out.println(" "+7); //출력 공백 문자열 + 숫자 7 → " 7"
		System.out.println(7+""); //출력 숫자 7 + 빈 문자열 → "7"
		System.out.println(""+7); //출력 빈 문자열 + 숫자 7 → "7"
		System.out.println(""+"");//출력 빈 문자열 + 빈 문자열 → ""
		System.out.println(7+7+"");//출력 (7 + 7) + "" → "14"
		System.out.println(""+7+7); //출력 "" + "7" + "7" → "77"

	}
}
