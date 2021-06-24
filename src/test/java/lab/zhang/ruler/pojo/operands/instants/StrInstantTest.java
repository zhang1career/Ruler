package lab.zhang.ruler.pojo.operands.instants;

import lab.zhang.ruler.pojo.IndexContext;
import lab.zhang.ruler.pojo.operands.variables.StrVariable;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class StrInstantTest {
    private IndexContext indexContext;
    private StrVariable name;
    private StrVariable dummy;
    private StrInstant str00;
    private StrInstant str01;
    private StrInstant str10;
    private StrInstant str11;

    @Before
    public void setUp() {
        indexContext = new IndexContext();

        indexContext.putIndex("name", "达拉崩吧");
        name = new StrVariable("name");

        indexContext.putIndex("dummy", "");
        dummy = new StrVariable("dummy");

        str00 = new StrInstant("达拉崩吧");
        str01 = new StrInstant("达拉崩吧");
        str10 = new StrInstant("");
        str11 = new StrInstant("");
    }

    @Test
    public void test_getValue() {
        assertEquals("达拉崩吧", str00.getValue(indexContext));
        assertEquals("", str10.getValue(indexContext));
    }

    @Test
    public void test_compareTo_notEqual() {
        assertNotEquals(0, str00.compareTo(str10));
    }

    @Test
    public void test_compareTo_equal() {
        assertEquals(0, str00.compareTo(str01));
        assertEquals(0, str10.compareTo(str11));
    }

    @Test
    public void test_compareTo_instantGreaterThanVariable() {
        assertEquals(1, str00.compareTo(name));
        assertEquals(1, str00.compareTo(dummy));
        assertEquals(1, str10.compareTo(name));
        assertEquals(1, str10.compareTo(dummy));
    }
}
