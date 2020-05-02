package connectThree;

public class Test {
    public static void main(String [] args){
        Column testColumn = new Column(0,3);
        boolean result = testColumn.contains(2);
        System.out.println(result + "\n-----------------");
        testColumn.addPiece();
        testColumn.addPiece();
        testColumn.addPiece();
        testColumn.addPiece();
        testColumn.addPiece();

    }
}
