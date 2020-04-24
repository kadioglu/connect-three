package connectThree;

import comp127graphics.Point;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class piecesManager {
    private boolean playerColor = true;
    private final Color PLAYER_1 = Color.RED, PLAYER_2 = Color.BLUE;
    private gameBoard board;
    private List<pieces> allPieces;



    public piecesManager(gameBoard board){
        this.board = board;
        allPieces = new ArrayList<>();
        for (int i = 0; i < 25; i ++){
            allPieces.add(null);
        }
    }

    /**
     * Adds a piece to the board at the selected position if the point is inside a space and if
     * a piece has not already been added to that spot. Adds that piece to the list of pieces at
     * the correct index according to what position it has (see position of spaces on gameboard).
     * @param point
     * @return
     */
    public pieces addPiece(Point point){
        Point position = board.checkSpace(point);
        pieces piece;
        if (position != null){
            int numPosition = board.getSpacePosition(point);
            if (numPosition >= 0 && allPieces.get(numPosition) == null) {
                if (playerColor) {
                    piece = new pieces(position.getX(), position.getY(), PLAYER_1);
                    playerColor = false;
                } else {
                    piece = new pieces(position.getX(), position.getY(), PLAYER_2);
                    playerColor = true;
                }
                allPieces.add(numPosition, piece);
                return piece;
            }
        }
        return null;
    }

}
