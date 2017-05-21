package chess;

import static java.lang.Math.abs;

public class Queen extends Piece {
    @Override
    public boolean canAttack(int x, int y) {
        //2,5 -> 2,3
        if(x < 0 || y < 0)
            throw new IllegalArgumentException();
        if(!(this.getX() == x && this.getY() == y) &&
                ((abs(this.getX() - x) ==  abs(this.getY() - y)) ||
                 (abs(this.getX() - x) == 0 && abs(this.getY() - y) > 0) ||
                    (abs(this.getX() - x) > 0 && abs(this.getY() - y) == 0)))
            return true;
        else
            return false;
    }

    @Override
    public Queen clone() {
        Queen cloneQueen = new Queen();
        cloneQueen.setPosition(this.getX(),this.getY());
        return cloneQueen;
    }


    @Override
    public int getValue() {
        return 9;
    }

    @Override
    public String getSymbol() {        
        return "Q";
    }
}
