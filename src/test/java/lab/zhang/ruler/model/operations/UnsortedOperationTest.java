package lab.zhang.ruler.model.operations;

import lab.zhang.ruler.model.operands.IntNumber;
import lab.zhang.ruler.model.operators.Subtraction;
import lab.zhang.ruler.model.operators.UnsortableOperator;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class UnsortedOperationTest {

    @Before
    public void setUp() {
    }

    @Test
    public void test_unsortedOperationCompare_equal() {
        IntNumber op1 = new IntNumber(1);
        IntNumber op2 = new IntNumber(2);
        IntNumber op3 = new IntNumber(2);
        UnsortableOperator<Integer> tor = new Subtraction();
        UnsortedOperation<Integer> tion1 = UnsortedOperation.getInstance(tor, Lists.list(op1, op2));
        UnsortedOperation<Integer> tion2 = UnsortedOperation.getInstance(tor, Lists.list(op2, op1));
        UnsortedOperation<Integer> tion3 = UnsortedOperation.getInstance(tor, Lists.list(op1, op3));
        assertNotEquals(tion1, tion2);
        assertEquals(tion1, tion3);
    }

    @Test
    public void test_unsortedOperationCompare_equal_maxInteger() {
        IntNumber op1 = new IntNumber(Integer.MIN_VALUE);
        IntNumber op2 = new IntNumber(Integer.MAX_VALUE);
        IntNumber op3 = new IntNumber(Integer.MAX_VALUE);
        UnsortableOperator<Integer> tor = new Subtraction();
        UnsortedOperation<Integer> tion1 = UnsortedOperation.getInstance(tor, Lists.list(op1, op2));
        UnsortedOperation<Integer> tion2 = UnsortedOperation.getInstance(tor, Lists.list(op1, op3));
        assertEquals(tion1, tion2);
    }

    @Test
    public void test_unsortedOperationCompare_notEqual() {
        IntNumber op1 = new IntNumber(1);
        IntNumber op2 = new IntNumber(2);
        IntNumber op3 = new IntNumber(3);
        UnsortableOperator<Integer> tor = new Subtraction();
        UnsortedOperation<Integer> tion1 = UnsortedOperation.getInstance(tor, Lists.list(op1, op2));
        UnsortedOperation<Integer> tion3 = UnsortedOperation.getInstance(tor, Lists.list(op1, op3));
        assertNotEquals(tion1, tion3);
    }
}
