package lab.zhang.ruler.pojo.operands.instants;

import lab.zhang.ruler.pojo.IndexContext;
import lab.zhang.ruler.pojo.operands.variables.BoolVariable;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BoolInstantTest {
    private IndexContext indexContext;
    private BoolVariable t;
    private BoolVariable f;
    private BoolInstant bool00;
    private BoolInstant bool01;
    private BoolInstant bool10;
    private BoolInstant bool11;

    @Before
    public void setUp() {
        indexContext = new IndexContext();

        indexContext.putIndex("true", true);
        t = new BoolVariable("true");

        indexContext.putIndex("false", true);
        f = new BoolVariable("false");

        bool00 = new BoolInstant(true);
        bool01 = new BoolInstant(true);
        bool10 = new BoolInstant(false);
        bool11 = new BoolInstant(false);
    }

    @Test
    public void test_getValue() {
        assertEquals(true, bool00.getValue(indexContext));
        assertEquals(true, bool01.getValue(indexContext));
        assertEquals(false, bool10.getValue(indexContext));
        assertEquals(false, bool11.getValue(indexContext));
    }

    @Test
    public void test_compareTo_notEqual() {
        assertNotEquals(0, bool00.compareTo(t));
        assertNotEquals(0, bool01.compareTo(t));
        assertNotEquals(0, bool10.compareTo(t));
        assertNotEquals(0, bool11.compareTo(t));

        assertNotEquals(0, bool00.compareTo(f));
        assertNotEquals(0, bool01.compareTo(f));
        assertNotEquals(0, bool10.compareTo(f));
        assertNotEquals(0, bool11.compareTo(f));
    }

    @Test
    public void test_compareTo_equal() {
        assertEquals(0, bool00.compareTo(bool01));
        assertEquals(0, bool10.compareTo(bool11));
    }

    @Test
    public void test_compareTo_instantGreaterThanVariable() {
        assertEquals(1, bool00.compareTo(t));
        assertEquals(1, bool01.compareTo(t));
        assertEquals(1, bool10.compareTo(f));
        assertEquals(1, bool11.compareTo(f));
    }
}
