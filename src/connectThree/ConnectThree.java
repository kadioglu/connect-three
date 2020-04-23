package connectThree;

import comp127graphics.CanvasWindow;

public class ConnectThree {
    CanvasWindow canvas;

    public ConnectThree(){
        canvas = new CanvasWindow("Connect Three", 200, 200);
    }

    public static void main(String[] args){
       new ConnectThree();
    }

}
