package connectThree;

import comp127graphics.CanvasWindow;
import comp127graphics.Ellipse;
import comp127graphics.Point;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class piecesManager {
    private boolean playerColor = true;
    private final Color PLAYER_1 = Color.RED, PLAYER_2 = Color.BLUE;
    private gameBoard board;
    private List<pieces> allPieces;
    private List<Integer> player1Pieces, player2Pieces;
    private final double SPACE = 85, Y_START = 0;



    public piecesManager(gameBoard board){
        this.board = board;
        allPieces = new ArrayList<>();
        player1Pieces = new ArrayList<>();
        player2Pieces = new ArrayList<>();
        for (int i = 0; i < 20; i ++){
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
        Point coordinates = board.checkSpace(point);
        pieces piece;
        if (coordinates != null){
            int numPosition = board.getSpacePosition(point);
            if (numPosition >= 0 && allPieces.get(numPosition) == null) {
                int columnPosition = board.checkColumns(numPosition);
                if (columnPosition >= 0) {
                    Point columnCoordinates = board.getSpaceCoordinates(columnPosition);
                    if (playerColor) {
                        piece = new pieces(columnCoordinates.getX(), Y_START, PLAYER_1);
                        piece.setMoveToPosition(columnCoordinates);
                        player1Pieces.add(columnPosition);
                        //System.out.println(checkWin(position, player1Pieces));
                        playerColor = false;
                    } else {
                        piece = new pieces(columnCoordinates.getX(), Y_START, PLAYER_2);
                        piece.setMoveToPosition(columnCoordinates);
                        player2Pieces.add(columnPosition);
                        //System.out.println(checkWin(position, player2Pieces));
                        playerColor = true;
                    }
                    allPieces.set(columnPosition, piece);
                    return piece;
                }
            }
        }
        return null;
    }

    /**
     * Checks all possible positions around the provided position to see if there are three
     * pieces, of that player's, in a row. Returns true if the game has been won and false if it hasn't.
     * @param position
     * @param playerPieces
     * @return
     */
    public boolean checkWin(Point position, List<Integer> playerPieces){
        List<Boolean> map = createMap(position, playerPieces);
        List<List<Integer>> testCombinations = List.of(List.of(0,1,2), List.of(1,2,3), List.of(2,3,4), List.of(5,6,2), List.of(6,2,7),
                List.of(2,7,8), List.of(9,10,2), List.of(10,2,11), List.of(2,11,12), List.of(13,14,2), List.of(14,2,15), List.of(2,15,16));
        for(List<Integer> positions: testCombinations){
            int pos1=positions.get(0), pos2=positions.get(1), pos3=positions.get(2);
            if (map.get(pos1) && map.get(pos2) && map.get(pos3)){
                return true;
            }
        }
        return false;
    }

    /**
     * Creates a list of boolean values for all possible positions around a point. The values are false if the
     * position doesn't exist or is not in the provided list of player pieces. The value is true if it is
     * in the player Pieces.
     * @param position
     * @param playerPieces
     * @return
     */
    public List<Boolean> createMap(Point position, List<Integer> playerPieces){
        List<Boolean> map = new ArrayList<>();
        for (int i = 0; i < 17; i ++){
            map.add(false);
        }
        List<Point> testPoints = List.of(new Point(0,-(SPACE*2)), new Point(0,-SPACE), new Point(0,0), new Point(0, SPACE), new Point(0,SPACE*2), //4
                new Point(-(SPACE * 2),-(SPACE * 2)), new Point(-SPACE, -SPACE), new Point(SPACE, SPACE), new Point(SPACE*2, SPACE*2), //8
                new Point(-(SPACE * 2),0), new Point(-SPACE,0), new Point(SPACE,0), new Point(SPACE * 2, 0), //12
                new Point(-(SPACE * 2),SPACE*2), new Point(-SPACE,SPACE), new Point(SPACE,-SPACE), new Point(SPACE*2,-(SPACE * 2))); //16
        for (Point point: testPoints){
            Point testPoint = new Point(position.getX() + point.getX() + SPACE/2, position.getY() + point.getY() + SPACE/2);
            if (board.getSpacePosition(testPoint) >=0) {
                if (playerPieces.contains(board.getSpacePosition(testPoint))){
                    map.set(testPoints.indexOf(point), true);
                }
            }
        }
        //System.out.println(map);
        return map;
    }

}