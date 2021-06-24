package lab.zhang.ruler.pojo.analyzers;

import lab.zhang.ruler.pojo.AnalysisContext;
import lab.zhang.ruler.pojo.IndexContext;
import lab.zhang.ruler.pojo.executors.SingleExecutor;
import lab.zhang.ruler.pojo.operands.instants.IntInstant;
import lab.zhang.ruler.pojo.operands.variables.IntVariable;
import lab.zhang.ruler.pojo.operations.SortedOperation;
import lab.zhang.ruler.pojo.operations.UnsortedOperation;
import lab.zhang.ruler.pojo.operators.*;
import lab.zhang.ruler.pojo.operators.arithmetics.Addition;
import lab.zhang.ruler.pojo.operators.arithmetics.Subtraction;
import org.assertj.core.util.Lists;
import org.junit.*;

import static org.junit.Assert.*;

public class IteratingAnalyzerTest {
    private final IteratingAnalyzer analyzer = new IteratingAnalyzer();

    private IndexContext indexContext;

    private final Addition add = new Addition();
    private final Subtraction sub = new Subtraction();
    private final GreaterThan gt = new GreaterThan();
    private final LogicalOr or = new LogicalOr();

    private IntVariable amount;
    private IntVariable age;

    IntInstant op0 = new IntInstant(0);
    IntInstant op1 = new IntInstant(1);
    IntInstant op17 = new IntInstant(17);
    IntInstant op18 = new IntInstant(18);
    IntInstant op100 = new IntInstant(100);

    @Before
    public void setUp() {
        indexContext = new IndexContext();
        indexContext.putIndex("amount", 90);
        indexContext.putIndex("age", 17);

        amount = new IntVariable("amount");
        age = new IntVariable("age");
    }

    @Test
    public void test_analyzer_fire() {
        SortedOperation<Integer, Integer> addOperation = SortedOperation.getInstance(add, Lists.list(op1, age));
        UnsortedOperation<Boolean, Integer> gtOperation1 = UnsortedOperation.getInstance(gt, Lists.list(addOperation, op18));
        UnsortedOperation<Integer, Integer> subOperation = UnsortedOperation.getInstance(sub, Lists.list(amount, op100));
        UnsortedOperation<Boolean, Integer> gtOperation2 = UnsortedOperation.getInstance(gt, Lists.list(subOperation, op0));
        SortedOperation<Boolean, Boolean> orOperation = SortedOperation.getInstance(or, Lists.list(gtOperation1, gtOperation2));

        AnalysisContext context = analyzer.fire(orOperation);

        System.out.println(context.getIndexMap());
        System.out.println(context.getOperationList());

        SingleExecutor<Boolean> exe = new SingleExecutor<>(context);
        assertFalse(exe.getValue(indexContext));
    }
}
