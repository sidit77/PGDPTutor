package junit;

import org.junit.*;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class MapTest {

    private Fun<Integer, String> inttostr = i -> i.toString();

    private Integer[] eingabe;
    private String[] ausgabe;
    private String[] richtig;

    @Before
    public void prepare(){
        eingabe = IntStream.range(0, 10).map(i -> i * i).boxed().toArray(Integer[]::new);
        ausgabe = new String[eingabe.length];
        richtig = Arrays.stream(eingabe).map(i -> i.toString()).toArray(String[]::new);
    }

    @Test
    public void testResult() throws InterruptedException{
        Map.map(inttostr, eingabe, ausgabe, 5);
        assertArrayEquals("String to int ist falsch",richtig, ausgabe);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testToManyThreads() throws InterruptedException{
        Map.map(inttostr, null, ausgabe, 5);
        assertArrayEquals("String to int ist falsch",richtig, ausgabe);

    }

    @Test
    public void testStrToInt() throws InterruptedException{
        assertEquals("13", inttostr.apply(13));
    }

}
