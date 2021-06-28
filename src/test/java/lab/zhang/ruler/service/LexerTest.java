package lab.zhang.ruler.service;

import lab.zhang.ruler.pojo.Ast;
import org.junit.*;
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
    public void test_fromJson_and_toJson_with_nullCond() {
        Ast ast = target.fromJson(null);
        assertNull(ast);
    }

    @Test
    public void test_fromJson_and_toJson_with_emptyCond() {
        String inputCond = "";
        Ast ast = target.fromJson(inputCond);
        assertNull(ast);

        String outputCond = target.toJson(ast);
        assertNull(outputCond);
    }

    @Test
    public void test_fromJson_and_toJson_with_simpleAstCond() {
        String inputCond = "{\"name\":\"在【赠礼】名单中\",\"type\":10,\"value\":\"isInGiftNamelist\"}";
        Ast ast = target.fromJson(inputCond);
        assertNotNull(ast);

        assertEquals("在【赠礼】名单中", ast.getName());
        assertEquals(10, ast.getType().getId());
        assertEquals("isInGiftNamelist", ast.getValue());

        String outputCond = target.toJson(ast);
        assertEquals(inputCond, outputCond);
    }

    @Test
    public void test_fromJson_and_toJson_with_combinationAstCond() {
        String inputCond = "{\"name\":\">\",\"type\":28,\"value\":[{\"name\":\"年龄\",\"type\":11,\"value\":\"age\"},{\"name\":\"18\",\"type\":1,\"value\":18}]}";
        Ast ast = target.fromJson(inputCond);
        assertNotNull(ast);

        assertEquals(">", ast.getName());
        assertEquals(28, ast.getType().getId());

        String outputCond = target.toJson(ast);
        assertEquals(inputCond, outputCond);
    }

    @Test
    public void test_fromJson_and_toJson_with_complexAstCond() {
        String inputCond = "{\"name\":\"or\",\"type\":33,\"value\":[{\"name\":\"=\",\"type\":24,\"value\":[{\"name\":\"在【赠礼】名单中\",\"type\":10,\"value\":\"isInGiftNamelist\"},{\"name\":\"真\",\"type\":0,\"value\":true}]},{\"name\":\">\",\"type\":28,\"value\":[{\"name\":\"年龄\",\"type\":11,\"value\":\"age\"},{\"name\":\"18\",\"type\":1,\"value\":18}]}]}";
        Ast ast = target.fromJson(inputCond);
        assertNotNull(ast);

        String outputCond = target.toJson(ast);
        assertEquals(inputCond, outputCond);
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
        Ast ast = target.fromJson(inputCond);
        assertNotNull(ast);
    }

    @Test
    public void test_fromJson_and_toJson_with_objectTypeCond() {
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("type does not exist");

        String inputCond = "{\"name\":\"在【赠礼】名单中\",\"type\":\"Integer.class\",\"value\":\"isInGiftNamelist\"}";
        Ast ast = target.fromJson(inputCond);
        assertNotNull(ast);
    }

    @Test
    public void test_fromJson_and_toJson_with_duplicateTypeCond() {
        String inputCond = "{\"name\":\"在【赠礼】名单中\",\"type\":1,\"type\":2,\"value\":\"isInGiftNamelist\"}";
        Ast ast = target.fromJson(inputCond);
        assertNotNull(ast);

        assertEquals("在【赠礼】名单中", ast.getName());
        assertEquals(2, ast.getType().getId());
        assertEquals("isInGiftNamelist", ast.getValue());

        String outputCond = target.toJson(ast);
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
