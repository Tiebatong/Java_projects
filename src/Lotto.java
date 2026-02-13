public class Lotto {
    static void main() {

        int[] test_array = ziehung(19, 20);

        for (int zahl: test_array) {
            System.out.print(zahl + ", ");
        }
    }

    static int[] ziehung(int n, int m) {
        // n verschiedene zahlen > 0 && <= m
        int[] ziehung = new int[n];

        for (int i = 0; i < n; i++) {
            ziehung[i] = (int) (Math.random() * (m + 1));
            // auf dopplung und 0 prüfen
            for (int j = 0; j < i; j++) {
                if (ziehung[j] == ziehung[i] || ziehung[i] == 0) {
                    ziehung[i] = (int) (Math.random() * (m + 1));
                    j = -1;
                }
            }
        }


        return ziehung;
    }
}
