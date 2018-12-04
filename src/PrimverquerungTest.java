import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.*;

import org.junit.Test;

public class PrimverquerungTest {
  @Test
  public void test25() {
    assertEquals(62, Primverquerung.querPrim(25));
  }
  
  @Test
  public void test89() {
    assertEquals(465, Primverquerung.querPrim(89));
  }
  
  @Test
  public void test122() {
    assertEquals(982, Primverquerung.querPrim(122));
  }
  
  @Test
  public void test5424() {
    assertEquals(845169, Primverquerung.querPrim(5424));
  }

  @Test
  public void testZeroNegative() {
    assertEquals(0, Primverquerung.querPrim(0));
    assertEquals(0, Primverquerung.querPrim(-10));
  }
  
  /**
  private static void assertEquals(int a, int b){
	  if(a != b) {
		  System.out.println("Test failed!");
	  }
  }**/
  
}
