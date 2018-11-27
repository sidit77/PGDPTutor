
public class IntListElement {
	private int info;
	private IntListElement next;
	
	public IntListElement(int info) {
		this(info, null);
	}
	
	public IntListElement(int info, IntListElement next) {
		this.info = info;
		this.next = next;
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
}
