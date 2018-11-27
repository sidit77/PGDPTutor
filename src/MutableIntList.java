
public class MutableIntList {
	
	private IntListElement start = null;
	
	public void append(int info) {
		if(start == null) {
			start = new IntListElement(info);
		}else {
			IntListElement current = start;
			while(current.getNext() != null)
				current = current.getNext();
			current.setNext(new IntListElement(info));
		}
	}
	
	public int size() {
		int counter = 0;
		IntListElement current = start;
		while(current != null) {
			current = current.getNext();
			counter++;
		}
		return counter;
	}
	
	public boolean remove(int pos) {
		if(size() <= pos) {
			return false;
		}
		if(pos == 0) {
			start = start.getNext();
		}else {
			IntListElement current = start;
			while(pos > 1) {
				current = current.getNext();
				pos--;
			}
			current.setNext(current.getNext().getNext());
		}
		return true;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		IntListElement current = start;
		while(current != null) {
			sb.append(current.getInfo()).append(",");
			current = current.getNext();
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
	
	public int sum() {
		int sum = 0;
		IntListElement current = start;
		while(current != null) {
			sum += current.getInfo();
			current = current.getNext();
		}
		return sum;
	}

	public IntListElement getFirstElement() {
		return start;
	}
	
	public IntListElement getLastElement() {
		IntListElement current = start;
		while(current.getNext() != null) {
			current = current.getNext();
		}
		return current;
	}
	
	public MutableIntList copy() {
		MutableIntList copy = new MutableIntList();
		IntListElement current = start;
		while(current != null) {
			copy.append(current.getInfo());
			current = current.getNext();
		}
		return copy;
	}
	
	public IntListElement[] search(int intValue) {
		int counter = 0;
		IntListElement current = start;
		while(current != null) {
			if(current.getInfo() == intValue)
				counter++;
			current = current.getNext();
		}
		
		IntListElement[] array = new IntListElement[counter];
		counter = 0;
		current = start;
		while(current != null) {
			if(current.getInfo() == intValue)
				array[counter++] = current;
			current = current.getNext();
		}
		return array;
	}
	
}
