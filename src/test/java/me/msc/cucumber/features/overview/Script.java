package me.msc.cucumber.features.overview;

/**
 * Created by jiachiliu on 3/17/15.
 */
public class Script {
    private Integer left;
    private Integer right;
    private String op;

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    @Override
    public String toString() {
        return String.format("%d %s %d", left, op, right);
    }
}
