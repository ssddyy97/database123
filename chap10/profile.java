package chap10;

import java.util.Scanner;

public class profile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        String[] names = new String[10];
        int[] ages = new int[10];

   
      for (int i = 0; i < 100; i++) {
            System.out.print((i + 1) + "번째 이름을 입력하세요: ");
            names[i] = scanner.nextLine();

            System.out.print("나이를 입력하세요: ");
            ages[i] = scanner.nextInt();
            scanner.nextLine(); 
            
            System.out.println("\n[입력 결과]");
            for (int i = 0; i < 100; i++) {
                System.out.println((i + 1) + ". " + names[i] + " - " + ages[i] + "살");
        }

     
        }

        scanner.close();
    }
}
