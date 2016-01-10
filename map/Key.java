package map;

/**
 *
 * @author Georgiana
 */
public interface Key extends Comparable<Key>{
    
    @Override
    public int hashCode();
    
    public String getKey();
    
    public void setKey(String key);
    
    @Override
    public boolean equals(Object other);
}
