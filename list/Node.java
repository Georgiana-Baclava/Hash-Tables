package list;

/**
 *
 * @author Georgiana
 */
public interface Node extends Comparable<Node>{
    
    /**
     * 
     * @return the next node in the list, or null if the end is reached 
     */
    public Node getNext();
    
    /**
     * 
     * @return the previous node from the list, or null if the end is reached
     */
    public Node getPrev();
    
    /**
     * Links the current node with {@code node}.
     * Links from both direction might be set here
     * @param node the node that should be set as the next node for the current one
     */
    public void setNext(Node node);
    
    
    /**
     * 
     * @param node the node that should be set as the previous node for the current one
     */
    public void setPrev(Node node);
    
    /**
     *
     * @return the value contained by the node
     */
    public Object getValue();
    
    @Override
    public boolean equals(Object other);
    
}