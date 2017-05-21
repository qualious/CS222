package chess;

import static java.lang.Math.abs;

public class Rook extends Piece {
    @Override
    public boolean canAttack(int x, int y) {
        if(x < 0 || y < 0)
            throw new IllegalArgumentException();
        if(x >= 0 && y >= 0
               &&((abs(this.getX() - x) == 0 && abs(this.getY() - y) > 0)
                   || (abs(this.getX() - x) > 0 && abs(this.getY() - y) == 0))
                && !(this.getX() == x && this.getY() == y))
            return true;
        else
            return false;
    }

    @Override
    public Rook clone() {
        Rook cloneRook = new Rook();
        cloneRook.setPosition(this.getX(),this.getY());
        return cloneRook;
    }

    @Override
    public int getValue() {
        return 5;
    }

    @Override
    public String getSymbol() {        
        return "R";
    }
}
