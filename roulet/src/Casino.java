import java.util.HashMap;
import java.util.Map;

public class Casino {

    Map<Integer, String> table = new HashMap<>();

    public Casino() {
        for (int i = 0; i < 36; i++) {
            table.put(i, i % 2 == 0?"Black":"Red");
        }
        table.put(0,"White");
    }
}
