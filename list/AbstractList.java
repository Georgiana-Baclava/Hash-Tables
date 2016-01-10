package list;

/**
 *
 * @author Georgiana
 */
public abstract class AbstractList {
    protected Node first;
    protected Node last;
    
    /**
     * The function iterates through the list until it reaches a node that 
     * has a value equal with the one given as parameter
     * @param value the node searched for
     * @return the node from the list that satisfies the criteria
     */
    public abstract Node getFirstEqual(Object value);
    
    /**
     * This function should be implemented for sorted lists.
     * It iterated through the lists and returns the first node 
     * with a value equal or greater than the parameter. 
     * The comparison is done using the compareTo method
     * @param value the value searched for
     * @return the node from the list that satisfies the criteria
     */
    public abstract Node getSortedPosition(Object value);
    
    /**
     * Inserts a node with value {@code value} before {@code node}
     * @param node the node from the list, or null if the insertion 
     * is done at the end of the list
     * @param value the value that needs to be inserted
     */
    public abstract void insertBefore(Node node, Object value);
    
    /**
     * Inserts the value given at the end of the list
     * @param value the value that needs to be inserted
     */
    public abstract void add(Object value);
    
    /**
     * Removes the given node from the list
     * @param node the node to be removed
     */
    public abstract void remove(Node node);
    
    /**
     * 
     * @return the number of nodes in the list 
     */
    public abstract int size();
    
    @Override
    public abstract String toString();
    
}