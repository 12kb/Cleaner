package XMLMapper.interfaces;

public interface Property<T> {
	
	public void setValue(T t);
	
	public T getValue(); 
	
	public long getModificationTime();
	
	public boolean isDeprecated();
	
	public void update();
	
	
}