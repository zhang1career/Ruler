package lab.zhang.ruler.pojo.executors;

import lab.zhang.ruler.pojo.AnalysisContext;
import lab.zhang.ruler.pojo.IndexContext;
import lab.zhang.ruler.pojo.analyzers.IteratingAnalyzer;
import lab.zhang.ruler.pojo.operands.instants.IntInstant;
import lab.zhang.ruler.pojo.operations.SortedOperation;
import lab.zhang.ruler.pojo.operations.UnsortedOperation;
import lab.zhang.ruler.pojo.operators.arithmetics.Addition;
import lab.zhang.ruler.pojo.operators.SortableOperator;
import lab.zhang.ruler.pojo.operators.arithmetics.Subtraction;
import lab.zhang.ruler.pojo.operators.UnsortableOperator;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SingleExecutorTest {

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
        IteratingAnalyzer analyzer = new IteratingAnalyzer();

        SortableOperator<Integer, Integer> tor1 = new Addition();
        SortedOperation<Integer, Integer> tion1 = SortedOperation.getInstance(tor1, Lists.list(op0, op1));
        SortedOperation<Integer, Integer> tion2 = SortedOperation.getInstance(tor1, Lists.list(op0, tion1));
        SortedOperation<Integer, Integer> tion3 = SortedOperation.getInstance(tor1, Lists.list(op0, tion2));
        SortedOperation<Integer, Integer> tion4 = SortedOperation.getInstance(tor1, Lists.list(op0, tion3));
        SortedOperation<Integer, Integer> tion5 = SortedOperation.getInstance(tor1, Lists.list(op0, tion4));
        AnalysisContext context1 = analyzer.fire(tion5);
        SingleExecutor<Integer> exe1 = new SingleExecutor<>(context1);
        assertEquals(1, exe1.getValue(indexContext).intValue());

        UnsortableOperator<Integer, Integer> tor2 = new Subtraction();
        UnsortedOperation<Integer, Integer> tion11 = UnsortedOperation.getInstance(tor2, Lists.list(op0, op1));
        AnalysisContext context11 = analyzer.fire(tion11);
        SingleExecutor<Integer> exe11 = new SingleExecutor<>(context11);
        assertEquals(-1, exe11.getValue(indexContext).intValue());


        UnsortedOperation<Integer, Integer> tion12 = UnsortedOperation.getInstance(tor2, Lists.list(op3, op2));
        AnalysisContext context12 = analyzer.fire(tion12);
        SingleExecutor<Integer> exe12 = new SingleExecutor<>(context12);
        assertEquals(1, exe12.getValue(indexContext).intValue());
    }

    @Test
    public void test_getValue_perf() {
        int count = 1000;
        int depth = 250;

        IntInstant op1 = new IntInstant(1);
        IndexContext indexContext = new IndexContext();
        IteratingAnalyzer analyzer = new IteratingAnalyzer();

        SortableOperator<Integer, Integer> tor = new Addition();
        SortedOperation<Integer, Integer> tion2 = SortedOperation.getInstance(tor, Lists.list(op1, op1));
        SortedOperation<Integer, Integer> tion10 = SortedOperation.getInstance(tor, Lists.list(tion2, tion2, tion2, tion2, tion2));
        SortedOperation<Integer, Integer> tion50 = SortedOperation.getInstance(tor, Lists.list(tion10, tion10, tion10, tion10, tion10));
        SortedOperation<Integer, Integer> tion250 = SortedOperation.getInstance(tor, Lists.list(tion50, tion50, tion50, tion50, tion50));
        AnalysisContext context250 = analyzer.fire(tion250);
        SingleExecutor<Integer> exe250 = new SingleExecutor<>(context250);

        long start = System.nanoTime();
        for (int i = 0; i < count; i++) {
            assertEquals(depth, exe250.getValue(indexContext).intValue());
        }
        long end = System.nanoTime();
        long milli = (end - start) / 1000000;
        System.out.println(milli);
    }
}
