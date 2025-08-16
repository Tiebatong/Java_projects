import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class tmp {
    public static void main(String[] args) {

        Map<String, Integer> mountains = new HashMap<>();
        mountains.put("Lothse", 8516);
        mountains.put("Kantsch", 8586);
        mountains.put("K2", 8610);
        mountains.put("Mount Everest", 8848);

        mountains.remove("K2");

        mountains.containsKey("Lothse");

        Set<String> keyset = mountains.keySet();
        for (String s : keyset) {
            System.out.println("Der " + s + "ist " + mountains.get(s) + " Meter hoch");
        }


    }
}
