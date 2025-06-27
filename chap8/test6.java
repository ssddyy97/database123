package chap8;

import java.io.*;

public class test6 { //클래스 선언 
    // 유클리드 거리 계산 메서드
    public static double euclidean(double ko28_lat1, double ko28_lon1, double ko28_lat2, double ko28_lon2) { //메서드 설정 
        double ko28_dLat = ko28_lat2 - ko28_lat1;//초기값 설정 
        double ko28_dLon = ko28_lon2 - ko28_lon1; //초기값 설정 
        return Math.sqrt(ko28_dLat * ko28_dLat + ko28_dLon * ko28_dLon); //유클리드 계산 공식 
    }

    public static void main(String[] args) throws IOException {
        File ko28_file = new File("C:\\Users\\USER\\Desktop\\myjava\\한국교통안전공단_전국공영주차장정보_20191224 (1).csv"); //File 객체를 사용해 지정된 CSV 파일을 로드

        if (!ko28_file.exists()) { //파일이 존재하지 않을때 
            System.out.println("파일이 존재하지 않습니다. 경로를 확인하세요."); //오류 메세지 출력 
            return;
        }

        try (BufferedReader ko28_br = new BufferedReader(new FileReader(ko28_file))) {//BufferedReader를 사용하여 CSV 파일을 한 줄씩 읽음
            String ko28_readtxt; //문자열 설정 

            if ((ko28_readtxt = ko28_br.readLine()) == null) { //첫번째 줄읽고 비어있다면 
                System.out.println("빈 파일입니다."); //오류 메세지 출력 
                return; //반환 
            }

            double ko28_lat = 37.37246142; //수내2동주민센터 위도 
            double ko28_lng = 127.1208549; //경도 

            double ko28_maxDist = 0; //최대값 초기값 설정 
            double ko28_minDist = Double.POSITIVE_INFINITY; //최소값 초기값 설정 

            String ko28_farthestLocation = ""; //가장 먼 주차장 
            double ko28_farthestLat = 0.0, ko28_farthestLng = 0.0; //초기값 설정 

            String ko28_nearestLocation = ""; //가장 가까운 주차장 
            double ko28_nearestLat = 0.0, ko28_nearestLng = 0.0; //초기값 설정 

            while ((ko28_readtxt = ko28_br.readLine()) != null) { //파일을 한줄 씩 읽어 
                String[] ko28_field = ko28_readtxt.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);//split을 사용해 ,로 구분된 데이터 배열(field[])에 저장

                if (ko28_field.length < 5) {//5개 미만이면 건너 뜀 
                    continue;
                }

                try {
                    String ko28_location = ko28_field[1].trim(); //주차장 이름 문자열 추출 
                    double ko28_wifiLng = Double.parseDouble(ko28_field[2].trim()); //주차장 위도 추출  
                    double ko28_wifiLat = Double.parseDouble(ko28_field[3].trim()); //주차장 경도 추출 

                    // 유클리드 거리 계산
                    double ko28_dist = euclidean(ko28_lat, ko28_lng, ko28_wifiLat, ko28_wifiLng);

                    if (ko28_dist > ko28_maxDist) { //현재 거리 dist가 기존 maxDist보다 크면 
                    	ko28_maxDist = ko28_dist;
                    	ko28_farthestLocation = ko28_location;
                    	ko28_farthestLat = ko28_wifiLat;
                    	ko28_farthestLng = ko28_wifiLng;// 가장 먼 주차장 정보 업데이트.
                    }

                    if (ko28_dist < ko28_minDist) {//현재 거리 dist가 기존 minDist보다 작으면
                    	ko28_minDist = ko28_dist;
                    	ko28_nearestLocation = ko28_location;
                    	ko28_nearestLat = ko28_wifiLat; 
                    	ko28_nearestLng = ko28_wifiLng; //가장 가까운 주차장 정보 업데이트
                    }
                } catch (NumberFormatException e) { //예외 넘김 처리 
                    continue;
                }
            }

            System.out.println("==================================================================================================="); //쉼표 출력 
            System.out.printf("가장 먼 주차장: 위치 = %s, 거리 = %.6f, 위도 = %.6f, 경도 = %.6f\n", //가장 먼 주차장 정보값 출력 
            		ko28_farthestLocation, ko28_maxDist, ko28_farthestLat, ko28_farthestLng); 
            System.out.printf("가장 가까운 주차장: 위치 = %s, 거리 = %.6f, 위도 = %.6f, 경도 = %.6f\n",//가장 가까운 주차장 정복값 출력 
            		ko28_nearestLocation, ko28_minDist, ko28_nearestLat, ko28_nearestLng);
            System.out.println("==================================================================================================="); //점선 출력 
        }
    }
}
