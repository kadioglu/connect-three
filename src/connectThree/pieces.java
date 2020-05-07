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

    /**
     * Creates a piece at the given x and y coordinates and sets the color.
     */
    public pieces(double posX, double posY, Color color){
        piece = new Ellipse(posX,posY,SPACE,SPACE);
        piece.setFillColor(color);
        nextPosition = new Point(0,0);
        this.color = color;
    }

    /**
     * Adds the piece to the given canvas.
     */
    public void addToCanvas(CanvasWindow canvas){
        canvas.add(piece);
    }

    /**
     * Sets the nextPosition to the point.
     */
    public void setMoveToPosition(Point point){
        nextPosition = point;
    }

    /**
     * Returns the nextPosition.
     */
    public Point getMoveToPosition(){
        return nextPosition;
    }

    /**
     * Sets the piece's y position.
     */
    public void setYPosition(double yValue){
        piece.setPosition(piece.getX(), yValue);
    }

    /**
     * Returns the piece's position.
     */
    public Point getPosition(){
        return piece.getPosition();
    }

    /**
     * Returns the piece's color.
     */
    public Color getColor(){
        return color;
    }

}