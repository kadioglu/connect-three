package connectThree;

import comp127graphics.CanvasWindow;
import comp127graphics.Ellipse;
import comp127graphics.Point;

import java.awt.*;

public class pieces {
    private Ellipse piece;
    private final int SPACE = 75;
    private Point nextPosition;


    public pieces(double posX, double posY, Color color){
        piece = new Ellipse(posX,posY,SPACE,SPACE);
        piece.setFillColor(color);
        nextPosition = new Point(0,0);
    }

    public void addToCanvas(CanvasWindow canvas){
        canvas.add(piece);
    }

    public void setMoveToPosition(Point point){
        nextPosition = point;
    }

    public void moveTo(){
        piece.setPosition(nextPosition);
    }

}