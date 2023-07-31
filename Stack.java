import java.util.ArrayList;

public class Stack<E> {
	
	ArrayList<E> elem = new ArrayList<E>();
	
	public boolean isEmpty() {
		return elem.isEmpty();
	}
	 
	public int getSize() {
		return elem.size();
	}
	
	public void push(E element) {
		elem.add(element);
		
	}
	
	public E pop() {
		if(elem.isEmpty()) {			
			return null;
		}
		else {
			return elem.remove(elem.size()-1);
		}
	}
	
	public E peek() {	
		if(elem.isEmpty()) return null;
		
		return elem.get(elem.size()-1);
	}

	
	public String toString() {
		
		return "" + elem + "";
	}
	
	
	
	
	
			
}
