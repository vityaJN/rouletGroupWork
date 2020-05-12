import java.util.HashMap;
import java.util.Map;

public class Casino {

    protected int ballPosition;
    private static final int MAXBET = 100000;
    private static final int MINBET = 10;


    Map<Integer, String> ballPositionOnTheTable = new HashMap<>();

    public Casino() {
        for (int i = 0; i < 36; i++) {
            ballPositionOnTheTable.put(i, i % 2 == 0 ? "Black" : "Red");
        }
        ballPositionOnTheTable.put(0, "White");




    }


}
