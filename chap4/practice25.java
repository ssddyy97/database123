package chap4;

public class practice25 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] items= {"오징어 땅콩", "미국산 한우 A++","Morning 버터 200ml"};
	

      
		int[] item_prc= {2000,40000,2000};
		int[] item_qty= {10,2,50};
		
		System.out.printf("\n\n%25s\n", "곰돌이마트 영수증");
		System.out.printf("=================================================================\n");
		System.out.printf("%10.10s%10.10s%10.10s%10.10s\n", "품명","단가","수량","합계");
		System.out.printf("=================================================================\n");
		
		int totPrc=0;
		for(int i=0; i<items.length;i++) {
			int itemTot=item_prc[i]*item_qty[i];
			System.out.printf("%9.9s%10.10s%11.11s%14.14s\n",
					bblank(items[i], 16),item_prc[i],item_qty[i],itemTot);
			totPrc=totPrc+itemTot;
		}
		
		System.out.printf("=================================================================\n");
		System.out.printf("%20.20s%15s\n", "합계 :",totPrc);
		System.out.printf("=================================================================\n");
		
		}

		public static String bblank(String str, int print_len) {
			String ret="";
			int prtCnt=0;
			for(int i=0; i<str.length();i++) {
				String a=str.substring(i,i+1);
				if(a.getBytes().length==1) {
					if((prtCnt+1)>print_len) break;
					prtCnt=prtCnt+1;
					ret=ret+a;
					
					
				}else {
					if((prtCnt+2)>print_len)break;
					prtCnt=prtCnt+2;
					ret=ret+a;
				
				}
			}
			while (prtCnt < print_len) {
		        ret += " ";
		        prtCnt++;
			}
			return ret;
			
		}
	}

