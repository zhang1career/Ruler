package lab.zhang.ruler.repo;

import lab.zhang.ruler.model.operands.IntNumber;
import lab.zhang.ruler.model.operations.SortedOperation;
import lab.zhang.ruler.model.operators.Addition;
import lab.zhang.ruler.model.operators.SortableOperator;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;

public class LayerRepoTest {

    @Before
    public void setUp() {
    }

    @Test
    public void test_getValue() throws ExecutionException, InterruptedException {
        IntNumber op0 = new IntNumber(0);
        IntNumber op1 = new IntNumber(1);
        IntNumber op2 = new IntNumber(2);
        IntNumber op3 = new IntNumber(3);
        SortableOperator<Integer> tor = new Addition();
        SortedOperation<Integer> tion1 = SortedOperation.getInstance(tor, Lists.list(op0, op1));
        SortedOperation<Integer> tion2 = SortedOperation.getInstance(tor, Lists.list(op0, tion1));
        SortedOperation<Integer> tion3 = SortedOperation.getInstance(tor, Lists.list(op0, tion2));
        SortedOperation<Integer> tion4 = SortedOperation.getInstance(tor, Lists.list(op0, tion3));
        SortedOperation<Integer> tion5 = SortedOperation.getInstance(tor, Lists.list(op0, tion4));

        LayerRepo<Integer> layerRepo = new LayerRepo<>(tion5);
        assertEquals(1, layerRepo.getValue().intValue());
    }

    @Test
    public void test_calc_perf() throws ExecutionException, InterruptedException {
        int count = 1000;
        int depth = 250;

        IntNumber op1 = new IntNumber(1);
        SortableOperator<Integer> tor = new Addition();

        SortedOperation<Integer> tion2 = SortedOperation.getInstance(tor, Lists.list(op1, op1));
        SortedOperation<Integer> tion10 = SortedOperation.getInstance(tor, Lists.list(tion2, tion2, tion2, tion2, tion2));
        SortedOperation<Integer> tion50 = SortedOperation.getInstance(tor, Lists.list(tion10, tion10, tion10, tion10, tion10));
        SortedOperation<Integer> tion250 = SortedOperation.getInstance(tor, Lists.list(tion50, tion50, tion50, tion50, tion50));

        LayerRepo<Integer> layerRepo = new LayerRepo<>(tion250);
        long start = System.nanoTime();
        for (int i = 0; i < count; i++) {
            assertEquals(depth, layerRepo.getValue().intValue());
        }
        long end = System.nanoTime();
        long micro = (end - start) / 1000;
        System.out.println(micro);
    }
}
