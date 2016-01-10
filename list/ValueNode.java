package list;

import map.MyKey;
import map.MyValue;

public class ValueNode implements Node{
	protected ValueNode next;
	protected ValueNode prev;
	//public String value = "";
	MyValue value;
	public int no;
	
	
	public ValueNode() {
		
	}

	public ValueNode(MyValue value) {
		this.value = value;
		this.no = 1;
		next = null;
		prev = null;
	}
	

	public ValueNode getNext() {
		return next;
	}

	public ValueNode getPrev() {
		return prev;
	}

	public void setNext(Node node) {
		next = (ValueNode)node;
		//((ValueNode)node).prev = next;

	}

	public void setPrev(Node node) {
		prev = (ValueNode)node;
	}

	public Object getValue() {
		return this.value;
	}
	
	@Override
	public int compareTo(Node node) {
		return this.value.compareTo((MyValue)((ValueNode)node).getValue());
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof ValueNode)
			return ((ValueNode) other).value.equals(value);
		return false;
	}
}
