package connectThree;

import comp127graphics.CanvasWindow;
import comp127graphics.GraphicsText;
import comp127graphics.Rectangle;
import comp127graphics.ui.Button;
import java.awt.*;

/**
 * Creates a runs a game of ConnectThree
 */
public class ConnectThree {
    private CanvasWindow canvas;
    private gameBoard board;
    private piecesManager piecesManager;
    private GraphicsText winMessage,blueText,redText;
    private boolean gameWon = false;
    private int redInt = 0,blueInt = 0;
    private pieces piece;

    /**
     * Creates an instance of the Connect Three game
     */
    public ConnectThree() {
        canvas = new CanvasWindow("Connect Three", 550, 500);
        board = new gameBoard(50, 50);
        piecesManager = new piecesManager(board);
        winMessage = new GraphicsText("    ", 200, 440);
        winMessage.setFontSize(30);
        canvas.add(winMessage);
        board.addToCanvas(canvas);

        canvas.draw();
        scoreKeeper();
        gamePlay();



    }

    /**
     * Adds a piece to the board when the user clicks on a valid location. Displays
     * a message and resets the game if the game has been won.
     */
    public void gamePlay() {
        canvas.onClick(event -> {piece = piecesManager.addPiece(event.getPosition());
            if (piece != null) {
                piece.addToCanvas(canvas);
                move(piece);
                gameWon = piecesManager.checkWin(piece);
                if (gameWon){
                    winMessage.setText("Game Won!!!");
                    winMessage.setFillColor(piece.getColor());
                    canvas.draw();
                    canvas.pause(3000);
                    reset();
                    addScore();
                }
            }});

        board.updatePlayerStatus(canvas);
        addResetButton();
    }

    public static void main(String[] args){
        new ConnectThree();
    }

    /**
     * Animates the piece so that it moves down toward its move to position.
     */
    public void move(pieces piece){
        double yCoordinate = piece.getPosition().getY();
        while(yCoordinate <= piece.getMoveToPosition().getY()){
            piece.setYPosition(yCoordinate);
            canvas.draw();
            yCoordinate += 3;
        }
    }

    /**
     * Clears the canvas and creates a new board and Pieces Manager. Then
     * resumes normal game play.
     */
    public void reset(){
        canvas.removeAll();
        board = new gameBoard(50, 50);
        piecesManager = new piecesManager(board);
        board.addToCanvas(canvas);
        winMessage.setText("     ");
        canvas.add(winMessage);
        canvas.draw();
        scoreKeeper();
        gamePlay();
    }

    /**
     * Adds the resetButton to the canvas and when you button is clicked
     * runs the method reset() to reset the game.
     */
    public void addResetButton(){
        comp127graphics.ui.Button resetButton = new Button("Reset Game");
        resetButton.setPosition(437.5,467.5);
        canvas.add(resetButton);
        resetButton.onClick(this::reset);
    }

    /**
     * Adds the scoreboard to keep track of how many times the
     * red player or blue player wins.
     */
    public void scoreKeeper(){
        comp127graphics.Rectangle redPlayer = new comp127graphics.Rectangle(10,10,15,15);
        redPlayer.setFillColor(Color.red);

        redText = new GraphicsText(String.valueOf(redInt),30,23.5);
        canvas.add(redText);

        comp127graphics.Rectangle bluePlayer = new Rectangle(90,10,15,15);
        bluePlayer.setFillColor(Color.blue);

        blueText = new GraphicsText(String.valueOf(blueInt),110,23.5);
        canvas.add(blueText);

        canvas.add(redPlayer);
        canvas.add(bluePlayer);
    }

    /**
     * Checks for the piece's color that wins if that piece wins then it adds
     * a point to the score of that piece's color and sets the text.
     */
    public void addScore(){
        if (piece.getColor() == Color.blue) {
            blueInt = blueInt + 1;
            blueText.setText(String.valueOf(blueInt));
        }
        else if (piece.getColor() == Color.red){
            redInt = redInt + 1;
            redText.setText(String.valueOf(redInt));
        }
    }
}