package chap9;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class practice1 { //클래스 선언 
    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException { //메서드는 클래스 내부에서만 사용가능 하고 객체를 생성 X
        // XML 파일 경로 설정 (사용자가 업로드한 파일)
        File ko28_xmlFile = new File("C:\\Users\\USER\\Desktop\\날씨 정보.txt"); 
        
        // HTML 저장 경로
        File ko28_htmlFile = new File("C:\\Users\\USER\\Desktop\\myjava\\weather1.html");

        // 파일 출력 스트림 설정
        BufferedWriter ko28_htmlWriter = new BufferedWriter(new FileWriter(ko28_htmlFile));

        // XML 파서 생성 및 파일에서 문서 가져오기
        DocumentBuilder ko28_docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder(); //객체 설정 
        Document ko28_doc = ko28_docBuilder.parse(ko28_xmlFile); //객체 설정 
        Element ko28_root = ko28_doc.getDocumentElement(); //객체 설정 
        NodeList ko28_tag_001 = ko28_doc.getElementsByTagName("data"); //가져오려는 태그 객체 설정 

        // HTML 테이블 스타일 및 헤더 작성 (칸 맞춤)
        ko28_htmlWriter.write("<html>\r\n<head>\r\n<style>\r\n"  //html 구조 파일에 저장  시작태그와 스타일 지정 
                + "table { width: 100%; border-collapse: collapse; }\r\n" //너비 100퍼센트 collapse: 테이블 셀 경계선이 겹치지 않고 하나로 붙게 함
                + "th, td { border: 1px solid black; padding: 8px; text-align: center; }\r\n" //border: 1px solid black → 셀마다 검정 테두리
                + "th { background-color: #f2f2f2; }\r\n"//padding: 8px → 셀 안 여백 text-align: center → 가운데 정렬
                + "</style>\r\n</head>\r\n<body>\r\n");//헤더 셀 배경색을 연한 회색으로 설정해 가독성 향상
        ko28_htmlWriter.write("<body style='text-align: center;'>\r\n");
        ko28_htmlWriter.write("<h2>기상청 동네예보 - 경기도 성남시 분당구 (좌표: 61,123)</h2>\r\n"); //첫번째 타이틀 작성 
        ko28_htmlWriter.write("<p><strong>2030년 3월 21일 11시 발표</strong></p>\r\n"); //두번째 하이틀  작성 
        
        ko28_htmlWriter.write("<table>\r\n<tr>\r\n"); //테이블 작성 
        
        
        //  테이블 헤더
        ko28_htmlWriter.write("<th>번호</th><th>시간</th><th>날짜</th><th>온도</th><th>최고 온도</th><th>최저 온도</th>"); //번호 시간 날짜 온도 최고 온도 최저온도 순서 대로 작성 
        ko28_htmlWriter.write("<th>하늘 상태</th><th>강수 형태</th><th>날씨(한)</th><th>날씨(영)</th><th>강수 확률</th>");// 하늘 상태 강수형태 날씨 한 날씨 영 강수 확률 순서로 작성 
        ko28_htmlWriter.write("<th>12시간 강수량</th><th>12시간 적설량</th><th>풍속</th><th>풍향</th><th>풍향(한)</th>");//12시간 강수량 12시간 적설량 풍속 풍향 풍향 한 순소대로 작성 
        ko28_htmlWriter.write("<th>풍향(영)</th><th>습도</th><th>6시간 강수량</th><th>6시간 적설량</th></tr>\r\n"); //풍향 영 습도 6시간 강수량 적설량 순서대로 작성 

        // 📌 XML 데이터 읽어 테이블에 추가
        for (int ko28_i = 0; ko28_i < ko28_tag_001.getLength(); ko28_i++) {//각 태그 요소를 하나씩 반복하여 테이블 행을 만듦
            Element ko28_elmt = (Element) ko28_tag_001.item(ko28_i); //객체 설정 

            String ko28_seq = ko28_elmt.getAttribute("seq"); //번호 
            String ko28_hour = getElementValue(ko28_elmt, "hour");//시간 
            String ko28_day = getElementValue(ko28_elmt, "day");//날짜 
            String ko28_temp = getElementValue(ko28_elmt, "temp"); //온도
            String ko28_tmx = getElementValue(ko28_elmt, "tmx"); //최고 기온 
            String ko28_tmn = getElementValue(ko28_elmt, "tmn"); //최저기온 
            String ko28_sky = getElementValue(ko28_elmt, "sky"); //하늘상태 
            String ko28_pty = getElementValue(ko28_elmt, "pty"); //강수 상태
            String ko28_wfKor = getElementValue(ko28_elmt, "wfKor"); //날씨 한
            String ko28_wfEn = getElementValue(ko28_elmt, "wfEn"); //날씨 영 
            String ko28_pop = getElementValue(ko28_elmt, "pop");//강수확률 
            String ko28_r12 = getElementValue(ko28_elmt, "r12");//12시간 강수량 
            String ko28_s12 = getElementValue(ko28_elmt, "s12");//12시간 적설량 
            String ko28_ws = getElementValue(ko28_elmt, "ws"); //풍속 
            double ko28_wsValue = Double.parseDouble(ko28_ws); // 풍속을 더블로 변환해서 소수점 첫째숫자까지만 변환 
            String ko28_wsFormatted = String.format("%3.1f", ko28_wsValue); //변환 값 설정 
            String ko28_wd = getElementValue(ko28_elmt, "wd"); //풍향 
            String ko28_wdKor = getElementValue(ko28_elmt, "wdKor"); //풍향 한 
            String ko28_wdEn = getElementValue(ko28_elmt, "wdEn"); //풍향 영 
            String ko28_reh = getElementValue(ko28_elmt, "reh"); //습도 
            String ko28_r06 = getElementValue(ko28_elmt, "r06"); //6시간 강수량 
            String ko28_s06 = getElementValue(ko28_elmt, "s06"); //6시간 적설량 
            String ko28_skyIcon = String.format("<img src='C:\\Users\\USER\\Desktop\\아이콘 폴더\\sky_%s.png' alt='sky%s' width='24' height='24'>", ko28_sky, ko28_sky); 
            //날씨 에 따라 이미지 불러오기 
            String ko28_windIcon = String.format("<img src='C:\\Users\\USER\\Desktop\\아이콘 폴더\\wind_%s.png' alt='%s' width='24' height='24'>", ko28_wd,ko28_wdKor); 
            //풍속에 따라 이미지 불러오기 
            // HTML 테이블 행 작성 (칸 정렬)
            ko28_htmlWriter.write("<tr>");
            ko28_htmlWriter.write(String.format("<td>%s</td>", ko28_seq)); //번호 추출한 데이터를 테이블의 한행으로 구성 
            ko28_htmlWriter.write(String.format("<td>%s시</td>", ko28_hour)); //시간 
            ko28_htmlWriter.write(String.format("<td>%s</td>", (ko28_day.equals("0") ? "오늘" : ko28_day.equals("1") ? "내일" : "모레")));//날짜 
            ko28_htmlWriter.write(String.format("<td>%s°C</td>", ko28_temp)); //온도 
            ko28_htmlWriter.write(String.format("<td>%s°C</td>", ko28_tmx)); //최고기온 
            ko28_htmlWriter.write(String.format("<td>%s°C</td>", ko28_tmn)); //최저 기온 
            ko28_htmlWriter.write(String.format("<td>%s</td>", ko28_skyIcon)); //날씨 아이콘 출력 
            ko28_htmlWriter.write(String.format("<td>%s</td>", ko28_pty)); //강수상태 
            ko28_htmlWriter.write(String.format("<td>%s</td>", ko28_wfKor));//날씨 한 
            ko28_htmlWriter.write(String.format("<td>%s</td>", ko28_wfEn));//날씨 영
            ko28_htmlWriter.write(String.format("<td>%s%%</td>", ko28_pop));//강수 확률 
            ko28_htmlWriter.write(String.format("<td>%smm</td>", ko28_r12));//12시간 강수량 
            ko28_htmlWriter.write(String.format("<td>%scm</td>", ko28_s12));//12시간 적설량 
            ko28_htmlWriter.write(String.format("<td>%sm/s</td>", ko28_wsFormatted));//풍속 
            ko28_htmlWriter.write(String.format("<td>%s</td>", ko28_windIcon));//풍향 아이콘 
            ko28_htmlWriter.write(String.format("<td>%s</td>", ko28_wdKor)); //풍향 한 
            ko28_htmlWriter.write(String.format("<td>%s</td>", ko28_wdEn));// 풍향 영
            ko28_htmlWriter.write(String.format("<td>%s%%</td>", ko28_reh));//습도 
            ko28_htmlWriter.write(String.format("<td>%smm</td>",ko28_r06));//6시간 강수량 
            ko28_htmlWriter.write(String.format("<td>%scm</td>", ko28_s06));//6시간 적설량 
            ko28_htmlWriter.write("</tr>\r\n"); //종료 
        }

        // HTML 닫기
        ko28_htmlWriter.write("</table>\r\n</body>\r\n</html>"); //html 종료 
        ko28_htmlWriter.close(); //리소스 해제

        System.out.println(" HTML 파일 저장 완료! (weather1.html)"); //파일 저장 완료라는 메세지 출력 
    }

    // XML 요소 값을 가져오는 함수 (NullPointerException 방지)
    private static String getElementValue(Element ko28_parent, String ko28_tagName) { //메소드 설정 
        NodeList ko28_list = ko28_parent.getElementsByTagName(ko28_tagName);//부모 태그(parent) 아래에서 tagName을 가진 모든 태그를 가져옴
        if (ko28_list.getLength() > 0) { //가져온 리스트에 해당 태그가 하나라도 있으면 계속 진행 
            if (ko28_list.item(0).getFirstChild() != null) { //첫번째 태그에 텍스트 노드가 존재하는지 확인 
                String ko28_value = ko28_list.item(0).getFirstChild().getNodeValue().trim(); //값이 있다면 앞뒤 공백제거 후 반환 
                return ko28_value.isEmpty() ? "N/A" : ko28_value; //값이 비어있으면 n/a로 반환 
            }
        }
        return "N/A"; // 모든 조건을 통과하지 못하면 n/a로 반환 
    }
}