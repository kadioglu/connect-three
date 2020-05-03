package connectThree;

import comp127graphics.CanvasWindow;


public class ConnectThree {
    private CanvasWindow canvas;
    private gameBoard board;
    private piecesManager piecesManager;
    private boolean gameWon = false;

    public ConnectThree(){
        canvas = new CanvasWindow("Connect Three", 550, 500);
        board = new gameBoard(50, 50);
        piecesManager = new piecesManager(board);
        board.addToCanvas(canvas);
        canvas.draw();
        canvas.onClick(event -> {pieces piece = piecesManager.addPiece(event.getPosition());
            if (piece != null) {
                piece.addToCanvas(canvas);
                move(piece);
                gameWon = piecesManager.checkWin(piece);
                if (gameWon){
                    System.out.println("GameWon!");
                }
            }});
//        createPiece();

        board.updatePlayerStatus(canvas);
        board.addResetButton(canvas);


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

    }

//    private void createPiece(){
//        canvas.onClick(e ->  {
//            pieces piece = new pieces(e.getPosition().getX()-37.5,e.getPosition().getY()-37.5,Color.blue);
//            piece.addToCanvas(canvas);
//        });
//
//    }
