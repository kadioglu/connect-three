package connectThree;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String [] args){
//        Column testColumn = new Column(0,3);
//        boolean result = testColumn.contains(2);
//        System.out.println(result + "\n-----------------");
//        testColumn.addPiece();
//        testColumn.addPiece();
//        testColumn.addPiece();
//        testColumn.addPiece();
//        testColumn.addPiece();

        gameBoard board = new gameBoard(50,50);
        piecesManager manager = new piecesManager(board);

        List<Integer> player = new ArrayList<>();
        player.add(8);
        player.add(9);
        player.add(10);
        player.add(12);
//        boolean result = manager.checkWin(board.getSpaceCoordinates(10), player);
//        System.out.println(result);
    }
}