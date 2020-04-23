package connectThree;

import comp127graphics.CanvasWindow;
import comp127graphics.Ellipse;
import comp127graphics.GraphicsGroup;
import comp127graphics.Rectangle;

import java.awt.*;

public class gameBoard {
    Rectangle rectangle;
    GraphicsGroup board;
    Ellipse space;
    private final int CUSHION = 10, SPACE = 75, BOARD_WIDTH = 435, BOARD_HEIGHT = 350;

    public gameBoard(int positionX, int positionY){
        board = new GraphicsGroup();
        rectangle = new Rectangle(positionX, positionY, BOARD_WIDTH, BOARD_HEIGHT);
        rectangle.setFillColor(Color.yellow);
        board.add(rectangle);
        for (int x=positionX+CUSHION; x<=BOARD_WIDTH; x+=SPACE+CUSHION){
            for(int y=positionY+CUSHION; y<=BOARD_HEIGHT; y+=SPACE+CUSHION) {
                space = new Ellipse(x, y, SPACE, SPACE);
                space.setFillColor(Color.white);
                board.add(space);
            }
        }
    }

    public void addToCanvas(CanvasWindow canvas){
        canvas.add(board);
    }
}
