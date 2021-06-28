package lab.zhang.ruler.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.ValueFilter;
import lab.zhang.ruler.pojo.Ast;
import lab.zhang.ruler.pojo.RulerType;

import java.util.ArrayList;
import java.util.List;

import static com.alibaba.fastjson.JSON.toJSONString;

/**
 * @author zhangrj
 */
public class Lexer {
    
    public Ast fromJson(String cond) {
        if (cond == null || cond.length() <= 0) {
            return null;
        }

        Ast ast = JSON.parseObject(cond, Ast.class);
        if (ast.getValue() == null) {
            return ast;
        }
        if (!(ast.getValue() instanceof JSONArray)) {
            return ast;
        }

        List<Ast> childrenAst = new ArrayList<>();
        for (Object childCond : (JSONArray) ast.getValue()) {
            childrenAst.add(fromJson(childCond.toString()));
        }
        ast.setValue(childrenAst);

        return ast;
    }

    public String toJson(Ast ast) {
        return toJSONString(ast, Ast.getFilter());
    }
}