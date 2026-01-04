public class tmp {
    public static void main(String[] args) {

    int upperLimit = 1_000_000_0;
    double start = System.currentTimeMillis();

    for (int i = 0; i <= upperLimit; i++) {
        System.out.println(i);
    }

    double end = System.currentTimeMillis();
        System.out.println("runtime: " + (end - start / 1000));


    }

}
