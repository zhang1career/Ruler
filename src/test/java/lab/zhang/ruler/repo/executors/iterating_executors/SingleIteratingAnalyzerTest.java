package lab.zhang.ruler.repo.executors.iterating_executors;

import lab.zhang.ruler.pojo.IndexContext;
import lab.zhang.ruler.pojo.executors.iterating_executors.SingleIteratingAnalyzer;
import lab.zhang.ruler.pojo.operands.IntInstant;
import lab.zhang.ruler.pojo.operations.SortedOperation;
import lab.zhang.ruler.pojo.operations.UnsortedOperation;
import lab.zhang.ruler.pojo.operators.Addition;
import lab.zhang.ruler.pojo.operators.SortableOperator;
import lab.zhang.ruler.pojo.operators.Subtraction;
import lab.zhang.ruler.pojo.operators.UnsortableOperator;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SingleIteratingAnalyzerTest {

    @Before
    public void setUp() {
    }

    @Test
    public void test_getValue() {
        IntInstant op0 = new IntInstant(0);
        IntInstant op1 = new IntInstant(1);
        IntInstant op2 = new IntInstant(2);
        IntInstant op3 = new IntInstant(3);
        IndexContext indexContext = new IndexContext();

        SortableOperator<Integer> tor1 = new Addition();
        SortedOperation<Integer> tion1 = SortedOperation.getInstance(tor1, Lists.list(op0, op1));
        SortedOperation<Integer> tion2 = SortedOperation.getInstance(tor1, Lists.list(op0, tion1));
        SortedOperation<Integer> tion3 = SortedOperation.getInstance(tor1, Lists.list(op0, tion2));
        SortedOperation<Integer> tion4 = SortedOperation.getInstance(tor1, Lists.list(op0, tion3));
        SortedOperation<Integer> tion5 = SortedOperation.getInstance(tor1, Lists.list(op0, tion4));
        SingleIteratingAnalyzer<Integer> exe1 = new SingleIteratingAnalyzer<>(tion5);
        assertEquals(1, exe1.getValue(indexContext).intValue());

        UnsortableOperator<Integer> tor2 = new Subtraction();
        UnsortedOperation<Integer> tion11 = UnsortedOperation.getInstance(tor2, Lists.list(op0, op1));
        UnsortedOperation<Integer> tion12 = UnsortedOperation.getInstance(tor2, Lists.list(op3, op2));
        SingleIteratingAnalyzer<Integer> exe11 = new SingleIteratingAnalyzer<>(tion11);
        SingleIteratingAnalyzer<Integer> exe12 = new SingleIteratingAnalyzer<>(tion12);
        assertEquals(-1, exe11.getValue(indexContext).intValue());
        assertEquals(1, exe12.getValue(indexContext).intValue());
    }

    @Test
    public void test_getValue_perf() {
        int count = 1000;
        int depth = 250;

        IntInstant op1 = new IntInstant(1);
        IndexContext indexContext = new IndexContext();

        SortableOperator<Integer> tor = new Addition();
        SortedOperation<Integer> tion2 = SortedOperation.getInstance(tor, Lists.list(op1, op1));
        SortedOperation<Integer> tion10 = SortedOperation.getInstance(tor, Lists.list(tion2, tion2, tion2, tion2, tion2));
        SortedOperation<Integer> tion50 = SortedOperation.getInstance(tor, Lists.list(tion10, tion10, tion10, tion10, tion10));
        SortedOperation<Integer> tion250 = SortedOperation.getInstance(tor, Lists.list(tion50, tion50, tion50, tion50, tion50));
        SingleIteratingAnalyzer<Integer> exe1 = new SingleIteratingAnalyzer<>(tion250);

        long start = System.nanoTime();
        for (int i = 0; i < count; i++) {
            assertEquals(depth, exe1.getValue(indexContext).intValue());
        }
        long end = System.nanoTime();
        long milli = (end - start) / 1000000;
        System.out.println(milli);
    }
}
