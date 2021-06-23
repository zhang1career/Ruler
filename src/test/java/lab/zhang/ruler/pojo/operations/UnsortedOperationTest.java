package lab.zhang.ruler.pojo.operations;

import lab.zhang.ruler.pojo.operands.comparables.instants.IntInstant;
import lab.zhang.ruler.pojo.operators.Subtraction;
import lab.zhang.ruler.pojo.operators.UnsortableOperator;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnsortedOperationTest {

    @Before
    public void setUp() {
    }

    @Test
    public void test_unsortedOperationCompare_equal() {
        IntInstant op1 = new IntInstant(1);
        IntInstant op2 = new IntInstant(2);
        IntInstant op3 = new IntInstant(2);
        UnsortableOperator<Integer, Integer> tor = new Subtraction();
        UnsortedOperation<Integer, Integer> tion1 = UnsortedOperation.getInstance(tor, Lists.list(op1, op2));
        UnsortedOperation<Integer, Integer> tion2 = UnsortedOperation.getInstance(tor, Lists.list(op2, op1));
        UnsortedOperation<Integer, Integer> tion3 = UnsortedOperation.getInstance(tor, Lists.list(op1, op3));
        assertNotEquals(tion1, tion2);
        assertEquals(tion1, tion3);
    }

    @Test
    public void test_unsortedOperationCompare_equal_maxInteger() {
        IntInstant op1 = new IntInstant(Integer.MIN_VALUE);
        IntInstant op2 = new IntInstant(Integer.MAX_VALUE);
        IntInstant op3 = new IntInstant(Integer.MAX_VALUE);
        UnsortableOperator<Integer, Integer> tor = new Subtraction();
        UnsortedOperation<Integer, Integer> tion1 = UnsortedOperation.getInstance(tor, Lists.list(op1, op2));
        UnsortedOperation<Integer, Integer> tion2 = UnsortedOperation.getInstance(tor, Lists.list(op1, op3));
        assertEquals(tion1, tion2);
    }

    @Test
    public void test_unsortedOperationCompare_notEqual() {
        IntInstant op1 = new IntInstant(1);
        IntInstant op2 = new IntInstant(2);
        IntInstant op3 = new IntInstant(3);
        UnsortableOperator<Integer, Integer> tor = new Subtraction();
        UnsortedOperation<Integer, Integer> tion1 = UnsortedOperation.getInstance(tor, Lists.list(op1, op2));
        UnsortedOperation<Integer, Integer> tion3 = UnsortedOperation.getInstance(tor, Lists.list(op1, op3));
        assertNotEquals(tion1, tion3);
    }
}
