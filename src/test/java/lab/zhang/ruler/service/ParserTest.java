package lab.zhang.ruler.service;

import lab.zhang.ruler.pojo.IndexContext;
import lab.zhang.ruler.pojo.Operation;
import lab.zhang.ruler.pojo.Token;
import lab.zhang.ruler.pojo.operands.instants.BoolInstant;
import lab.zhang.ruler.pojo.operands.instants.IntInstant;
import lab.zhang.ruler.pojo.operands.variables.BoolVariable;
import lab.zhang.ruler.pojo.operands.variables.IntVariable;
import lab.zhang.ruler.pojo.operations.SortedOperation;
import lab.zhang.ruler.pojo.operations.UnsortedOperation;
import lab.zhang.ruler.pojo.operators.SortableOperator;
import lab.zhang.ruler.pojo.operators.UnsortableOperator;
import lab.zhang.ruler.pojo.operators.arithmetics.Addition;
import lab.zhang.ruler.pojo.operators.comparators.GreaterThan;
import lab.zhang.ruler.pojo.operators.logics.LogicalEqualTo;
import lab.zhang.ruler.pojo.operators.logics.LogicalOr;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class ParserTest {

    private Lexer lexer;
    private Parser parser;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Before
    public void setUp() {
        lexer = new Lexer();
        parser = new Parser();
    }

    @Test
    public void test_generate_operand() {
        String inputCond = "{\"name\":\"在【赠礼】名单中\",\"type\":10,\"value\":\"isInGiftNamelist\"}";
        Token token = lexer.fromJson(inputCond);
        BoolVariable generated = (BoolVariable) parser.generate(token);
        assertNotNull(generated);

        BoolVariable created = new BoolVariable("isInGiftNamelist");
        assertEquals(generated, created);

        IndexContext indexContext = new IndexContext();
        indexContext.putIndex("isInGiftNamelist", false);
        assertFalse(generated.getValue(indexContext));
    }

    @Test
    public void test_generate_simpleOperation() {
        String inputCond = "{\"name\":\"=\",\"type\":30,\"value\":[{\"name\":\"在【赠礼】名单中\",\"type\":10,\"value\":\"isInGiftNamelist\"},{\"name\":\"真\",\"type\":0,\"value\":true}]}";
        Token token = lexer.fromJson(inputCond);
        Operation<Boolean, Boolean> generated = (Operation<Boolean, Boolean>) parser.generate(token);
        assertNotNull(generated);

        BoolVariable op1 = new BoolVariable("isInGiftNamelist");
        BoolInstant op2 = new BoolInstant(true);
        SortableOperator<Boolean, Boolean> tor = new LogicalEqualTo();
        SortedOperation<Boolean, Boolean> created = SortedOperation.getInstance(tor, Lists.list(op1, op2));
        assertEquals(generated, created);

        IndexContext indexContext = new IndexContext();
        indexContext.putIndex("isInGiftNamelist", true);
        assertTrue(generated.getValue(indexContext));
        indexContext.putIndex("isInGiftNamelist", false);
        assertFalse(generated.getValue(indexContext));
    }

    @Test
    public void test_generate_sortedOperation() {
        String inputCond = "{\"name\":\"+\",\"type\":20,\"value\":[{\"name\":\"2\",\"type\":1,\"value\":2},{\"name\":\"1\",\"type\":1,\"value\":1}]}";
        Token token = lexer.fromJson(inputCond);
        Operation<Integer, Integer> generated = (Operation<Integer, Integer>) parser.generate(token);
        assertNotNull(generated);

        IntInstant op1 = new IntInstant(1);
        IntInstant op2 = new IntInstant(2);
        SortableOperator<Integer, Integer> tor = new Addition();
        SortedOperation<Integer, Integer> created = SortedOperation.getInstance(tor, Lists.list(op1, op2));
        assertEquals(generated, created);

        assertEquals(3, generated.getValue(null).intValue());
    }

    @Test
    public void test_generate_complexOperation() {
        String inputCond = "{\"name\":\"or\",\"type\":33,\"value\":[{\"name\":\"=\",\"type\":30,\"value\":[{\"name\":\"在【赠礼】名单中\",\"type\":10,\"value\":\"isInGiftNamelist\"},{\"name\":\"真\",\"type\":0,\"value\":true}]},{\"name\":\">\",\"type\":28,\"value\":[{\"name\":\"年龄\",\"type\":11,\"value\":\"age\"},{\"name\":\"18\",\"type\":1,\"value\":18}]}]}";
        Token token = lexer.fromJson(inputCond);
        Operation<Boolean, Boolean> generated = (Operation<Boolean, Boolean>) parser.generate(token);
        assertNotNull(generated);

        BoolVariable op11 = new BoolVariable("isInGiftNamelist");
        BoolInstant op12 = new BoolInstant(true);
        SortableOperator<Boolean, Boolean> tor1 = new LogicalEqualTo();
        SortedOperation<Boolean, Boolean> tion1 = SortedOperation.getInstance(tor1, Lists.list(op11, op12));
        IntVariable op21 = new IntVariable("age");
        IntInstant op22 = new IntInstant(18);
        UnsortableOperator<Boolean, Integer> tor2 = new GreaterThan();
        UnsortedOperation<Boolean, Integer> tion2 = UnsortedOperation.getInstance(tor2, Lists.list(op21, op22));
        SortableOperator<Boolean, Boolean> tor = new LogicalOr();
        SortedOperation<Boolean, Boolean> created = SortedOperation.getInstance(tor, Lists.list(tion1, tion2));
        assertEquals(generated, created);

        IndexContext indexContext = new IndexContext();
        indexContext.putIndex("isInGiftNamelist", true);
        indexContext.putIndex("age", 20);
        assertTrue(generated.getValue(indexContext));

        indexContext.putIndex("isInGiftNamelist", false);
        indexContext.putIndex("age", 20);
        assertTrue(generated.getValue(indexContext));

        indexContext.putIndex("isInGiftNamelist", false);
        indexContext.putIndex("age", 17);
        assertFalse(generated.getValue(indexContext));
    }
}
