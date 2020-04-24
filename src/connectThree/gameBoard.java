package connectThree;

import comp127graphics.CanvasWindow;
import comp127graphics.Ellipse;
import comp127graphics.GraphicsGroup;
import comp127graphics.Point;
import comp127graphics.Rectangle;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class gameBoard {
    Rectangle rectangle;
    GraphicsGroup board;
    Ellipse space;
    List<Ellipse> spaces;
    private final int CUSHION = 10, SPACE = 75, BOARD_WIDTH = 435, BOARD_HEIGHT = 350;

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
    }

    public void addToCanvas(CanvasWindow canvas){
        canvas.add(board);
    }

    /**
     * Returns the (x, y) position of the space if the point is inside one of the spaces.
     * Returns null if the point is not inside a space.
     * @param point
     * @return
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
     * Returns the index of the position in the list. Returns -1 if the point is outside the list.
     *  0 4  8 12 16
     *  1 5  9 13 17
     *  2 6 10 14 18
     *  3 7 11 15 19
     * @param point
     * @return
     */
    public int getSpacePosition(Point point){
        for (Ellipse space: spaces){
            if (space.testHit(point.getX(), point.getY())){
                return spaces.indexOf(space);
            }
        }
        return -1;
    }
}
