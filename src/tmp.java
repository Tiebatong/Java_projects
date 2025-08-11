public class tmp {
    public static void main(String[] args) {
        int x = 8;
        int base = 1;
        int pow = 0;
        double aproximation;
        while (pow <= x) {
            pow = (int) Math.pow(base, 2);
            base++;
        }
        base -= 2; // weil die while schleife zu oft drüber läuft
        aproximation =  base + (x - Math.pow(base, 2)) / (base * 2);
        System.out.println(aproximation);
    }
}
