package connectThree;

import comp127graphics.CanvasWindow;

public class ConnectThree {
    CanvasWindow canvas;
    gameBoard board;

    public ConnectThree(){
        canvas = new CanvasWindow("Connect Three", 550, 500);
        board = new gameBoard(50, 50);
        board.addToCanvas(canvas);
        canvas.draw();
    }

    public static void main(String[] args){
       new ConnectThree();
    }

}
