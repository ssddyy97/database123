package chap6;

public class test13 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    	
        
        int ko28_iPerson = 10; // iPerson 값만큼 저장소 생성

        InputData ko28_inData = new InputData(ko28_iPerson); // 생성자의 숫자를 준만큼 배열을 만든다.

        // 입력 데이터를 무작위로 생성하여 배열에 저장
        for (int ko28_i = 0; ko28_i < ko28_iPerson; ko28_i++) {
            String ko28_name = String.format("홍길%02d", ko28_i); // 이름 만들기
            int ko28_kor = (int) (Math.random() * 100); // 국어 점수 만들기
            int ko28_eng = (int) (Math.random() * 100); // 영어 점수 만들기
            int ko28_mat = (int) (Math.random() * 100); // 수학 점수 만들기
            ko28_inData.ko28_SetData(ko28_i, ko28_name, ko28_kor, ko28_eng, ko28_mat); // 클래스 내부 배열에 데이터 입력
        }

        // 입력된 값이 잘 저장되었는지 확인
        for (int ko28_i = 0; ko28_i < ko28_iPerson; ko28_i++) {
            System.out.printf("번호:%d, 이름:%s, 국어:%d, 영어:%d, 수학:%d, 총점:%d 평균:%f%n",
            		ko28_i, ko28_inData.ko28_name[ko28_i], ko28_inData.ko28_kor[ko28_i], ko28_inData.ko28_eng[ko28_i], ko28_inData.ko28_mat[ko28_i], 
            		ko28_inData.ko28_sum[ko28_i], ko28_inData.ko28_ave[ko28_i]); //번호 이름 국어 영어 수학 총점 평균 값 출력 
        }
    }
}