package cleaner;

import java.util.Vector;

@SuppressWarnings({ "serial", "rawtypes" })
public class NamedVector extends Vector {

	private String name;
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	
	NamedVector(String name){
		super();
		setName(name);
	}
	
	
	public String toString(){
		return this.name;
	}
}
