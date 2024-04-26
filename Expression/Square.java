package oop.Expression;

public class Square extends Expression{
    private Expression expression;
    public Square(Expression expression) {
        this.expression = expression;
    }
    @Override
    public int evaluate() {
        int e = expression.evaluate();
        return e * e;
    }
    @Override
    public String toString() {
        return expression.toString() + "^2";
    }
}
