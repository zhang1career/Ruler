package lab.zhang.ruler.pojo.operands;

import lab.zhang.ruler.pojo.IndexContext;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class StrVariableTest {
    private IndexContext indexContext;
    private StrVariable name;
    private StrVariable dummy;

    @Before
    public void setUp() {
        indexContext = new IndexContext();

        indexContext.putIndex("name", "达拉崩吧");
        name = new StrVariable("name");

        indexContext.putIndex("dummy", "");
        dummy = new StrVariable("dummy");
    }

    @Test
    public void test_getValue() {
        assertEquals("达拉崩吧", name.getValue(indexContext));
        assertNotEquals("", name.getValue(indexContext));

        assertEquals("", dummy.getValue(indexContext));
        assertNotEquals("达拉崩吧", dummy.getValue(indexContext));
    }
}
