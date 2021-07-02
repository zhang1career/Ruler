package lab.zhang.ruler.service;

import lab.zhang.ruler.bo.Valuable;
import lab.zhang.ruler.pojo.Operand;
import lab.zhang.ruler.pojo.Operation;
import lab.zhang.ruler.pojo.Token;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    public Valuable<?> generate(Token token) {
        Valuable<?> material = token.getType().getMaterial();
        if (material instanceof Operand) {
            ((Operand) material).setValue(token.getValue());
            return material;
        }

        List<Valuable<?>> childrenValue = new ArrayList<>();
        for (Token childToken : (List<Token>) token.getValue()) {
            childrenValue.add(generate(childToken));
        }
        ((Operation) material).setOperands(childrenValue);

        return material;
    }
}
