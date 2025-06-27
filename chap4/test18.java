package chap4;

public class test18 { //클래스 설정 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] ko28_a={"한우 A+++ 등심"}; //문자열 설정 
				for (int ko28_i=0; ko28_i<ko28_a.length; ko28_i++) { //for문 배열 반복 
			 System.out.printf("[%s]\n", fblank(ko28_a[ko28_i],9)); //입력값 출력  최대 9자리까지만 출력하도록 요청
			 
			 
	
	}

	}
public static String fblank(String ko28_a, int ko28_k) { //메소드 설정 
    String ko28_retS = ko28_a;//문자열 설정 

    if (ko28_a.length() >= ko28_k) { //if 문  문자열 길이가 9 이상
        return ko28_a.substring(0, ko28_k);  // 글자 단위로 자르기
    }

    int ko28_bCnt = ko28_k - ko28_a.length(); //부족한 길이 계산 

    for (int ko28_i = 0; ko28_i < ko28_bCnt; ko28_i++) { //if 문 문자열 길이가 9보다 짧으면
    	ko28_retS = "*" + ko28_retS; //왼쪽에 '*'추가 
    }
    return ko28_retS; //리턴 반환 
}
}