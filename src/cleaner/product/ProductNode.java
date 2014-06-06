package cleaner.product;

import java.util.Observable;

import org.w3c.dom.Node;
/**
 * Product data storage.
 */
public class ProductNode { 
	
	private String title;
	private String icon;
	private String distr;
	private String gcFilePaths[]; //paths for garbage collecting, after program's uninstalling
	private String gcRegPaths[]; //reg paths for deleting
	private boolean installed;
	
	//TODO delete this mock constructor
	public ProductNode(){
		this.title = title;
		this.icon = icon;
		this.distr = distr;
		this.gcFilePaths = filePaths;
		this.gcRegPaths = regPaths;
		this.installed = installed;
	}
	
	public ProductNode(String title, String icon, String distr, 
			String[] filePaths, String[] regPaths, boolean installed){
		this.title = title;
		this.icon = icon;
		this.distr = distr;
		this.gcFilePaths = filePaths;
		this.gcRegPaths = regPaths;
		this.installed = installed;
		
	}
	
//getters, setters
	public String getInfo(){
		
		String result;
		
		if(installed){
			result = "Uninstall program.\n";
			for (String path : gcFilePaths){
				result += "Delete : " + path + "\n";
			}
			
			for (String path : gcRegPaths){
				result += "Clean : " + path + "\n";
			}
			// уберем последний перевод строки
			result = result.substring(0, result.length()-1); 
			
		} else {
			result = 	"Install program.\n" + 
						"Installer path : " + distr;	
		}
		return result;
	}
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
	

	public String getDistr() {
		return distr;
	}
	
	public void setDistr(String distr) {
		this.distr = distr;
	}	

	
	public String[] getGcFilePaths() {
		return gcFilePaths;
	}

	public void setGcFilePaths(String[] gcFilePaths) {
		this.gcFilePaths = gcFilePaths;
	}

	
	public String[] getGcRegPaths() {
		return gcRegPaths;
	}

	public void setGcRegPaths(String[] gcRegPaths) {
		this.gcRegPaths = gcRegPaths;
	}

	public boolean isInstalled() {
		return installed;
	}

	public void setInstalled(boolean installed) {
		this.installed = installed;
	}
}
