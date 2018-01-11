package org.test.com;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class TestClass {
	public static void main(String args[] ) throws Exception {
		   
		try {

			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			
			System.out.println("Please enter XML data");
			
			Scanner input = new Scanner(System.in);
            String xml;
            //!(xml = input.nextLine()).isEmpty()
            StringBuffer br = new StringBuffer("");
			while ((xml=input.nextLine()).length()>1) {
            	br.append(xml);
            	System.out.println(br);
            	            }
			System.out.println("out");
		     //String xml =  s.next() ;

			DefaultHandler handler = new DefaultHandler() {

			boolean bfname = false;
			boolean blname = false;
			boolean bnname = false;
			boolean bsalary = false;

			public void startElement(String uri, String localName,String qName,
		                Attributes attributes) throws SAXException {

				System.out.println("Start Element :" + qName);

				if (qName.equalsIgnoreCase("FIRSTNAME")) {
					bfname = true;
				}

				if (qName.equalsIgnoreCase("LASTNAME")) {
					blname = true;
				}

				if (qName.equalsIgnoreCase("NICKNAME")) {
					bnname = true;
				}

				if (qName.equalsIgnoreCase("SALARY")) {
					bsalary = true;
				}

			}

			public void endElement(String uri, String localName,
				String qName) throws SAXException {

				System.out.println("End Element :" + qName);

			}

			public void characters(char ch[], int start, int length) throws SAXException {

				if (bfname) {
					System.out.println("First Name : " + new String(ch, start, length));
					bfname = false;
				}

				if (blname) {
					System.out.println("Last Name : " + new String(ch, start, length));
					blname = false;
				}

				if (bnname) {
					System.out.println("Nick Name : " + new String(ch, start, length));
					bnname = false;
				}

				if (bsalary) {
					System.out.println("Salary : " + new String(ch, start, length));
					bsalary = false;
				}

			}

		     };
		     
		    
		     InputSource is = new InputSource(new StringReader(br+""));  
		     saxParser.parse(is, handler);

		     } catch (Exception e) {
		       e.printStackTrace();
		     }

		   }
}
