package chess;

public class Main {
    public static void main(String[] args) {
//        b.put(new Knight(), 2,3);
//        b.put(new Bishop(), 3,2);
//        b.put(new Queen(),2,5);
//        b.put(new King(), 4,4);
//        b.put(new Bishop(), 0,0);
//        b.put(new Queen(), 3,3);
//        b.put(new Queen(), 6,6);
//        System.out.println(b);
//
//        Reducer reducer = new Reducer(b);
//        reducer.reduceOnce();
//        System.out.println(reducer.getBoard());
//        System.out.println(reducer.getAccummulatedScore());
//        reducer.reduceOnce();
//        System.out.println(reducer.getBoard());
//        System.out.println(reducer.getAccummulatedScore());
//        b.removeLastPiece();
        Board b = new Board();
        Board b2 = new Board();
        b.put(new Bishop(),0,0);
        b2.put(new Bishop(),0,1);
        System.out.println(b.equals(b2));
//        DominationSolver dominationSolver = new DominationSolver();
//        Board board = dominationSolver.solve(11, new Queen());
//        if (board == null) {
//            System.out.println("No solution found.");
//        } else {
//            System.out.println("Solution found:");
//            System.out.println(board);
//        }
    }
}
