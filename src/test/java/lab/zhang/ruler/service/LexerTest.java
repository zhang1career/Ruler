package lab.zhang.ruler.service;

import lab.zhang.ruler.pojo.Token;
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


    @Test
    public void test_fromJson_with_wrongCard_expectUnaryGivenNone() {
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("num of operands is wrong");

        String inputCond = "{\"name\":\"!\",\"type\":34,\"value\":[]}";
        target.fromJson(inputCond);
    }

    @Test
    public void test_fromJson_with_wrongCard_expectUnaryGivenBinary() {
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("num of operands is wrong");

        String inputCond = "{\"name\":\"!\",\"type\":34,\"value\":[{\"name\":\"true\",\"type\":0,\"value\":true},{\"name\":\"false\",\"type\":0,\"value\":false}]}";
        target.fromJson(inputCond);
    }

    @Test
    public void test_fromJson_with_wrongCard_expectUnaryGivenMultinary() {
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("num of operands is wrong");

        String inputCond = "{\"name\":\"!\",\"type\":34,\"value\":[{\"name\":\"true\",\"type\":0,\"value\":true},{\"name\":\"false\",\"type\":0,\"value\":false},{\"name\":\"false\",\"type\":0,\"value\":false}]}";
        target.fromJson(inputCond);
    }

    @Test
    public void test_fromJson_with_wrongCard_expectBinaryGivenNone() {
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("num of operands is wrong");

        String inputCond = "{\"name\":\"-\",\"type\":21,\"value\":[]}";
        target.fromJson(inputCond);
    }

    @Test
    public void test_fromJson_with_wrongCard_expectBinaryGivenUnary() {
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("num of operands is wrong");

        String inputCond = "{\"name\":\"-\",\"type\":21,\"value\":[{\"name\":\"1\",\"type\":1,\"value\":1}]}";
        target.fromJson(inputCond);
    }

    @Test
    public void test_fromJson_with_wrongCard_expectBinaryGivenMultinary() {
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("num of operands is wrong");

        String inputCond = "{\"name\":\"-\",\"type\":21,\"value\":[{\"name\":\"1\",\"type\":1,\"value\":1},{\"name\":\"2\",\"type\":1,\"value\":2},{\"name\":\"3\",\"type\":1,\"value\":3}]}";
        target.fromJson(inputCond);
    }

    @Test
    public void test_fromJson_with_wrongCard_expectMultinaryGivenNone() {
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("num of operands is wrong");

        String inputCond = "{\"name\":\"+\",\"type\":20,\"value\":[]}";
        target.fromJson(inputCond);
    }

    @Test
    public void test_fromJson_with_wrongType() {
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("type of operands is wrong");

        String inputCond = "{\"name\":\"+\",\"type\":20,\"value\":[{\"name\":\"true\",\"type\":0,\"value\":true}]}";
        target.fromJson(inputCond);
    }
}
