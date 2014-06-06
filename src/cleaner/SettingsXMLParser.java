package cleaner;

import java.io.File;
import java.util.List;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import cleaner.product.ProductNode;

public class SettingsXMLParser {
	
	private String settingsPath;
	
	public SettingsXMLParser(String path){
		this.settingsPath = path;
	}
	
	
	private Document getDocument() { //throws Exception {
        try {
            DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
            f.setValidating(false);
            DocumentBuilder builder = f.newDocumentBuilder();
            return builder.parse(new File(settingsPath));
        } catch (Exception exception) {
            String message = "XML parsing error!";
            //throw new Exception(message);
            System.err.println(message);
            return null;
            //TODO: сделать выброс исключений и поимку их снаружи
        }
    }
	
	public Vector<ProductNode> getRoot(){
		
		Document doc = getDocument();
		NodeList root = doc.getChildNodes();
		
		Vector<ProductNode> products = new Vector<>();
		
		for (int i=0; i < root.getLength(); i++){
			products.add(new ProductNode(root.item(i)));
		}
		
		return products;
		
	}
}
