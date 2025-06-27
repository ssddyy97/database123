package chap2;

		public class test9 {

			public static void main(String[] args) {
				// TODO Auto-generated method stub
				int ko28_i; // 숫자값 변수 설정 
				ko28_i=1; // 초기화 설정 
				int ko28_j=1;//초기화 설정 
				while(true) {
					ko28_j*=ko28_i; //ko28_j *= ko28_i; → ko28_j에 ko28_i 값을 계속 곱함.
					System.out.println("하나씩 곱해보자:"+(ko28_j)); //출력 
					ko28_i=ko28_i+1;//ko28_i 값을 1씩 증가
					if (ko28_i>=10) break; //ko28_i >= 10이 되면 break; 실행하여 반복문 종료.
				}
				System.out.println("********************");//**선 출력
				ko28_i=0;//초기값 설정
				ko28_j=1; //초기값 설정 
				while(true) { //무한루프 
					ko28_j*=ko28_i;//ko28_j *= ko28_i; → ko28_j에 ko28_i 값을 계속 곱함.
					System.out.println("하나씩 곱해보자:"+(ko28_j));
					ko28_i=ko28_i+1;
					if (ko28_i>=10) break;
				}
				
				System.out.println("********************");
				ko28_i=1;
				ko28_j=1;
				while(true) {
					ko28_j*=ko28_i;
					System.out.println("하나씩 곱해보자:"+(ko28_j));
					ko28_i=ko28_i+1;
					if (ko28_i>=10) break;
				}
			}

}

