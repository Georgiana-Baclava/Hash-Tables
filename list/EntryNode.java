package list;

import map.MyKey;

public class EntryNode implements Node {
	protected EntryNode next;
	protected EntryNode prev;
	public MyKey key;
	public ValueList val_list;
	
	public EntryNode() {
		
	}
	
	public EntryNode(MyKey key) {
		this.key = key;
		this.val_list = new ValueList();
		next = null;
		prev = null;
	}

	public EntryNode getNext() {
		return next;
	}

	public EntryNode getPrev() {
		return prev;
	}

	public void setNext(Node node) {
		next = (EntryNode)node;
	}

	public void setPrev(Node node) {
		prev = (EntryNode)node;
	}

	public Object getValue() {
		return this.key;
	}
	
	@Override
	public int compareTo(Node node) {
		return this.key.compareTo((MyKey)((EntryNode)node).getValue());
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof EntryNode)
			return ((EntryNode) other).key.equals(key);
		return false;
	}
}
