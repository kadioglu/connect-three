package connectThree;

import comp127graphics.CanvasWindow;
import comp127graphics.GraphicsText;
import comp127graphics.ui.Button;


public class ConnectThree {
    private CanvasWindow canvas;
    private gameBoard board;
    private piecesManager piecesManager;
    private GraphicsText winMessage;
    private boolean gameWon = false;

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
        gamePlay();

    }

    /**
     * Adds a piece to the board when the user clicks on a valid location. Displays
     * a message and resets the game if the game has been won.
     */
    public void gamePlay() {
        canvas.onClick(event -> {pieces piece = piecesManager.addPiece(event.getPosition());
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
     * @param piece
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
        gamePlay();
    }

    public void addResetButton(){
        comp127graphics.ui.Button resetButton = new Button("Reset Game");
        resetButton.setPosition(437.5,467.5);
        canvas.add(resetButton);
        resetButton.onClick(this::reset);
    }

}