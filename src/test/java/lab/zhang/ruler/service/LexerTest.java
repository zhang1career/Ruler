package lab.zhang.ruler.service;

import lab.zhang.ruler.pojo.Ast;
import org.junit.*;

import static org.junit.Assert.*;

public class LexerTest {

    private Lexer target;

    @Before
    public void setUp() {
        target = new Lexer();
    }

    @Test
    public void test_fromJson_cond_null() throws Exception {
        Ast ast = target.fromJson(null);
        assertNull(ast);
    }

    @Test
    public void test_fromJson_cond_empty() throws Exception {
        String inputCond = "";
        Ast ast = target.fromJson(inputCond);
        assertNull(ast);

        String outputCond = target.toJson(ast);
        assertNull(outputCond);
    }

    @Test
    public void test_fromJson_cond_simpleAst() throws Exception {
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
    public void test_fromJson_cond_combinationAst() throws Exception {
        String inputCond = "{\"name\":\">\",\"type\":28,\"value\":[{\"name\":\"年龄\",\"type\":11,\"value\":\"age\"},{\"name\":\"18\",\"type\":1,\"value\":18}]}";
        Ast ast = target.fromJson(inputCond);
        assertNotNull(ast);

        assertEquals(">", ast.getName());
        assertEquals(28, ast.getType().getId());

        String outputCond = target.toJson(ast);
        assertEquals(inputCond, outputCond);
    }


    @Test
    public void test_fromJson_cond_complexAst() throws Exception {
        String inputCond = "{\"name\":\"or\",\"type\":33,\"value\":[{\"name\":\"=\",\"type\":24,\"value\":[{\"name\":\"在【赠礼】名单中\",\"type\":10,\"value\":\"isInGiftNamelist\"},{\"name\":\"真\",\"type\":0,\"value\":true}]},{\"name\":\">\",\"type\":28,\"value\":[{\"name\":\"年龄\",\"type\":11,\"value\":\"age\"},{\"name\":\"18\",\"type\":1,\"value\":18}]}]}";
        Ast ast = target.fromJson(inputCond);
        assertNotNull(ast);

        String outputCond = target.toJson(ast);
        assertEquals(inputCond, outputCond);
    }
}
