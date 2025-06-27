package chap2;

public class test13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=1;
		long result=1; //long은 21억까지 밖에 되지않는다
		
		while (i<=10) {
			result*=i;
			i++;
			
			
		}
		
		System.out.println("1부터 10까지의 곱: "+result);
	}
			
}


