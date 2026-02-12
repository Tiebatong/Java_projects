public class PascalTriangle {
    static void main() {
        pascalTriangle(5);
    }

    static int p(int z, int s) {
        if (s == 0 || s == z) {
            return 1;
        } else {
            return p(z - 1, s - 1) + p(z - 1, s);
        }
    }

    static void pascalTriangle(int n) {

        for (int i = 1; i < n + 2; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(p(i - 1, j) + " ");
            }
            System.out.println();
        }
    }
}
