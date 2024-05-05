package oop.Expression;

public class Numeral implements Expression {
    private int value;
    public Numeral (int value) {
        this.value = value;
    }
    @Override
    public int evaluate(){
        return this.value;
    }
    @Override
    public String toString(){
        return value + "";
    }
}
