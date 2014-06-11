package XMLMapper;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class XMLMapper<T> {

	Class<?> boundedClass;
	ArrayList<T> relatedObjects;
	
	String filename;
	
	
		
	XMLMapper(String filename, Class<?> cls) throws Exception {
		String message = null;
		if (filename == null){
			message = "XMLMapper.XMLMapper: Filename can't be null.";
		}
		if (cls == null){
			message = "XMLMapper.XMLMapper: Bounded class can't be null.";
		}
		if (message != null){
			System.err.println(message);
			throw new NullPointerException(message);
		}
		this.filename = filename;
		this.boundedClass = cls;
		
		
		
		
		
	}
	
	/**
	 * Возвращает объект Document, который является объектным представлением XML
	 * документа.
	 */
	private Document getDocument() throws Exception {
		try {
			DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
			f.setValidating(false);
			DocumentBuilder builder = f.newDocumentBuilder();
			return builder.parse(new File(filename));
		} catch (Exception ex) {
			String message = "XML parsing error!";
			System.err.println(message);
			System.err.println(ex.toString());
			ex.printStackTrace();
			throw new Exception(message);
		}
	}

	
	

	
}


class FieldWrapper {
	private Field field;
	private 
	
}
