package lab.zhang.ruler.pojo.operands.variables;

import lab.zhang.ruler.pojo.IndexContext;
import lab.zhang.ruler.pojo.operands.instants.IntInstant;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class IntVariableTest {
    private IndexContext indexContext;
    private IntVariable amount;
    private IntVariable zero0;
    private IntVariable zero1;
    private IntVariable one;
    private IntVariable min;
    private IntVariable max;
    private IntInstant int0;

    @Before
    public void setUp() {
        indexContext = new IndexContext();

        indexContext.putIndex("amount", 1234);
        amount = new IntVariable("amount");

        indexContext.putIndex("zero", 0);
        zero0 = new IntVariable("zero");
        zero1 = new IntVariable("zero");

        indexContext.putIndex("one", 1);
        one = new IntVariable("one");

        indexContext.putIndex("min", Integer.MIN_VALUE);
        min = new IntVariable("min");

        indexContext.putIndex("max", Integer.MAX_VALUE);
        max = new IntVariable("max");

        int0 = new IntInstant(0);
    }

    @Test
    public void test_getValue() {
        assertEquals(1234, amount.getValue(indexContext).intValue());
        assertEquals(0, zero0.getValue(indexContext).intValue());
        assertEquals(Integer.MIN_VALUE, min.getValue(indexContext).intValue());
        assertEquals(Integer.MAX_VALUE, max.getValue(indexContext).intValue());
    }

    @Test
    public void test_compareTo_notEqual() {
        assertNotEquals(0, zero0.compareTo(one));
    }

    @Test
    public void test_compareTo_equal() {
        assertEquals(0, zero0.compareTo(zero1));
    }

    @Test
    public void test_compareTo_variableLessThanInstant() {
        assertEquals(-1, zero0.compareTo(int0));
        assertEquals(-1, one.compareTo(int0));
    }
}
