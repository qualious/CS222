package chess;

public abstract class Piece {
    int x;
    int y;
    /**
     * Returns true if this piece can attack, that is, can move to,
     * the given destination. Otherwise returns false.
     * A piece cannot attack its own location.
     *
     * @param i the vertical coordinate of the proposed destination on board
     * @param j the horizontal coordinate of the proposed destination on board
     * @throws IllegalArgumentException if i or j is negative.
     */
    public abstract boolean canAttack(int i, int j);

    /**
     * @return the relative value of the piece
     */
    public abstract int getValue();

    /**
         * Sets the location of this piece to the cell at location x,y.
         *
         * @param x the vertical coordinate of the position
         * @param y the horizontal coordinate of the position
         * @throws IllegalArgumentException if x or y is negative.
         */
        public void setPosition(int x, int y) {
            if (x < 0 ||y < 0)
                throw new IllegalArgumentException();
            this.x = x;
            this.y = y;
        }

        /**
         * @return the vertical, that is, the x coordinate, of this piece.
         */
        public int getX() {
            return x;
        }

        /**
         * @return the horizontal, that is, the y coordinate, of this piece.
         */
        public int getY() {
            return y;
        }

        /**
         * @return the clone of this piece.
         */
        public Piece clone() {
            return this;
        }

        /**
         * @return a one-character String as the symbol of this piece.
         */
        public abstract String getSymbol();
}
