
public class tmp {
    public static void main() {


        BinTree tree = new BinTree();
        tree.insert(0);
        tree.insert(2);
        tree.insert(7);
        tree.insert(38);

        System.out.println(tree);



        tree.delete_min();
        System.out.println(tree);

    }
}
