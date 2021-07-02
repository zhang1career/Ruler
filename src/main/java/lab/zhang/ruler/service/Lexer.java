package lab.zhang.ruler.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import lab.zhang.ruler.exception.TokenizationException;
import lab.zhang.ruler.pojo.Token;

import java.util.ArrayList;
import java.util.List;

import static com.alibaba.fastjson.JSON.toJSONString;

/**
 * @author zhangrj
 */
public class Lexer {

    public Token fromJson(String cond) {
        if (cond == null || cond.length() <= 0) {
            return null;
        }

        Token token = JSON.parseObject(cond, Token.class);
        // check
        if (token.getName() == null || "".equals(token.getName())) {
            throw new TokenizationException("The name is missing or empty");
        }
        if (token.getType() == null) {
            throw new TokenizationException("The type is missing");
        }

        if (token.getValue() == null) {
            return token;
        }
        if (!(token.getValue() instanceof JSONArray)) {
            return token;
        }

        List<Token> childrenToken = new ArrayList<>();
        for (Object childCond : (JSONArray) token.getValue()) {
            childrenToken.add(fromJson(childCond.toString()));
        }
        token.setValue(childrenToken);

        return token;
    }

    public String toJson(Token token) {
        if (token == null) {
            return null;
        }
        return toJSONString(token, lab.zhang.ruler.pojo.Token.getFilter());
    }
}
