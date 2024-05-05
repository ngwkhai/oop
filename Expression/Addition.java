package oop.Expression;

public class Addition implements BinaryExpression {
    private Expression left, right;
    public Addition(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
    @Override
    public Expression left(){
        return left;
    }
    @Override
    public Expression right(){
        return right;
    }
    @Override
    public int evaluate(){
        return left.evaluate() + right.evaluate();
    }
    public String toString(){
        return left.toString() + " + " + right.toString();
    }
}
