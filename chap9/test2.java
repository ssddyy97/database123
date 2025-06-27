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

public class test2 { //클래스 선언 
    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
        // XML 파일 경로 설정 (사용자가 업로드한 파일)
        File ko28_xmlFile = new File("C:\\Users\\USER\\Desktop\\날씨 정보.txt"); //객체설정 
        
        // HTML 저장 경로
        File ko28_htmlFile = new File("C:\\Users\\USER\\Desktop\\myjava\\weather.html"); //객체설정 

        // 파일 출력 스트림 설정
        BufferedWriter ko28_htmlWriter = new BufferedWriter(new FileWriter(ko28_htmlFile)); //객체 설정 

        // XML 파서 생성 및 파일에서 문서 가져오기
        DocumentBuilder ko28_docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder(); // XML 파서를 생성
        Document ko28_doc = ko28_docBuilder.parse(ko28_xmlFile); // XML 문서를 Document 객체로 변환
        Element ko28_root = ko28_doc.getDocumentElement(); //객체 설정 
        NodeList ko28_tag_001 = ko28_doc.getElementsByTagName("data"); //data 태그를 가진 모든 요소를 NodeList 형태로 가져옴

        // HTML 테이블 헤더 작성
        ko28_htmlWriter.write("<html>\r\n<head></head>\r\n<body>\r\n<table border=1>\r\n<tr>\r\n"); //html의 구성 순서대로 파일에 저장 
        ko28_htmlWriter.write("<td width=\"100\">번호</td>\r\n" //각열의 크기 100px로 설정  번호 
                + "<td width=\"100\">시간</td>\r\n"  //시간 
                + "<td width=\"100\">날짜</td>\r\n"  //날짜 
                + "<td width=\"100\">온도</td>\r\n"  //온도 
                + "<td width=\"100\">최고 온도</td>\r\n" //최고온도 
                + "<td width=\"100\">최저 온도</td>\r\n" //최저온도 
                + "<td width=\"100\">하늘 상태</td>\r\n" //하늘 상태 
                + "<td width=\"100\">강수 형태</td>\r\n" //강수형태 
                + "<td width=\"100\">날씨(한)</td>\r\n"  //날씨(한) 
                + "<td width=\"100\">날씨(영)</td>\r\n" //날씨 (영)
                + "<td width=\"100\">강수 확률</td>\r\n" //강수 확률 
                + "<td width=\"100\">12시간 강수량</td>\r\n" //12시간 강수량 
                + "<td width=\"100\">12시간 적설량</td>\r\n" //12시간 적설량 
                + "<td width=\"100\">풍속</td>\r\n" //풍속 
                + "<td width=\"100\">풍향</td>\r\n"//풍향 
                + "<td width=\"100\">풍향(한)</td>\r\n" //풍향 한 
                + "<td width=\"100\">풍향(영)</td>\r\n" //풍향 영 
                + "<td width=\"100\">습도</td>\r\n" // 습도 
                + "<td width=\"100\">6시간 강수량</td>\r\n"//6시간 강수량 
                + "<td width=\"100\">6시간 적설량</td>\r\n" //6시간 적설량 
                + "</tr>\r\n"); 

