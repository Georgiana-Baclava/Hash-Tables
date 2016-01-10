package map;

/**
 *
 * @author Georgiana
 */
public interface Value extends Comparable<Value>{
    
	public String getVal();
	
	public void setVal(String val);
	
    @Override
    public boolean equals(Object other);
}