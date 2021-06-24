package lab.zhang.ruler.pojo.operands.instants;

import lab.zhang.ruler.pojo.IndexContext;
import lab.zhang.ruler.pojo.operands.variables.IntVariable;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class IntInstantTest {
    private IndexContext indexContext;
    private IntVariable zero;
    private IntVariable one;
    private IntInstant int00;
    private IntInstant int01;
    private IntInstant int1;

    @Before
    public void setUp() {
        indexContext = new IndexContext();

        indexContext.putIndex("zero", 0);
        zero = new IntVariable("zero");

        indexContext.putIndex("one", 1);
        one = new IntVariable("one");

        int00 = new IntInstant(0);
        int01 = new IntInstant(0);
        int1 = new IntInstant(1);
    }

    @Test
    public void test_getValue() {
        assertEquals(0, int00.getValue(indexContext).intValue());
        assertEquals(1, int1.getValue(indexContext).intValue());
    }

    @Test
    public void test_compareTo_notEqual() {
        assertNotEquals(0, int00.compareTo(int1));
    }

    @Test
    public void test_compareTo_equal() {
        assertEquals(0, int00.compareTo(int01));
    }

    @Test
    public void test_compareTo_instantGreaterThanVariable() {
        assertEquals(1, int00.compareTo(zero));
        assertEquals(1, int00.compareTo(one));
    }
}
