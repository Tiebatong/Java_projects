public class tmp {
    public static void main(String[] args) {
        int x = 2147483;
        int base = 1;
        int pow = 0;
        double approximation;
        while (pow <= x) {
            pow = (int) Math.pow(base, 2);
            base++;
        }
        base -= 2; // weil die while schleife zu oft drüber läuft
        double n = Math.pow(base + 1, 2) - x;
        double m = Math.pow(base, 2) - x;
        if (m < 0) {
            m *= -1;
        }
        if (n - x < m) {
            base += 1;
        }

        approximation =  base + (x - Math.pow(base, 2)) / (base * 2);
        System.out.println(approximation);
    }
}
