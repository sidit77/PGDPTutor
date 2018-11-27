
public class TestT { // eig. Test

	public static void main(String[] ragsa) {
		MutableIntList list = new MutableIntList();
		assertTrue(list.size() == 0, "size() 1");
		for(int i : new int[] {1,2,3,4,5,6,7,8,9,10}) {
			list.append(i);
		}
		assertTrue(list.toString().equals("1,2,3,4,5,6,7,8,9,10"), "toString()");
		list.append(11);
		assertTrue(list.toString().equals("1,2,3,4,5,6,7,8,9,10,11"), "append()");
		assertTrue(list.size() == 11, "size() 2");
		
		list.remove(0);
		assertTrue(list.toString().equals("2,3,4,5,6,7,8,9,10,11"), "remove() 1");
		list.remove(5);
		assertTrue(list.toString().equals("2,3,4,5,6,8,9,10,11"), "remove() 2");
		list.remove(8);
		assertTrue(list.toString().equals("2,3,4,5,6,8,9,10"), "remove() 3");
		
		assertTrue(list.sum() == 47, "sum()");
		
		assertTrue(list.getFirstElement().getInfo() == 2, "getFirstElement()");
		assertTrue(list.getLastElement().getInfo() == 10, "getLastElement()");
		
		MutableIntList copy = list.copy();
		assertTrue(list.toString().equals(copy.toString()), "copy() 1");
		copy.remove(6);
		assertTrue(list.toString().equals("2,3,4,5,6,8,9,10"), "copy() 2");
		
		assertTrue(list.search(4).length == 1, "search() ");
	}
	
	public static void assertTrue(boolean b, String testcase) {
		if(!b)
			System.out.println("Error: " + testcase);
		else
			System.out.println("passed: " + testcase);
	}
	
}
