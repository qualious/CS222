package chess;

import static java.lang.Math.abs;

public class King extends Piece {
    @Override
    public boolean canAttack(int x, int y) {
        //0,0 -> 1,0
        if(x < 0 || y < 0)
            throw new IllegalArgumentException();
        if(((abs(this.getX() - x) == 1 && abs(this.getY() - y) == 1))
                && !(this.getX() == x && this.getY() == y))
            return true;
        else
            return false;
    }

    @Override
    public King clone() {
        King cloneKing = new King();
        cloneKing.setPosition(this.getX(),this.getY());
        return cloneKing;
    }

    @Override
    public int getValue() {
        return 2;
    }

    @Override
    public String getSymbol() {
        return "K";
    }
}
