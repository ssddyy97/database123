package chap4;

public class practice3 { // 클래스 설정
    public static void main(String[] args) {
        for (int ko28_i = 1; ko28_i <= 12; ko28_i++) { // 1부터 12까지 (월)
            System.out.printf(" %d월 =>", ko28_i); // 월 출력

            int lastDay = 31; //  변수 설정 기본적으로 31일 설정
            if (ko28_i == 2) lastDay = 28; // 2월은 28일
            else if (ko28_i == 4 || ko28_i == 6 || ko28_i == 9 || ko28_i == 11) lastDay = 30; // 30일까지 있는 월

            for (int ko28_j = 1; ko28_j <= lastDay; ko28_j++) { // 해당 월의 마지막 날짜까지 출력
                System.out.printf("%d", ko28_j);
                if (ko28_j < lastDay) // 마지막 날짜가 아니면 쉼표 출력
                    System.out.printf(","); //쉼표 출력 
            }
            System.out.printf("\n"); // 줄바꿈
           
        }

        System.out.printf("*******************************************************************************************\n");//점선 출력 
        System.out.printf("\n");//칸 띄어 쓰기 
for (int ko28_i = 1; ko28_i <= 12; ko28_i++) { // 1부터 12까지 (월)
    System.out.printf(" %d월 =>", ko28_i); // 월 출력

    int lastDay2 = 31; // 기본적으로 31일 설정
    if (ko28_i == 2) lastDay2 = 28; // 2월은 28일 
    else if (ko28_i == 4 || ko28_i == 6 || ko28_i == 9 || ko28_i == 11) lastDay2 = 30; // 30일까지 있는 월

    for (int ko28_j = 1; ko28_j <= lastDay2; ko28_j++) { // for구문 1부터 해당 월의 마지막 날짜까지 출력
        System.out.printf("%d", ko28_j); //일 날짜 출력 
        if (ko28_j < lastDay2) // 마지막 날짜가 아니면 쉼표 출력
            System.out.printf(","); //쉼표 출력 
    }
    System.out.printf("\n"); // 줄바꿈
}
}
}
