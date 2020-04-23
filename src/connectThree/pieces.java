package connectThree;

import comp127graphics.CanvasWindow;
import comp127graphics.Ellipse;

import java.awt.*;

public class pieces {
    Ellipse piece;
    private final int SPACE = 75;


public pieces(double posX, double posY, Color color){
    piece = new Ellipse(posX,posY,SPACE,SPACE);
    piece.setFillColor(color);
    }

    public void addToCanvas(CanvasWindow canvas){
        canvas.add(piece);
    }


}
