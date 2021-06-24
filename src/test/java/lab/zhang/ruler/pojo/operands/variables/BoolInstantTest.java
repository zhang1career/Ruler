package lab.zhang.ruler.pojo.operands.variables;

import lab.zhang.ruler.pojo.IndexContext;
import lab.zhang.ruler.pojo.operands.instants.BoolInstant;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BoolInstantTest {
    private IndexContext indexContext;
    private BoolVariable t0;
    private BoolVariable t1;
    private BoolVariable f0;
    private BoolVariable f1;
    private BoolInstant bool00;
    private BoolInstant bool01;
    private BoolInstant bool10;
    private BoolInstant bool11;

    @Before
    public void setUp() {
        indexContext = new IndexContext();

        indexContext.putIndex("true", true);
        t0 = new BoolVariable("true");
        t1 = new BoolVariable("true");

        indexContext.putIndex("false", false);
        f0 = new BoolVariable("false");
        f1 = new BoolVariable("false");

        bool00 = new BoolInstant(true);
        bool01 = new BoolInstant(true);
        bool10 = new BoolInstant(false);
        bool11 = new BoolInstant(false);
    }

    @Test
    public void test_getValue() {
        assertEquals(true, t0.getValue(indexContext));
        assertEquals(false, f0.getValue(indexContext));
    }

    @Test
    public void test_compareTo_notEqual() {
        assertNotEquals(0, t0.compareTo(bool00));
        assertNotEquals(0, t0.compareTo(bool01));
        assertNotEquals(0, t0.compareTo(bool10));
        assertNotEquals(0, t0.compareTo(bool11));

        assertNotEquals(0, f0.compareTo(bool00));
        assertNotEquals(0, f0.compareTo(bool01));
        assertNotEquals(0, f0.compareTo(bool10));
        assertNotEquals(0, f0.compareTo(bool11));

        assertNotEquals(0, t0.compareTo(f0));
        assertNotEquals(0, t0.compareTo(f1));
        assertNotEquals(0, t1.compareTo(f0));
        assertNotEquals(0, t1.compareTo(f1));
    }

    @Test
    public void test_compareTo_equal() {
        assertEquals(0, t0.compareTo(t1));
        assertEquals(0, f0.compareTo(f1));
    }

    @Test
    public void test_compareTo_variableLessThanInstant() {
        assertEquals(-1, t0.compareTo(bool00));
        assertEquals(-1, f0.compareTo(bool01));
    }
}
