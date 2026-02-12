public class PascalTriangle {
    static void main() {
        System.out.println(p(3, 2));
    }

    static int p(int z, int s) {
        if (s > 0 && z > 0) {
            return p(z - 1, s - 1) + p(z - 1, s);
        } else {
            return 1;
        }
    }
}
