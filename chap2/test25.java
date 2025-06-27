package chap2;

public class test25 { //클래스 설정 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		short ko28_sMin=-32768;  // short의 최소값
		short ko28_sMax=32767; // short의 최대값
		System.out.printf("[%d]\n[%d]\n[%d]\n[%d]\n", // 출력 
				//short 크기 16비트,최소값 -32,768,	최대값 32,767
				ko28_sMin, 
				(short)(ko28_sMin-1), //출력 오버 플로우
				ko28_sMax, 
				(short)(ko28_sMax+1) // 출력 오버 플로우
				);
		System.out.printf("==========================\n");// 선 출력 
		char ko28_cMin=0x0; // char의 최소값 (16진수 0x0 = 0)
		char ko28_cMax=0xff; // char의 최대값 (16진수 0xff = 255)
		System.out.printf("[%x]\n[%x]\n[%x]\n[%x]\n",//출력 
				//char	크기 16비트, 최솟값	0,최대값65,535
				(byte)ko28_cMin, // 출력
				(byte)(ko28_cMin-1),//출력 
				(byte)ko28_cMax,// 출력 
				(byte)(ko28_cMax+1) //출력
				);

	}

}
