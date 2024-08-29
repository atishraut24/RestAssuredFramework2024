package api.payloads;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Pet {
	
	public static String petdata() throws IOException {
		
		String xmlBody = new String(Files.readAllBytes(Paths.get(".//xmlbody.xml")));
		return xmlBody;
			
	}
	
	public static String updatepet(long  petid, String petname, String status) {
		
		String  modifiedXml = "";
		try{
			String xmlTemplate = new String(Files.readAllBytes(Paths.get(".//xmlbody.xml")));
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new InputSource(new StringReader(xmlTemplate)));

        // Modify XML
        Element petIdElement = (Element) document.getElementsByTagName("id").item(0);
        petIdElement.setTextContent(String.valueOf(petid));
        
        
        Element petnameElement=(Element)document.getElementsByTagName("name").item(1);
        petnameElement.setTextContent(String.valueOf(petname));
        
        
        Element petstatusElement=(Element)document.getElementsByTagName("status").item(0);
        petstatusElement.setTextContent(String.valueOf(status));

      

        // Convert Document back to XML string
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        transformer.transform(source, result);

        // Print the modified XML
         modifiedXml = writer.toString();
        System.out.println("Modified XML:");
        System.out.println(modifiedXml);
        
        

    } 
		catch (Exception e) {
        e.printStackTrace();
    }
		return modifiedXml;
}
	
		
	}
	

	
	


