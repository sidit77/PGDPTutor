
public class IntListElement {
	private int info;
	private IntListElement next;
	private IntListElement prev;
	
	public IntListElement(int info) {
		this(info, null, null);
	}
	
	public IntListElement(int info, IntListElement next, IntListElement prev) {
		this.info = info;
		this.next = next;
		this.prev = prev;
	}
	public int getInfo() {
		return info;
	}
	public void setInfo(int info) {
		this.info = info;
	}
	public IntListElement getNext() {
		return next;
	}
	public void setNext(IntListElement next) {
		this.next = next;
	}

	public IntListElement getPrev() {
		return prev;
	}

	public void setPrev(IntListElement prev) {
		this.prev = prev;
	}
}
