package chap7;

public class test1 {
    public static void main(String[] args) {
        System.out.printf("HanBlankForeword[%s]\n", HanBlankForeword("한글abcd", 15));
        System.out.printf("HanBlankForeword[%s]\n", HanBlankForeword("한글한글aa", 15));
        System.out.printf("HanBlankBackword[%s]\n", HanBlankBackword("한글aa", 15));
        System.out.printf("HanBlankBackword[%s]\n", HanBlankBackword("한글한글aa", 15));
        System.out.printf("한글은 [%d]개\n", HanCount("한글한글aa"));
    }

    // 문자열의 실제 출력 폭(한글: 2칸, ASCII: 1칸) 계산
    public static int getVisualLength(String str) {
        int length = 0;
        for (char ch : str.toCharArray()) {
            if (ch < 128) {
                length += 1; // ASCII 문자 (영어, 숫자, 특수문자) → 1칸
            } else {
                length += 2; // 한글 등 넓은 문자 → 2칸
            }
        }
        return length;
    }

    // 왼쪽 정렬을 맞추기 위해 앞쪽에 공백 추가
    public static String HanBlankForeword(String text, int targetWidth) {
        int textWidth = getVisualLength(text); // 실제 차지하는 길이
        if (textWidth >= targetWidth) {
            return text;
        }

        int spaceCount = targetWidth - textWidth;
        return " ".repeat(spaceCount) + text;
    }

    // 오른쪽 정렬을 맞추기 위해 뒤쪽에 공백 추가
    public static String HanBlankBackword(String text, int targetWidth) {
        int textWidth = getVisualLength(text);
        if (textWidth >= targetWidth) {
            return text;
        }

        int spaceCount = targetWidth - textWidth;
        return text + " ".repeat(spaceCount);
    }

    // 한글 개수 세기
    public static int HanCount(String text) {
        int hanCount = 0;
        for (char ch : text.toCharArray()) {
            if (ch >= 0xAC00 && ch <= 0xD7A3) { // 한글 범위 체크
                hanCount++;
            }
        }
        return hanCount;
    }
} 