package chap3;

public class test8 { //클래스 선언 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] ko28_item= {"맛동산", "웨하스", "롯데샌드", "오땅" , "사브레"};
		int[] ko28_price= {1000,2000,3000,2500,1450};
		int[] ko28_amount= {10,2,1,3,5};
		double ko28_tax_rate=0.1;
		int ko28_total_sum=0;
		
		
		System.out.printf("**************************************\n");
		System.out.printf(" 	너가 지른 과자들		 \n");
		System.out.printf("항목	   단가수량합계	\n");
		for (int ko28_i = 0; ko28_i < ko28_item.length; ko28_i++) {
			int ko28_sum= ko28_price[ko28_i] * ko28_amount[ko28_i];
			ko28_total_sum = ko28_total_sum + ko28_sum;
			System.out.printf("%.5s		%7d		%2d		%9d\n",ko28_item[ko28_i],ko28_price[ko28_i],ko28_amount[ko28_i],ko28_sum);
		}
		System.out.printf("**************************************\n");
		System.out.printf("지불금액:     %20d\n",ko28_total_sum);
		
		int ko28_total_net_price=(int)(ko28_total_sum/(1+ko28_tax_rate));
		System.out.printf("과세금액:	 %20d\n",ko28_total_net_price);
		int ko28_tax=ko28_total_sum=ko28_total_net_price;
		System.out.printf("세  금:		 %20d\n",ko28_tax);
		}
	}


