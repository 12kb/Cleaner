package old;

public class CheckBoxTreeNode {
	
//data
	public String name;
	public boolean checked;
	
//constructors
	public CheckBoxTreeNode(String _name, boolean _selected){
		super();
		this.name = _name;
		this.checked = _selected;
	}
	
//methods	
	@Override
	public String toString(){
		return name;
	}
}
