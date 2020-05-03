package connectThree;

import comp127graphics.CanvasWindow;
import comp127graphics.Ellipse;
import comp127graphics.Point;

import java.awt.*;

public class pieces {
    private Ellipse piece;
    private final int SPACE = 75;
    private Point nextPosition;
    private Color color;


    public pieces(double posX, double posY, Color color){
        piece = new Ellipse(posX,posY,SPACE,SPACE);
        piece.setFillColor(color);
        nextPosition = new Point(0,0);
        this.color = color;
    }

    public void addToCanvas(CanvasWindow canvas){
        canvas.add(piece);
    }

    public void setMoveToPosition(Point point){
        nextPosition = point;
    }

    public Point getMoveToPosition(){
        return nextPosition;
    }

    public void setYPosition(double yValue){
        piece.setPosition(piece.getX(), yValue);
    }

    public Point getPosition(){
        return piece.getPosition();
    }

    public Color getColor(){
        return color;
    }

}