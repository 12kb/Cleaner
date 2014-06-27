package cleaner;

import java.util.ArrayList;

import cleaner.GUI.ProductCleanerWindow;
import cleaner.product.ProductRecord;

public class Main2  {
	
	public static void main(String[] args){
				
		String insts_names[] = {"MechaniCS 8.1", "MechaniCS 9.0", "MechaniCS 9.2", "MechaniCS 10.1"};
		String prods_names[] = {"NanoCAD 4.5", "NanoCAD 5.0", "NanoCAD 5.4", "NanoCAD 6.0"};
		
		ArrayList<ProductRecord> prods_a = new ArrayList<>();
		ArrayList<ProductRecord> insts_a = new ArrayList<>();
		
		for (String str: insts_names) {
			insts_a.add(new ProductRecord(str));
		}
		
		for (String str: prods_names) {
			prods_a.add(new ProductRecord(str));
		}
		
		ProductRecord[] prods = new ProductRecord[4];
		ProductRecord[] insts = new ProductRecord[4];
		
		prods_a.toArray(prods);
		insts_a.toArray(insts);
		
		new ProductCleanerWindow(prods, insts);
		
	}
}
