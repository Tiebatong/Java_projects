public class tmp {
    public static void main(String[] args) {






        LinkedList l = new LinkedList();
        l.prepend(3);
        l.prepend(4);
        l.prepend(5);
        LinkedList emptyList = new LinkedList();

        System.out.println(emptyList.indexOf(3));

        System.out.println(l);

        l.delete(5);
        l.delete(9);
        System.out.println(l);



    }

}
