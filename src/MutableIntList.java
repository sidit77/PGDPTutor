
public class MutableIntList {
	
	private IntListElement start = null;
	private IntListElement end = null;
	
	public void append(int info) {
		if(start == null) {
			start = new IntListElement(info);
			end = start;
		}else {
			IntListElement current = start;
			while(current.getNext() != null)
				current = current.getNext();
			end = new IntListElement(info);
			current.setNext(end);
			end.setPrev(current);
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
			start.setPrev(null);
		}else {
			IntListElement current = start;
			while(pos > 1) {
				current = current.getNext();
				pos--;
			}
			current.setNext(current.getNext().getNext());
			if(current.getNext() != null)
				current.getNext().setPrev(current);
			else
				end = current;
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
		return end;
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
	
	public int[] toArray() {
		int counter = 0;
		IntListElement current = start;
		int[] array = new int[size()];
		while(current != null) {
			array[counter++] = current.getInfo();
			current = current.getNext();
		}
		return array;
	}
	
	public static MutableIntList fromArray(int[] intArray) {
		MutableIntList list = new MutableIntList();
		for(int i : intArray) {
			list.append(i);
		}
		return list;
	}
	
	public MutableIntList reverse() {
		MutableIntList list = new MutableIntList();
		IntListElement current = end;
		while(current != null) {
			list.append(current.getInfo());
			current = current.getPrev();
		}
		
		return list;
		//fromArray(invert(toArray()))
	}
	
	public MutableIntList reverse2() {
	    if (start == null)
	      return null;
	    IntListElement prev = null;
	    IntListElement tmp = start;
	    IntListElement tmp2 = null;
	    while (tmp != null) {
	      // Kopiere info
	      tmp2 = new IntListElement(tmp.getInfo());
	      // Next von Kopie is prev
	      tmp2.setNext(prev);
	      prev = tmp2;
	      tmp = tmp.getNext();
	    }
	    MutableIntList ret = new MutableIntList();
	    ret.start = tmp2;
	    return ret;
	  }
	
	private static int[] invert(int[] array) {
		int[] res = new int[array.length];
		for(int i = 0; i < array.length; i++) {
			res[array.length - 1 - i] = array[i];
		}
		return res;
	}
	
}
