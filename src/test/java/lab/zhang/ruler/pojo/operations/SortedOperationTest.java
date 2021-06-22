package lab.zhang.ruler.pojo.operations;

import lab.zhang.ruler.pojo.operands.IntInstant;
import lab.zhang.ruler.pojo.operators.Addition;
import lab.zhang.ruler.pojo.operators.SortableOperator;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SortedOperationTest {

    @Before
    public void setUp() {
    }

    @Test
    public void test_sortedOperationCompare_equal() {
        IntInstant op1 = new IntInstant(1);
        IntInstant op2 = new IntInstant(2);
        IntInstant op3 = new IntInstant(2);
        SortableOperator<Integer> tor = new Addition();
        SortedOperation<Integer> tion1 = SortedOperation.getInstance(tor, Lists.list(op1, op2));
        SortedOperation<Integer> tion2 = SortedOperation.getInstance(tor, Lists.list(op2, op1));
        SortedOperation<Integer> tion3 = SortedOperation.getInstance(tor, Lists.list(op1, op3));
        assertEquals(tion1, tion2);
        assertEquals(tion1, tion3);
    }

    @Test
    public void test_sortedOperationCompare_equal_maxInteger() {
        IntInstant op1 = new IntInstant(Integer.MIN_VALUE);
        IntInstant op2 = new IntInstant(Integer.MAX_VALUE);
        SortableOperator<Integer> tor = new Addition();
        SortedOperation<Integer> tion1 = SortedOperation.getInstance(tor, Lists.list(op1, op2));
        SortedOperation<Integer> tion2 = SortedOperation.getInstance(tor, Lists.list(op2, op1));
        assertEquals(tion1, tion2);
    }

    @Test
    public void test_sortedOperationCompare_notEqual() {
        IntInstant op1 = new IntInstant(1);
        IntInstant op2 = new IntInstant(2);
        IntInstant op3 = new IntInstant(3);
        SortableOperator<Integer> tor = new Addition();
        SortedOperation<Integer> tion1 = SortedOperation.getInstance(tor, Lists.list(op1, op2));
        SortedOperation<Integer> tion3 = SortedOperation.getInstance(tor, Lists.list(op1, op3));
        assertNotEquals(tion1, tion3);
    }
}
