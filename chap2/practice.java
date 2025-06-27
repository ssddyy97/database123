package chap2;

public class practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=10;i>0;i--) {
			String a="*************";
			a= a.substring(0,i);
			System.out.println(a);
		}

		for(int i=10; i>0; i--) {
			String a="";
			for(int j=0; j<i; j++) {
				a=a+"*";
			}
			System.out.println(a);
		}
		
	}
}
