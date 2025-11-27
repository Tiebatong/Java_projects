public class tmp {
    public static void main(String[] args) {
        int x = 1;
        int total = 1;
        for (int i = 0; i < 15; i++) {
            x *= 2;
            total += x;
        }
        System.out.println(x);
        System.out.println(x + x - 1);
        System.out.println(total);

    }

}
