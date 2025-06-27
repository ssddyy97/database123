package chap9;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class test1 { //클래스 선언 

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException{
		
		DocumentBuilder ko28_docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder(); //객체 생성 
		
		
		
		Document ko28_doc=ko28_docBuilder.parse(new File("C:\\Users\\USER\\Desktop\\xml.xml")); //지정된 경로의 XML파일 을 읽어 Document 객체로 변환 
		
		
		Element ko28_root=ko28_doc.getDocumentElement(); //XML 루트요소를 가져옵니다 
		
		NodeList ko28_tag_name = ko28_doc.getElementsByTagName("name"); //이름 리스트를 가져옵니다 
		NodeList ko28_tag_studentid = ko28_doc.getElementsByTagName("studentid"); //studentid 리스트를 가져옵니다 
		NodeList ko28_tag_kor = ko28_doc.getElementsByTagName("kor"); // 국어 리스트를 가져옵니다 
		NodeList ko28_tag_eng = ko28_doc.getElementsByTagName("eng"); //영어 리스트를 가져옵니다 
		NodeList ko28_tag_mat = ko28_doc.getElementsByTagName("mat"); //수학 리스트를 가져옵니다 
		
		System.out.printf("********************************************\n"); //점선 출력 
		
		for(int ko28_i=0; ko28_i<ko28_tag_name.getLength();ko28_i++) { // xml 내 이름 태그 개수 만큼 반복문 실행 
			System.out.printf("이름 : %s\n", ko28_tag_name.item(ko28_i).getFirstChild().getNodeValue()); // 이름  태크의 텍스트 값을 가져옴 
			System.out.printf("학번 : %s\n", ko28_tag_studentid.item(ko28_i).getFirstChild().getNodeValue());// 학번  태크의 텍스트 값을 가져옴 
			System.out.printf("국어 : %s\n", ko28_tag_kor.item(ko28_i).getFirstChild().getNodeValue());// 국어  태크의 텍스트 값을 가져옴 
			System.out.printf("영어 : %s\n", ko28_tag_eng.item(ko28_i).getFirstChild().getNodeValue());// 영어  태크의 텍스트 값을 가져옴 
			System.out.printf("수학 : %s\n", ko28_tag_mat.item(ko28_i).getFirstChild().getNodeValue());// 수학  태크의 텍스트 값을 가져옴 
			System.out.printf("************************************************************\n"); //점선 출력 
			
		}
		
		// TODO Auto-generated method stub

	}

}