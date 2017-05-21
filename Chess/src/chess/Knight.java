package chess;

import static java.lang.Math.abs;

public class Knight extends Piece {
    @Override
    public boolean canAttack(int x, int y) {
        if(x < 0 || y < 0)
            throw new IllegalArgumentException();
        int currentX = this.getX();
        int currentY = this.getY();
        if(x >= 0 && y >= 0
                && ((abs(currentX - x) == 2 &&  abs(currentY - y) == 1)
                    || (abs(currentX - x) == 1 &&  abs(currentY - y) == 2))
                && !(this.getX() == x && this.getY() == y))
            return true;
        else
            return false;
    }

    @Override
    public Knight clone() {
        Knight cloneKnight = new Knight();
        cloneKnight.setPosition(this.getX(),this.getY());
        return cloneKnight;
    }

    @Override
    public int getValue() {
        return 3;
    }

    @Override
    public String getSymbol() {
        return "N";
    }
}
