package connectThree;

import comp127graphics.CanvasWindow;
import comp127graphics.Ellipse;
import comp127graphics.Point;
import comp127graphics.events.MouseButtonEvent;

import java.awt.*;
import java.awt.event.MouseEvent;


public class ConnectThree {
    CanvasWindow canvas;
    gameBoard board;
    piecesManager piecesManager;

    public ConnectThree(){
        canvas = new CanvasWindow("Connect Three", 550, 500);
        board = new gameBoard(50, 50);
        piecesManager = new piecesManager(board);
        board.addToCanvas(canvas);
        canvas.draw();
        canvas.onClick(event -> {pieces piece = piecesManager.addPiece(event.getPosition());
        if (piece != null) {
            piece.addToCanvas(canvas);
        }});
//        createPiece();
    }

    public static void main(String[] args){
        new ConnectThree();
    }

//    private void createPiece(){
//        canvas.onClick(e ->  {
//            pieces piece = new pieces(e.getPosition().getX()-37.5,e.getPosition().getY()-37.5,Color.blue);
//            piece.addToCanvas(canvas);
//        });
//
//    }
}