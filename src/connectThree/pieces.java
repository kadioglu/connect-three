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
     * @param posX
     * @param posY
     * @param color
     */
    public pieces(double posX, double posY, Color color){
        piece = new Ellipse(posX,posY,SPACE,SPACE);
        piece.setFillColor(color);
        nextPosition = new Point(0,0);
        this.color = color;
    }

    /**
     * Adds the piece to the given canvas.
     * @param canvas
     */
    public void addToCanvas(CanvasWindow canvas){
        canvas.add(piece);
    }

    /**
     * Sets the nextPosition to the point.
     * @param point
     */
    public void setMoveToPosition(Point point){
        nextPosition = point;
    }

    /**
     * Returns the nextPosition.
     * @return
     */
    public Point getMoveToPosition(){
        return nextPosition;
    }

    /**
     * Sets the piece y position.
     * @param yValue
     */
    public void setYPosition(double yValue){
        piece.setPosition(piece.getX(), yValue);
    }

    /**
     * Returns the piece's position.
     * @return
     */
    public Point getPosition(){
        return piece.getPosition();
    }

    /**
     * Returns the piece's color.
     * @return
     */
    public Color getColor(){
        return color;
    }

}