        // XML 데이터 테이블에 채우기
        for (int ko28_i = 0; ko28_i < ko28_tag_001.getLength(); ko28_i++) { //for 문 
            Element ko28_elmt = (Element) ko28_tag_001.item(ko28_i); //각 태그값 가져오기 

            String ko28_seq = ko28_elmt.getAttribute("seq"); //번호 문자열 설정  
            String ko28_hour = getElementValue(ko28_elmt, "hour");//시간  문자열 설정 
            String ko28_day = getElementValue(ko28_elmt, "day"); //날짜 
            String ko28_temp = getElementValue(ko28_elmt, "temp"); //온도 
            String ko28_tmx = getElementValue(ko28_elmt, "tmx"); //최고기온 
            String ko28_tmn = getElementValue(ko28_elmt, "tmn"); //최저 기온 
            String ko28_sky = getElementValue(ko28_elmt, "sky"); //하늘 상태 -> 아이콘 
            String ko28_pty = getElementValue(ko28_elmt, "pty"); //강수형태 
            String ko28_wfKor = getElementValue(ko28_elmt, "wfKor"); //날씨(한)
            String ko28_wfEn = getElementValue(ko28_elmt, "wfEn"); //날시(영)
            String ko28_pop = getElementValue(ko28_elmt, "pop"); //강수확률 
            String ko28_r12 = getElementValue(ko28_elmt, "r12"); //12시간 강수량 
            String ko28_s12 = getElementValue(ko28_elmt, "s12"); //12시간 적설량 
            String ko28_ws = getElementValue(ko28_elmt, "ws");//풍속 
            String ko28_wd = getElementValue(ko28_elmt, "wd"); //풍향 
            String ko28_wdKor = getElementValue(ko28_elmt, "wdKor"); //풍향 한 
            String ko28_wdEn = getElementValue(ko28_elmt, "wdEn"); //풍향 영 
            String ko28_reh = getElementValue(ko28_elmt, "reh");//습도 
            String ko28_r06 = getElementValue(ko28_elmt, "r06");//6시간 강수량 
            String ko28_s06 = getElementValue(ko28_elmt, "s06"); //6시간 적설량 

            // HTML 테이블 행 작성
            ko28_htmlWriter.write("<tr>\r\n");
            ko28_htmlWriter.write(String.format("<td>%s</td>\r\n", ko28_seq)); //html 변환값 표시  
            ko28_htmlWriter.write(String.format("<td>%s시</td>\r\n", ko28_hour));//시간 변환 
            ko28_htmlWriter.write(String.format("<td>%s</td>\r\n", (ko28_day.equals("0") ? "오늘" : ko28_day.equals("1") ? "내일" : "모레"))); //day값을 변환해서 표시
            ko28_htmlWriter.write(String.format("<td>%s°C</td>\r\n", ko28_temp)); //온도 
            ko28_htmlWriter.write(String.format("<td>%s°C</td>\r\n", ko28_tmx)); //최고기온 
            ko28_htmlWriter.write(String.format("<td>%s°C</td>\r\n", ko28_tmn)); //최저 기온 
            ko28_htmlWriter.write(String.format("<td>%s</td>\r\n", ko28_sky)); //하늘 상태 -> 아이콘 
            ko28_htmlWriter.write(String.format("<td>%s</td>\r\n", ko28_pty)); //강수형태 
            ko28_htmlWriter.write(String.format("<td>%s</td>\r\n", ko28_wfKor)); //날씨 (한)
            ko28_htmlWriter.write(String.format("<td>%s</td>\r\n", ko28_wfEn)); //날씨 (영)
            ko28_htmlWriter.write(String.format("<td>%s%%</td>\r\n", ko28_pop)); //강수확률 
            ko28_htmlWriter.write(String.format("<td>%smm</td>\r\n", ko28_r12)); //12시간 강수량 
            ko28_htmlWriter.write(String.format("<td>%scm</td>\r\n", ko28_s12)); //12시간 적설량 
            ko28_htmlWriter.write(String.format("<td>%sm/s</td>\r\n", ko28_ws)); //풍속 -> 아이콘 
            ko28_htmlWriter.write(String.format("<td>%s</td>\r\n", ko28_wd)); //풍향  
            ko28_htmlWriter.write(String.format("<td>%s</td>\r\n", ko28_wdKor)); //풍향 한   
            ko28_htmlWriter.write(String.format("<td>%s</td>\r\n", ko28_wdEn)); //풍향 영
            ko28_htmlWriter.write(String.format("<td>%s%%</td>\r\n", ko28_reh)); //습도 
            ko28_htmlWriter.write(String.format("<td>%smm</td>\r\n", ko28_r06));//6시간 강수량 
            ko28_htmlWriter.write(String.format("<td>%scm</td>\r\n", ko28_s06)); //6시간 적설량 
            ko28_htmlWriter.write("</tr>\r\n");  //종료
        }

        // HTML 닫기
        ko28_htmlWriter.write("</table>\r\n</body>\r\n</html>"); //html 닫기 및 저장 완료 
        ko28_htmlWriter.close(); //리소스 해제

        System.out.println("HTML 파일 저장 완료! (weather.html)"); //파일 저장 완료 메세지 출력 
    }

    // XML 요소 값을 가져오는 함수 (NullPointerException 방지) 메소드 설정 
    private static String getElementValue(Element ko28_parent, String ko28_tagName) { //객체를 생성하지 않아도 호출가능  반환값은 문자열  
        NodeList ko28_list = ko28_parent.getElementsByTagName(ko28_tagName); //부모 요소내에 특정 태그 목록을 가져옴 
        if (ko28_list.getLength() > 0) { //태그가 존재하는지 확인 
            if (ko28_list.item(0).getFirstChild() != null) { //첫번째 태그 요소 
                String ko28_value = ko28_list.item(0).getFirstChild().getNodeValue().trim(); //태그 내부의 값이 있는지 확인 
                return ko28_value.isEmpty() ? "N/A" : ko28_value; //비어있으면 N/A값을 처리됨 
            }
        }
        return "N/A"; //반환 
    }

}
