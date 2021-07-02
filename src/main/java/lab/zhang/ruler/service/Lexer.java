package lab.zhang.ruler.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import lab.zhang.ruler.exception.TokenizationException;
import lab.zhang.ruler.pojo.RulerType;
import lab.zhang.ruler.pojo.Token;
import org.jetbrains.annotations.NotNull;

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
        // check name
        if (token.getName() == null || "".equals(token.getName())) {
            throw new TokenizationException("The name is missing or empty");
        }
        // check type
        if (token.getType() == null) {
            throw new TokenizationException("The type is missing");
        }
        // check value
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
        // check children cardinality
        if (!token.getType().getCardinality().checkCard(childrenToken.size())) {
            throw new TokenizationException("The num of operands is wrong.");
        }
        // check children type
        List<RulerType> types = getRulerTypes(childrenToken);
        if (!token.getType().checkType(types)) {
            throw new TokenizationException("The type of operands is wrong.");
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

    @NotNull
    private List<RulerType> getRulerTypes(@NotNull List<Token> childrenToken) {
        List<RulerType> types = new ArrayList<>();
        for (Token childToken : childrenToken) {
            types.add(childToken.getType());
        }
        return types;
    }
}
