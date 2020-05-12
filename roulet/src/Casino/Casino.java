package Casino;

import java.util.HashMap;
import java.util.Map;

public class Casino {

    protected int ballPosition;
    public static final int MAX_BET = 100000;
    public static final int MIN_BET = 10;
    public static final int MIN_MONEY_TO_ENTER_CASINO = 200;

    Map<Integer, String> ballPositionOnTheTable = new HashMap<>();

    public Casino() {
        for (int i = 1; i < 37; i++) {
            if (i > 1 && i < 11) {
                ballPositionOnTheTable.put(i, i % 2 == 0 ? "Black" : "Red");
            } else if (i > 10 && i < 19) {
                ballPositionOnTheTable.put(i, i % 2 == 0 ? "Red" : "Black");

            } else if (i > 18 && i < 29) {
                ballPositionOnTheTable.put(i, i % 2 == 0 ? "Black" : "Red");

            } else {
                ballPositionOnTheTable.put(i, i % 2 == 0 ? "Red" : "Black");
            }
        }
        ballPositionOnTheTable.put(0, "White");
    }
}
