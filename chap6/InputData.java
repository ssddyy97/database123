package chap6;
public class InputData { //클래스 설정 
    public String[] ko28_name; //이름값 배열  설정 
    public int[] ko28_kor, ko28_eng, ko28_mat, ko28_sum;//국어 영어 수학 총합 값 배열 설정 
    public double[] ko28_ave; // 평균 저장 배열

    public InputData(int ko28_size) { //size값 배열 설정 
    	ko28_name = new String[ko28_size]; // 이름에 관한 값 과 사이즈 배열 설정 
    	ko28_kor = new int[ko28_size];//국어에 관한 값과 사이즈 배열 설정 
    	ko28_eng = new int[ko28_size];//영어에 관한 값과 사이즈 배열 설정
    	ko28_mat = new int[ko28_size];//수학에 관한 값과 사이즈 배열 설정
    	ko28_sum = new int[ko28_size];//총합에 관한 값과 사이즈 배열 설정
    	ko28_ave = new double[ko28_size];//평균에 관한 값과 사이즈 배열 설정
    }

    public void ko28_SetData(int ko28_index, String ko28_name, int ko28_kor, int ko28_eng, int ko28_mat) {//위치에 있는 데이터값 설정
        this.ko28_name[ko28_index] = ko28_name; //ko28_index 위치에 있는 학생의 이름데이터를 업데이트
        this.ko28_kor[ko28_index] = ko28_kor;//ko28_index 위치에 있는 학생의 국어데이터를 업데이트
        this.ko28_eng[ko28_index] = ko28_eng;//ko28_index 위치에 있는 학생의 영어데이터를 업데이트
        this.ko28_mat[ko28_index] = ko28_mat;//ko28_index 위치에 있는 학생의 수학데이터를 업데이트
        this.ko28_sum[ko28_index] = ko28_kor + ko28_eng + ko28_mat;//ko28_index 위치에 있는 학생의 국어+영어+수학 합계 데이터를 업데이트
        this.ko28_ave[ko28_index] = this.ko28_sum[ko28_index] / 3.0;//ko28_index 위치에 있는 학생의 국어+영어+수학 합계 나누기 3의 데이터를 업데이트
    }
}