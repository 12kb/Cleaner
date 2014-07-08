package cleaner.product;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ProductFactory {
	
	String xmlfile;
	
	public ProductFactory(String xmlfile){
		this.xmlfile = xmlfile;
	}
	
	public Product createProducts(){
		
		Document doc = getDocument();
		NodeList nodesList = doc.getChildNodes();
		ArrayList<Product> products = new ArrayList<>();
		
		for (int i=0; i < nodesList.getLength(); i++){
			Node node = nodesList.item(i);
			//NodeList childs = node.getChildNodes();
			node.
			
			
		}
		
		
	}
	
	private Document getDocument(){
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document doc = null;
		
		try{
			builder = factory.newDocumentBuilder();
			
			doc = builder.parse(new File(xmlfile));
			
		}catch(Exception e){
			System.err.println("Error while dom document creating");
			e.printStackTrace();
		}
		
		return doc;
	}
}
