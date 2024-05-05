package oop.Expression;

import java.awt.*;

public class Square implements Expression {
    private Expression expression;
    public Square(Expression expression) {
        this.expression = expression;
    }
    @Override
    public int evaluate(){
        return expression.evaluate() * expression.evaluate();
    }
    @Override
    public String toString (){
        return expression + "^2";
    }
}
