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

public class LexerTest {

    private Lexer target;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Before
    public void setUp() {
        target = new Lexer();
    }

    @Test
    public void test_fromJson_with_nullCond() {
        Token token = target.fromJson(null);
        assertNull(token);
    }

    @Test
    public void test_fromJson_with_emptyCond() {
        String inputCond = "";
        Token token = target.fromJson(inputCond);
        assertNull(token);
    }

    @Test
    public void test_toJson_with_emptyCond() {
        String outputCond = target.toJson(null);
        assertNull(outputCond);
    }

    @Test
    public void test_fromJson_and_toJson_with_simpleAstCond() {
        String inputCond = "{\"name\":\"在【赠礼】名单中\",\"type\":10,\"value\":\"isInGiftNamelist\"}";
        Token token = target.fromJson(inputCond);
        assertNotNull(token);

        assertEquals("在【赠礼】名单中", token.getName());
        assertEquals(10, token.getType().getId());
        assertEquals("isInGiftNamelist", token.getValue());

        String outputCond = target.toJson(token);
        assertEquals(inputCond, outputCond);
    }

    @Test
    public void test_fromJson_and_toJson_with_combinationAstCond() {
        String inputCond = "{\"name\":\">\",\"type\":28,\"value\":[{\"name\":\"年龄\",\"type\":11,\"value\":\"age\"},{\"name\":\"18\",\"type\":1,\"value\":18}]}";
        Token token = target.fromJson(inputCond);
        assertNotNull(token);

        assertEquals(">", token.getName());
        assertEquals(28, token.getType().getId());

        String outputCond = target.toJson(token);
        assertEquals(inputCond, outputCond);
    }

    @Test
    public void test_fromJson_and_toJson_with_complexAstCond() {
        String inputCond = "{\"name\":\"or\",\"type\":33,\"value\":[{\"name\":\"=\",\"type\":30,\"value\":[{\"name\":\"在【赠礼】名单中\",\"type\":10,\"value\":\"isInGiftNamelist\"},{\"name\":\"真\",\"type\":0,\"value\":true}]},{\"name\":\">\",\"type\":28,\"value\":[{\"name\":\"年龄\",\"type\":11,\"value\":\"age\"},{\"name\":\"18\",\"type\":1,\"value\":18}]}]}";
        Token token = target.fromJson(inputCond);
        assertNotNull(token);

        String outputCond = target.toJson(token);
        assertEquals(inputCond, outputCond);
    }

    @Test
    public void test_fromJson_and_toJson_with_emptyNameCond() {
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("name is missing or empty");

        String inputCond = "{\"name\":\"\",\"type\":1,\"value\":\"isInGiftNamelist\"}";
        target.fromJson(inputCond);
    }

    @Test
    public void test_fromJson_and_toJson_with_nullNameCond() {
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("name is missing or empty");

        String inputCond = "{\"name\":null,\"type\":1,\"value\":\"isInGiftNamelist\"}";
        target.fromJson(inputCond);
    }

    @Test
    public void test_fromJson_and_toJson_with_nullTypeCond() {
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("set property error, type");

        String inputCond = "{\"name\":\"在【赠礼】名单中\",\"type\":null,\"value\":\"isInGiftNamelist\"}";
        target.fromJson(inputCond);
    }

    @Test
    public void test_fromJson_and_toJson_with_illegalTypeCond() {
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("value : -1");

        String inputCond = "{\"name\":\"在【赠礼】名单中\",\"type\":-1,\"value\":\"isInGiftNamelist\"}";
        target.fromJson(inputCond);
    }

    @Test
    public void test_fromJson_and_toJson_with_stringTypeCond() {
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("type does not exist");

        String inputCond = "{\"name\":\"在【赠礼】名单中\",\"type\":\"-1\",\"value\":\"isInGiftNamelist\"}";
        target.fromJson(inputCond);
    }

    @Test
    public void test_fromJson_and_toJson_with_emptyStringTypeCond() {
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("type does not exist");

        String inputCond = "{\"name\":\"在【赠礼】名单中\",\"type\":\"\",\"value\":\"isInGiftNamelist\"}";
        target.fromJson(inputCond);
    }

    @Test
    public void test_fromJson_and_toJson_with_floatTypeCond() {
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("value : 3.14");

        String inputCond = "{\"name\":\"在【赠礼】名单中\",\"type\":3.14,\"value\":\"isInGiftNamelist\"}";
        Token token = target.fromJson(inputCond);
        assertNotNull(token);
    }

    @Test
    public void test_fromJson_and_toJson_with_objectTypeCond() {
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("type does not exist");

        String inputCond = "{\"name\":\"在【赠礼】名单中\",\"type\":\"Integer.class\",\"value\":\"isInGiftNamelist\"}";
        Token token = target.fromJson(inputCond);
        assertNotNull(token);
    }

    @Test
    public void test_fromJson_and_toJson_with_duplicateTypeCond() {
        String inputCond = "{\"name\":\"在【赠礼】名单中\",\"type\":1,\"type\":2,\"value\":\"isInGiftNamelist\"}";
        Token token = target.fromJson(inputCond);
        assertNotNull(token);

        assertEquals("在【赠礼】名单中", token.getName());
        assertEquals(2, token.getType().getId());
        assertEquals("isInGiftNamelist", token.getValue());

        String outputCond = target.toJson(token);
        assertEquals("{\"name\":\"在【赠礼】名单中\",\"type\":2,\"value\":\"isInGiftNamelist\"}", outputCond);
    }

    @Test
    public void test_fromJson_and_toJson_without_typeCond() {
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("type is missing");

        String inputCond = "{\"name\":\"在【赠礼】名单中\",\"value\":\"isInGiftNamelist\"}";
        target.fromJson(inputCond);
    }
}
