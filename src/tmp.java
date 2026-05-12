
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

record Lebensmittel(String name, boolean abgelaufen) {}

class tmp {
    static void main() {
        List<String> words = List.of("fizz", "buzz");
        List<String> bus = words.stream()
                .filter(word -> word.startsWith("bu"))
                .map(String::toUpperCase)
                .toList();

//        myGeneration(() -> 67)
//                .limit(10)
//                .forEach(System.out::println);

        Lebensmittel l1 = new Lebensmittel("Apfel", true);
        Lebensmittel l2 = new Lebensmittel("Banane", true);
        Lebensmittel l3 = new Lebensmittel("Milch", false);
        Lebensmittel l4 = new Lebensmittel("Butter", true);
        Lebensmittel l5 = new Lebensmittel("Brot", false);
        List<Lebensmittel> liste = new ArrayList<>();
        liste.add(l1);
        liste.add(l2);
        liste.add(l3);
        liste.add(l4);
        liste.add(l5);
        System.out.println(inventur(liste));
    }

    static List<Lebensmittel> inventur(List<Lebensmittel> list) {
        List<Lebensmittel> nicht_abgelaufen = list.stream()
                .filter(Predicate.not(Lebensmittel::abgelaufen))
                .toList();
        return nicht_abgelaufen;
    }

    static <T> Stream<T> myGeneration(Supplier<T> supplier) {
        return Stream.iterate(supplier.get(), x -> supplier.get());
    }


}