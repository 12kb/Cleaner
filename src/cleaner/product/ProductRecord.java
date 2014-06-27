package cleaner.product;
/**
 * Product data storage.
 */
public class ProductRecord { 
	
	private String title;
	private boolean isInstalled;
	
	
	
	
	public ProductRecord(){
		this.title = "NanoCAD Жылезобатон 110.18";
		this.isInstalled = false;
	}
	
	
	
	
	public ProductRecord(String title, boolean installed){
		this.title = title;
		this.isInstalled = installed;
	}
	
	
	
	
	public ProductRecord(String name) {
		this(name, false);
	}
	
	
	
	
	@Override
	public String toString(){
		
		String result = this.title + " (" + (this.isInstalled ? "installed" : "not installed") + ")";
		
		return result;
		
	}
	
	
	
	public String getTitle() {
		return title;
	}

	
	
	public void setTitle(String title) {
		this.title = title;
	}


	
	
	public boolean isInstalled() {
		return isInstalled;
	}
	
	
	

	public void setInstalled(boolean installed) {
		this.isInstalled = installed;
	}
}
