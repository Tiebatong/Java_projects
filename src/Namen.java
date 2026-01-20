import java.util.LinkedList;
import java.util.Collections;
class Namen {
    static void main() {

        LinkedList<String> namen = new LinkedList<>();
        namen.add("Alex");
        namen.add("Kim");
        namen.add("Khoa");

        String name1 = namen.get(0);
        System.out.println(name1);
        System.out.println(namen.get(1));
        System.out.println(namen.get(2));
        System.out.println(namen);
        namen.remove("Kim");
        System.out.println(namen);
        namen.add(0, "David");
        System.out.println(namen);
        Collections.shuffle(namen);
        System.out.println(namen);
        Collections.sort(namen);
        System.out.println(namen);
    }
}
