package chap8;

import java.io.*;

public class test5 { //클래스 선언 
    // 유클리드 거리 계산 메서드 추가
    public static double euclidean(double ko28_lat1, double ko28_lon1, double ko28_lat2, double ko28_lon2) { //메소드 설정 
        double ko28_dLat = ko28_lat2 - ko28_lat1; //변수 설정  
        double ko28_dLon = ko28_lon2 - ko28_lon1; //변수 설정 
        return Math.sqrt(ko28_dLat * ko28_dLat + ko28_dLon * ko28_dLon); //유클리드 거리 계산 함수 
    }

    public static void main(String[] args) throws IOException {
        File ko28_file = new File("C:\\Users\\USER\\Desktop\\myjava\\Cleaned_WiFi_Data_Final_Verified_No_Distance.csv"); //File 객체를 사용해 지정된 CSV 파일을 로드

        if (!ko28_file.exists()) {//파일이 존재하지 않을 경우 

            System.out.println("파일이 존재하지 않습니다. 경로를 확인하세요."); //에러 메시지 출력 후 프로그램 종료
            return; //반환 
        }

        try (BufferedReader ko28_br = new BufferedReader(new FileReader(ko28_file))) { //BufferedReader를 사용해 파일을 읽음
            String ko28_readtxt; //문자열 설정 

            if ((ko28_readtxt = ko28_br.readLine()) == null) { //첫 번째 줄만 읽고 버림

                System.out.println("빈 파일입니다."); //출력 
                return; //반환 
            }

            double ko28_lat = 37.3860521; //위도 초기값 설정
            double ko28_lng = 127.1214038; //경도 초기값 설정 

            double ko28_maxDist = 0; //최대 값 변수 초기화 
            double ko28_minDist = Double.POSITIVE_INFINITY; //최소값 변수 초기화 

            String ko28_farthestLocation = ""; //가장 먼 위치 문자열 설정 
            double ko28_farthestLat = 0.0, ko28_farthestLng = 0.0;//초기값 설정

            String ko28_nearestLocation = ""; //가장 가까운 위치 문자열 설정 
            double ko28_nearestLat = 0.0, ko28_nearestLng = 0.0; //초기값 설정 

            while ((ko28_readtxt = ko28_br.readLine()) != null) { //파일을 한 줄씩 읽어

                String[] ko28_field = ko28_readtxt.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1); // ,로 구분된 데이터 배열로 저장

                if (ko28_field.length < 7) { //데이터가 7개 미만 일 경우 건너뜀 
                    continue;
                }

                try {
                    String ko28_location = ko28_field[1].trim() + " " + ko28_field[2].trim(); //와이파이 위치 이름 , 상세 주소
                    double ko28_wifiLat = Double.parseDouble(ko28_field[5].trim()); //wifi 위도 
                    double ko28_wifiLng = Double.parseDouble(ko28_field[6].trim()); //wifi 경도 

                    // 유클리드 거리 계산 적용
                    double ko28_dist = euclidean(ko28_lat, ko28_lng, ko28_wifiLat, ko28_wifiLng); //초기값 설정 

                    if (ko28_dist > ko28_maxDist) { //현재 거리 dist가 기존 maxDist보다 크면 
                    	ko28_maxDist = ko28_dist; //가장 먼 와이파이 갱신 
                    	ko28_farthestLocation = ko28_location;
                    	ko28_farthestLat = ko28_wifiLat;
                    	ko28_farthestLng = ko28_wifiLng;
                    }

                    if (ko28_dist < ko28_minDist) { //현재 거리 dist가 기존 minDist보다 작으면
                    	ko28_minDist = ko28_dist; // 가장 가까운 WiFi 갱신.
                    	ko28_nearestLocation = ko28_location;
                    	ko28_nearestLat = ko28_wifiLat;
                    	ko28_nearestLng = ko28_wifiLng;
                    }
                } catch (NumberFormatException ko28_e) { //예외 처리 해당줄을 건너 뜀 
                    continue;
                }
            }

            System.out.println("==================================================================================================="); //점선 출력 
            System.out.printf("가장 먼 WiFi: 위치 = %s, 거리 = %.6f, 위도 = %.6f, 경도 = %.6f\n", // 가장 먼 와이파이 위치 거리 위도 경도 출력 
            		ko28_farthestLocation, ko28_maxDist, ko28_farthestLat, ko28_farthestLng);
            System.out.printf("가장 가까운 WiFi: 위치 = %s, 거리 = %.6f, 위도 = %.6f, 경도 = %.6f\n", //가장 가까운 와이파이 위치 걸리 위도 경도 출력 
            		ko28_nearestLocation, ko28_minDist, ko28_nearestLat, ko28_nearestLng);
            System.out.println("==================================================================================================="); //점선 출력 
        }
    }
}
