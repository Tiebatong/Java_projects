import java.util.List;
import java.util.stream.Stream;

public class Streams_test {

    static void main() {
        List<String> wörter = List.of("hallo", "David", "random", "Ernst");
        Stream<String> stream = wörter.stream();
        System.out.println(stream);
    }
}
