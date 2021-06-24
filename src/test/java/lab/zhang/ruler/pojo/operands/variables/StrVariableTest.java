package lab.zhang.ruler.pojo.operands.variables;

import lab.zhang.ruler.pojo.IndexContext;
import lab.zhang.ruler.pojo.operands.instants.StrInstant;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class StrVariableTest {
    private IndexContext indexContext;
    private StrVariable name0;
    private StrVariable name1;
    private StrVariable dummy0;
    private StrVariable dummy1;
    private StrInstant str0;
    private StrInstant str1;

    @Before
    public void setUp() {
        indexContext = new IndexContext();

        indexContext.putIndex("name", "达拉崩吧");
        name0 = new StrVariable("name");
        name1 = new StrVariable("name");

        indexContext.putIndex("dummy", "");
        dummy0 = new StrVariable("dummy");
        dummy1 = new StrVariable("dummy");

        str0 = new StrInstant("达拉崩吧");
        str1 = new StrInstant("");
    }

    @Test
    public void test_getValue() {
        assertEquals("达拉崩吧", name0.getValue(indexContext));
        assertEquals("", dummy0.getValue(indexContext));
    }

    @Test
    public void test_compareTo_notEqual() {
        assertNotEquals(0, name0.compareTo(dummy0));
    }

    @Test
    public void test_compareTo_equal() {
        assertEquals(0, name0.compareTo(name1));
        assertEquals(0, dummy0.compareTo(dummy1));
    }

    @Test
    public void test_compareTo_variableLessThanInstant() {
        assertEquals(-1, name0.compareTo(str0));
        assertEquals(-1, name0.compareTo(str1));
    }
}
