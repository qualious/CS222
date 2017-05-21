// DO NOT CHANGE THIS CLASS. USE IT AS IT IS.

public class Square {
    private int topLeftRow;
    private int topLeftCol;
    private int sideLength;

    public Square(int topLeftRow, int topLeftCol, int sideLength) {
        this.topLeftRow = topLeftRow;
        this.topLeftCol = topLeftCol;
        this.sideLength = sideLength;
    }

    public int getTopLeftRow() {
        return topLeftRow;
    }

    public int getTopLeftCol() {
        return topLeftCol;
    }

    public int getSideLength() {
        return sideLength;
    }

    @Override
    public String toString() {
        return "Square of length " + sideLength +
                " @(" + topLeftRow + ", " + topLeftCol + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Square square = (Square) o;

        if (topLeftRow != square.topLeftRow) return false;
        if (topLeftCol != square.topLeftCol) return false;
        return sideLength == square.sideLength;
    }
}
