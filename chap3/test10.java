package chap3;

public class test10 { //클래스 설정 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ko28_MyWon=1000000; //초기값 설정 환전할 원화  나는 은행에서 100만원 주고 달러로 바꿔달라고 했다, 와 신난다 해외여행 간다..
		double ko28_MoneyEx=1238.21; //초기값 설정  환율 
		double ko28_commission=0.003; // 초기값 설정 환전수수료율 뭐 0.3퍼 센트라고 생각하지 
		
		//은행가서 달라 바꾸는데 달라 지폐만 주지, 동전 센트달라고 하면 바보된다
		//강동환 군은 100만원 들고가서 네이버 환율보고 아 807달라 받겠구나 하고 갔다
		// 은행 신입사원 유상현군은 수수료 생각안하고 ..
		
		
		int ko28_usd=(int) (ko28_MyWon/ko28_MoneyEx); //변수 설정  환전 가능한 달러(정수만) 최종결과를 정수형으로 만들면 버림처리가 된다. 
		//전체 금액을 환율로 나눳다
		int ko28_remain=(int)(ko28_MyWon-ko28_usd*ko28_MoneyEx); //변수 설정 잔돈 계산 
		//고객에게 돌려줄 잔돈도 당연히 소숫점이하의 금액은 삥땅해야한다.
		// 실수로 계산후 버림처리
		//전체 금액에서 달러금액(달러*환율)을 뺏다. 만일 2324.22원 이런식으로 나오면 0.22원은 삥땅처라.... 줄수도 없다. 
		
		System.out.printf("******************************\n"); //입력값 출력 
		System.out.printf("*		수수료없이 계산		*\n");//입력값 출력
		System.out.printf("총 한화환전금액:ㅣ %d원=> 미화: %d달러, 잔돈: %d원\n",ko28_MyWon, ko28_usd, ko28_remain); //입력값 출력 //쉽다 
		
		System.out.printf("******************************\n");//입력값 출력
		
		//유상현군은 짤렸다.... 수수료를 안받아서
		//그옆에 홍보경군이 수수료를 계산했다. 뭐 그거 얼마나 한다고..
		
double ko28_ComPerOne = ko28_MoneyEx * ko28_commission; // 형변환  1달러당 수수료
		
		double ko28_totalcom=ko28_usd*ko28_ComPerOne;//형변환 총수수료 
		//달러당 수수료를 더해서 계산할까? 아니면 전체 금액을 신청한 후 수수료율을 때릴까? 
		// 현재는 실수연산을 사용하기 때문에 차이는 없다. 정수형은 차이가 난다.
		System.out.printf("******************************************\n");// 입력값 출력 
		System.out.printf("*		수수료계산						*\n");// 입력값 출력 
		System.out.printf("총 수수료: %f원=> 미화: %d달러, 달러당 수수료: %f원\n", ko28_totalcom, ko28_usd,ko28_ComPerOne);// 입력값 출력 
		
		System.out.printf("********************************************\n");// 입력값 출력 //여기까지
		
		
		//당연히 수수료는 받아야할 돈이니 올림처리 하자 
		int ko28_i_totalcom;//변수값 설정 

		if (ko28_totalcom !=(double)((int)ko28_totalcom)) // 조건문  totalcom이 정수가 아니면 올림 처리하여 수수료 반올림
			ko28_i_totalcom=(int)ko28_totalcom+1; // 소수점 올림 처리
		else //아니면 
			ko28_i_totalcom=(int)ko28_totalcom; //그대로 유지 

		System.out.printf("************************************************\n"); //입력값 출력 
		System.out.printf("*		수수료 적용확전						  *\n");	//입력값 출력 
		System.out.printf("*총 수수료: %d원=>미화: %d달러, 달러당 수수료: %f원\n", ko28_i_totalcom, ko28_usd, ko28_ComPerOne);//입력값 출력 

		ko28_remain=(int)(ko28_MyWon-ko28_usd*ko28_MoneyEx-ko28_i_totalcom); //환전 후 남은 원화(잔돈)를 계산하는 수식
		System.out.printf("총 한화 환전 금액: %d원=> 미화: %d달러, 수수료칭구: %d원 잔돈: %d원\n", ko28_MyWon,ko28_usd, ko28_i_totalcom, ko28_remain);
		//입력값 출력
		System.out.printf("************************************************\n");//입력값 출력  //여기까지
		
		
		//홍보경군도 고객에게 잔돈도 없고요, 2233원을 더 주셔야 807달러를 드립니다. 했더니 고객이 아 난 100만원 딸랑 가지고 왔는데 뭐야 ... 홍보경군도 짤렷다
		// 정확한 답은 실수형 계산으로 먼저 (1달러+1달러 환전수수료) 이 금액을 전체 금액으로 나누어 환전해 주는것이다. 홍진욱 군이 얻어 먹었다..
		// 왜 더블로 계산하고, 인트로 계산하는지 잘생각해라.. 이런거 익히는게 변수 선언, 형변환, 연산이다.
		
		//int MyWon=1000000  //나는 은행에서 100만원 주고 달러로 바꿔달라고 했다. 
		//double MoneyEx=1238.21; //달러 환율 
		//double commission=0.003; //환전수수료, 뭐 0.3 퍼센트라고 생각하지 
		//double ComPerOne = MoneyEx*commission; //1달러당 수수료 
		ko28_usd= (int) (ko28_MyWon/(ko28_MoneyEx + ko28_ComPerOne)); //변수 설정  수수료를 포함한 달러 환전 계산
		ko28_totalcom=ko28_usd*ko28_ComPerOne; //총 수수료 
		//수수료 올림 처리 

		if (ko28_totalcom !=(double)((int)ko28_totalcom)) //if 문 소수점 존재 시 반올림
			ko28_i_totalcom=(int)ko28_totalcom+1; //규칙 설명 
		else //아닐경우 
			ko28_i_totalcom=(int)ko28_totalcom;// 그대로 유지 
		System.out.printf("**************************************************\n");//입력값 출력 
		System.out.printf("*		 (정확한)수수료 적용환전				*\n");//입력값 출력 

		System.out.printf("총수수료: %d원=> 미화:	%d달러, 달러당 수수료: %f원\n", ko28_i_totalcom, ko28_usd,ko28_ComPerOne);//입력값 출력 

		ko28_remain=(int) (ko28_MyWon-ko28_usd*ko28_MoneyEx -ko28_i_totalcom); //초기값 설정 

		System.out.printf("총 한화환전금액: %d원=> 미화: %d달러, 수수료칭구: %d원 잔돈: %d원\n", ko28_MyWon, ko28_usd, ko28_i_totalcom, ko28_remain);//입력값 출력 

		System.out.printf("**************************************************\n");//입력값 출력 

	}

}
