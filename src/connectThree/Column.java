package connectThree;

import java.util.*;

public class Column {
    private int firstPosition, lastPosition;
    private Map<Integer, Boolean> pieces;

    /**
     * Creates a column that starts with the first position and ends with the last position.
     * @param firstPosition
     * @param lastPosition
     */
    public Column(int firstPosition, int lastPosition){
        this.firstPosition = firstPosition;
        this.lastPosition = lastPosition;
        pieces = new HashMap<>();
        for (int i = firstPosition; i <= lastPosition; i++){
            pieces.put(i, false);
        }
    }

    /**
     * Checks if the position is within the positions covered by this column.
     * @param position
     * @return
     */
    public boolean contains(int position){
        return (position >= firstPosition && position <= lastPosition);
    }

    /**
     * Fills in the space and returns the position.
     * @return
     */
    public int addPiece(){
        int position = getOpenPosition();
        if (position >= 0) {
            pieces.put(position, true);
        }
        return position;
    }

    /**
     * Returns the lowest empty position. If the column is full, returns -1.
     * @return
     */
    public int getOpenPosition(){
        for (int i = lastPosition; i >= firstPosition; i--){
            boolean result = pieces.get(i);
            if (!result){
                return i;
            }
        }
        return -1;
    }

    public int getFirstPosition() {
        return firstPosition;
    }

    public int getLastPosition(){
        return lastPosition;
    }
}
