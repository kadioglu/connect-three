package connectThree;

import comp127graphics.*;
import comp127graphics.Point;
import comp127graphics.Rectangle;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class gameBoard {
    private Rectangle rectangle;
    private GraphicsGroup board;
    private Ellipse space;
    private List<Ellipse> spaces;
    private Column first, second, third, fourth, fifth;
    private final int CUSHION = 10, SPACE = 75, BOARD_WIDTH = 435, BOARD_HEIGHT = 350;
    private final int FIRST_START = 0, FIRST_END = 3, SECOND_START = 4, SECOND_END = 7, THIRD_START = 8,
            THIRD_END = 11, FOURTH_START = 12, FOURTH_END = 15, FIFTH_START = 16, FIFTH_END = 19;

    private Rectangle playerStatus;
    private GraphicsText playerText;
    private Color playerColor = Color.red;
    private boolean state = true;

    /**
     * Creates a game board with 20 spaces and 5 columns.
     * @param positionX the x value upper left corner
     * @param positionY the y value of the upper left corner
     */
    public gameBoard(int positionX, int positionY){
        board = new GraphicsGroup();
        spaces = new ArrayList<>();
        rectangle = new Rectangle(positionX, positionY, BOARD_WIDTH, BOARD_HEIGHT);
        rectangle.setFillColor(Color.yellow);
        board.add(rectangle);
        for (int x=positionX+CUSHION; x<=BOARD_WIDTH; x+=SPACE+CUSHION){
            for(int y=positionY+CUSHION; y<=BOARD_HEIGHT; y+=SPACE+CUSHION) {
                space = new Ellipse(x, y, SPACE, SPACE);
                spaces.add(space);
                space.setFillColor(Color.white);
                board.add(space);
            }
        }
        first = new Column(FIRST_START, FIRST_END);
        second = new Column(SECOND_START, SECOND_END);
        third = new Column(THIRD_START, THIRD_END);
        fourth = new Column(FOURTH_START, FOURTH_END);
        fifth = new Column(FIFTH_START, FIFTH_END);

        addPlayerStatus();
    }

    /**
     * Adds the graphics group to the given canvas
     */
    public void addToCanvas(CanvasWindow canvas){
        canvas.add(board);
    }

    /**
     * Returns the (x, y) position of the space if the point is inside one of the spaces.
     * Returns null if the point is not inside a space.
     */
    public Point checkSpace(Point point){
        for (Ellipse space: spaces){
            if (space.testHit(point.getX(), point.getY())){
                return space.getPosition();
            }
        }
        return null;
    }

    /**
     * Returns the index of the position in the list for a given point. Returns -1 if the point is outside the list.
     *  0 4  8 12 16
     *  1 5  9 13 17
     *  2 6 10 14 18
     *  3 7 11 15 19
     */
    public int getSpacePosition(Point point){
        for (Ellipse space: spaces){
            if (space.testHit(point.getX(), point.getY())){
                return spaces.indexOf(space);
            }
        }
        return -1;
    }

    /**
     * Returns the coordinates of a space given its position in the grid of spaces
     */
    public Point getSpaceCoordinates(int position){
        Ellipse space = spaces.get(position);
        return new Point(space.getX(), space.getY());
    }

    /**
     * Finds the column that this position belongs to. Adds the piece to the column
     * and returns the lowest empty position
     */
    public int checkColumns(int position){
        if (first.contains(position)){
            return first.addPiece();
        }
        else if (second.contains(position)){
            return second.addPiece();
        }
        else if (third.contains(position)){
            return third.addPiece();
        }
        else if (fourth.contains(position)){
            return fourth.addPiece();
        }
        else if (fifth.contains(position)){
            return fifth.addPiece();
        }
        else {
            return -1;
        }
    }

    /**
     * Create a Rectangle and sets it to the player's color and also creates
     * a GraphicsText and adds both of the graphic objects to the board.
     */
    private void addPlayerStatus(){
        playerStatus = new Rectangle(35+BOARD_WIDTH/2,20,25,25);
        playerStatus.setFillColor(playerColor);
        playerText = new GraphicsText("Players turn!", 280,35);
        board.add(playerText);
        board.add(playerStatus);
    }

    /**
     * Takes on clicks from the given canvas and updates the boolean state
     * and sets the playerStatus object to the responding color.
     * @param canvas
     */
    public void updatePlayerStatus(CanvasWindow canvas){
        canvas.onClick(event -> {
            if (state) {
                state = false;
                playerColor = Color.blue;
            }
            else {
                state = true;
                playerColor = Color.red;
            }
            playerStatus.setFillColor(playerColor);
        });
    }






}