package oop.Expression;

public class Addition extends BinaryExpression{
    public Addition(Expression l, Expression r) {
        left = l;
        right = r;
    }
    public int evaluate() {
        return left.evaluate() + right.evaluate();
    }
    public String toString() {
        return left + "+" + right;
    }
}
