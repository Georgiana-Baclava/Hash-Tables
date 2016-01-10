package list;

import map.MyValue;
import map.MyKey;

public class ValueList extends AbstractList {
	
	//public MyKey key;//constr gol
	protected ValueNode first;
    protected ValueNode last;
	public ValueNode node = new ValueNode();//tre constr gol
	
	public ValueList() {
		first = null;
		last = first;
	}

	public int size() {
		int count = 0;
		ValueNode current = first;
		while (current != null) {
			count++;
			current = current.getNext();
		}
		return count;
	}

	public ValueNode getFirstEqual(Object value) {
		ValueNode current = first;
		while (current != null) {
			if (current.value.equals(value))
				return current;
			current = current.getNext();
		}
		return null;
	}

	public ValueNode getSortedPosition(Object value) {
		ValueNode current = first;
		while (current != null) {
			if ((current.value.compareTo((MyValue) value) > 0)
					|| (current.value.compareTo((MyValue) value) == 0))
				return current;
			current = current.getNext();
		}
		return null;

	}

	public void insertBefore(Node node, Object value) {
		ValueNode newNode = new ValueNode((MyValue) value);
		newNode.setPrev(((ValueNode) node).getPrev());
		newNode.setNext((ValueNode) node);
		if (((ValueNode) node).getPrev() == null)
			first = newNode;
		else {
			ValueNode prev = ((ValueNode) node).getPrev();
			prev.setNext(newNode);
		}
		
		((ValueNode) node).setPrev(newNode);

	}

	public void add(Object value) {
		node = new ValueNode((MyValue) value);
		if (first == null) {
			first = node;
			last = first;
		} else {
			last.setNext(node);
			node.setPrev(last);
			node.setNext(null);
			last = node;
		}
		// size++;
	}


	public void remove(Node node) {
		if(((ValueNode)node).getNext() == null && ((ValueNode)node).getPrev() == null) {
			first = last = null;
			return;
		}
		if (((ValueNode) node).getNext() == null) {
			ValueNode prev = ((ValueNode) node).getPrev();
			prev.setNext(null);
			((ValueNode) node).setPrev(null);
			last = prev;
		} 
		else if (((ValueNode) node).getPrev() == null) {
			ValueNode next = ((ValueNode) node).getNext();
			next.setPrev(null);
			((ValueNode) node).setNext(null);
			first = next;
		} 
		else {
			ValueNode next = ((ValueNode) node).getNext();
			ValueNode prev = ((ValueNode) node).getPrev();
			prev.setNext(next);
			next.setPrev(prev);
			((ValueNode) node).setPrev(null);
			((ValueNode) node).setNext(null);
		}
		// size--;
	}

	public String toString() {
		System.out.println("a");
		String result = "";
		ValueNode current = first;
		if(current == null) {System.out.println("caca");
			return("null");}
		while(current != null) {
			result += "(" + current.value.getVal() + ", " + current.no + ") ";
			current = current.getNext();
		}
		return result;
	}
}
