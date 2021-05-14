import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class test 
{

    private StringCalculator calculator;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void initialize() 
    {
        calculator = new StringCalculator();
    }
    @Test
    public void emptyString0() 
    {
        assertEquals(calculator.add(""), 0);
    }
    @Test
    public void numberStringSameNumber() {
        assertEquals(calculator.add("1"), 1);
        assertEquals(calculator.add("5"), 5);
    }

    @Test
    public void numbersCommaDelimitedSummed() {
        assertEquals(calculator.add("1,2"), 3);
        assertEquals(25, calculator.add("10,15"));
    }

    @Test
    public void numbersNewlineDelimitedSummed() {
        assertEquals(calculator.add("1\n2"), 3);
        assertEquals(calculator.add("11\n13"), 24);
    }

    @Test
    public void threeNumbersDelimitedSummed() {
        assertEquals(calculator.add("1,2,3"), 6);
        assertEquals(calculator.add("5\n2\n3"), 10);
    }

    @Test
    public void negativeInputException() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Negative input!");
        calculator.add("-1");
        calculator.add("-5,10\n-15");
    }

    @Test
    public void GreaterThan1000() {
        assertEquals(calculator.add("5,12,1001"), 17);
        assertEquals(calculator.add("14124,22\n4,1214"), 26);
    }
}