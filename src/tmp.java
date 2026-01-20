
public class tmp {
    public static void main(String[] args) {

        Hash_Set set = new Hash_Set();
        System.out.println(set);
        Person p0 = new Person("David", "Mustermann");
        set.insert(p0);
        System.out.println(set);
        set.insert(new Person("David", "Magnusen"));
        System.out.println(set);
        System.out.println(set.size());
        set.delete(p0);
        System.out.println(set.contains(p0));
        System.out.println(set.size());

    }
}
