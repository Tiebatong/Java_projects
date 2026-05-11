
import java.util.List;
import java.util.stream.Collectors;

class tmp {
    List<String> words = List.of("fizz", "buzz");
    List<String> bus = words.stream()
            .filter(word -> word.startsWith("bu"))
            .map(String::toUpperCase)
            .collect(Collectors.toList());


}