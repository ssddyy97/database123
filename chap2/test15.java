package chap2;

public class test15 {
    public static void main(String[] args) {
    	
        for(int ko28_i=10; ko28_i>0; ko28_i--) { 
            String ko28_a = ""; 
            for(int ko28_j=0; ko28_j<ko28_i; ko28_j++) {
                ko28_a = ko28_a + "*";
            }
            System.out.println(ko28_a);
        }

        // 2. @, #, * 패턴 출력
        int ko28_i = 0;  // 다시 초기화
        String ko28_a = "@";
        while(true) {
            if(ko28_i % 3 == 0) 
                ko28_a = ko28_a + "#";
            else if (ko28_i % 3 == 1) 
                ko28_a = ko28_a + "@";
            else 
                ko28_a = ko28_a + "*";

            ko28_i++;
            System.out.println("응용했당" + ko28_i + ":" + ko28_a);
            if (ko28_i >= 50) break;
        }
    }
}
					