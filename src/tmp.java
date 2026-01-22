
public class tmp {
    public static void main() {

        Hash_Set set = new Hash_Set();
        System.out.println(set);
        Person p0 = new Person("David", "Mustermann");
        set.insert(p0);
        System.out.println(set);
        Person p1 = new Person("David", "Magnusen");
        set.insert(p1);
        System.out.println(set);
        //set.delete(p0);
        System.out.println(set.contains(p1));


    }
}
