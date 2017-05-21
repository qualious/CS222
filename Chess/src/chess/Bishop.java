package chess;

import static java.lang.Math.abs;

public class Bishop extends Piece {
    @Override
    public boolean canAttack(int x, int y) {
        if(x < 0 || y < 0)
            throw new IllegalArgumentException();
        if(x >= 0 && y >= 0 && abs(this.getX() - x) == abs(this.getY() - y)
                && !(this.getX() == x && this.getY() == y))
            return true;
        else
            return false;
    }

    @Override
    public int getValue() {
        return 3;
    }

    @Override
    public Bishop clone() {
        Bishop cloneBishop = new Bishop();
        cloneBishop.setPosition(this.getX(),this.getY());
        return cloneBishop;
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}
