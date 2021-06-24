package lab.zhang.ruler.pojo.readers;

import lab.zhang.ruler.pojo.IndexContext;
import lab.zhang.ruler.pojo.operands.variables.IntVariable;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IndexReaderTest {
    private IndexReader<Integer> target;

    private IndexContext indexContext;
    private IntVariable amount;
    private IntVariable amount1;

    @Before
    public void setUp() {
        target = new IndexReader<>();

        indexContext = new IndexContext();

        indexContext.putIndex("amount", 1234);
        amount = new IntVariable("amount");
        amount1 = new IntVariable("amount1");
    }

    @Test
    public void test_context_hit() {
        assertEquals(1234, target.read(amount.getValue(), indexContext).intValue());
    }

    @Test
    public void test_context_miss() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            target.read(amount1.getValue(), indexContext);
        });
        String expectedMessage = "Cannot find the index";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
