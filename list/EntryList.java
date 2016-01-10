package list;

import map.MyKey;

public class EntryList extends AbstractList{
	//public MyKey key;//constr gol
	protected EntryNode first;
    protected EntryNode last;
		public EntryNode node = new EntryNode();//tre constr gol
		
		public EntryList() {
			first = null;
			last = first;
		}

		public int size() {
			int count = 0;
			EntryNode current = first;
			while (current != null) {
				count++;
				current = current.getNext();
			}
			return count;
		}

		public EntryNode getFirstEqual(Object value) {
			EntryNode current = first;//ce pun?
			while (current != null) {
				if (current.key.equals(value))
					return current;
				current = current.getNext();
			}
			return null;
		}

		public EntryNode getSortedPosition(Object value) {
			//MyValue val = new MyValue();
			EntryNode current = (EntryNode) first;
			while (current != null) {
				if (current.key.compareTo((MyKey) value) > 0
						|| current.key.compareTo((MyKey) value) == 0)
					return current;
				current = current.getNext();
			}
			return null;

		}

		public void insertBefore(Node node, Object value) {
			EntryNode newNode = new EntryNode((MyKey) value);
			newNode.setPrev(((EntryNode) node).getPrev());
			newNode.setNext(((EntryNode) node));
			if (((EntryNode) node).getPrev() == null)
				first = newNode;
			else {
				EntryNode prev = ((EntryNode) node).getPrev();
				prev.setNext(newNode);
			}
			((EntryNode) node).setPrev(newNode);

		}

		public void add(Object value) {
			node = new EntryNode((MyKey)value);
			if (first == null) {
				first = node;
				last = first;//System.out.println("irene");
			} else {
				last.setNext(node);
				node.setPrev(last);
				node.setNext(null);
				last = node;
			}
			// size++;
		}
		

		public void remove(Node node) {
			if(((EntryNode)node).getNext() == null && ((EntryNode)node).getPrev() == null) {
				first = last = null;
				return;
			}
			if (((EntryNode)node).getNext() == null) {
				EntryNode prev = ((EntryNode)node).getPrev();
				prev.setNext(null);
				((EntryNode)node).setPrev(null);
				last = prev;
			} 
			else if (((EntryNode)node).getPrev() == null) {
				EntryNode next = ((EntryNode)node).getNext();
				next.setPrev(null);
				((EntryNode)node).setNext(null);
				first = next;
				System.out.println("aici");
			}
			else {
				EntryNode next = ((EntryNode)node).getNext();
				EntryNode prev = ((EntryNode)node).getPrev();
				prev.setNext(next);
				next.setPrev(prev);
				((EntryNode)node).setPrev(null);
				((EntryNode)node).setNext(null);
			}
			// size--;
		}

		public String toString() {
			String result = "";
			EntryNode current = first;
			if(current == null) 
				return("null");
			while(current != null) {
				result += "(" + current.key.getKey() + ") ";
				current = current.getNext();
			}
			return result;
		}
}
