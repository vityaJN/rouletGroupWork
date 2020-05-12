import java.util.HashMap;
import java.util.Map;

public class Casino {

    protected int ballPosition;
    private static final int MAXBET = 100000;
    private static final int MINBET = 10;


   static Map <Integer, String> ballPositionOnTheTable = new HashMap<>();

    public Casino() {

        for (int i = 1; i < 37; i++) {
            if (i > 1 && i < 11) {
                ballPositionOnTheTable.put(i, i % 2 == 0 ? "Fekete" : "Piros");
            } else if (i > 10 && i < 19) {
                ballPositionOnTheTable.put(i, i % 2 == 0 ? "Piros" : "Fekete");

            } else if (i > 18 && i < 29) {
                ballPositionOnTheTable.put(i, i % 2 == 0 ? "Fekete" : "Piros");

            } else {
                ballPositionOnTheTable.put(i, i % 2 == 0 ? "Piros" : "Fekete");
            }
        }
        ballPositionOnTheTable.put(0, "Fehér");



    }
}
