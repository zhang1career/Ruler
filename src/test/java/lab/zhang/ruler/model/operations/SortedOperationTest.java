package lab.zhang.ruler.model.operations;

import lab.zhang.ruler.model.operands.IntNumber;
import lab.zhang.ruler.model.operators.Addition;
import lab.zhang.ruler.model.operators.SortableOperator;
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
        IntNumber op1 = new IntNumber(1);
        IntNumber op2 = new IntNumber(2);
        IntNumber op3 = new IntNumber(2);
        SortableOperator<Integer> tor = new Addition();
        SortedOperation<Integer> tion1 = SortedOperation.getInstance(tor, Lists.list(op1, op2));
        SortedOperation<Integer> tion2 = SortedOperation.getInstance(tor, Lists.list(op2, op1));
        SortedOperation<Integer> tion3 = SortedOperation.getInstance(tor, Lists.list(op1, op3));
        assertEquals(tion1, tion2);
        assertEquals(tion1, tion3);
    }

    @Test
    public void test_sortedOperationCompare_equal_maxInteger() {
        IntNumber op1 = new IntNumber(Integer.MIN_VALUE);
        IntNumber op2 = new IntNumber(Integer.MAX_VALUE);
        SortableOperator<Integer> tor = new Addition();
        SortedOperation<Integer> tion1 = SortedOperation.getInstance(tor, Lists.list(op1, op2));
        SortedOperation<Integer> tion2 = SortedOperation.getInstance(tor, Lists.list(op2, op1));
        assertEquals(tion1, tion2);
    }

    @Test
    public void test_sortedOperationCompare_notEqual() {
        IntNumber op1 = new IntNumber(1);
        IntNumber op2 = new IntNumber(2);
        IntNumber op3 = new IntNumber(3);
        SortableOperator<Integer> tor = new Addition();
        SortedOperation<Integer> tion1 = SortedOperation.getInstance(tor, Lists.list(op1, op2));
        SortedOperation<Integer> tion3 = SortedOperation.getInstance(tor, Lists.list(op1, op3));
        assertNotEquals(tion1, tion3);
    }
}
