package lab.zhang.ruler.pojo.operands;

import lab.zhang.ruler.pojo.IndexContext;
import lab.zhang.ruler.pojo.operands.comparables.variables.IntVariable;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntVariableTest {
    private IndexContext indexContext;
    private IntVariable amount;
    private IntVariable zero;
    private IntVariable min;
    private IntVariable max;

    @Before
    public void setUp() {
        indexContext = new IndexContext();

        indexContext.putIndex("amount", 1234);
        amount = new IntVariable("amount");

        indexContext.putIndex("zero", 0);
        zero = new IntVariable("zero");

        indexContext.putIndex("min", Integer.MIN_VALUE);
        min = new IntVariable("min");

        indexContext.putIndex("max", Integer.MAX_VALUE);
        max = new IntVariable("max");
    }

    @Test
    public void test_getValue() {
        assertEquals(1234, amount.getValue(indexContext).intValue());
        assertEquals(0, zero.getValue(indexContext).intValue());
        assertEquals(Integer.MIN_VALUE, min.getValue(indexContext).intValue());
        assertEquals(Integer.MAX_VALUE, max.getValue(indexContext).intValue());
    }
}
