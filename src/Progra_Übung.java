public class Progra_Übung {
    public static void main(String[] args) {

        //Wahrheitstabelle();
        int[] tmp = ziehung(6, 49);
        for (int z: tmp) {
            System.out.println(z);
        }
    }



    public static void Wahrheitstabelle() {
        for (int x1 = 0; x1 < 2; x1++) {
            for (int x2 = 0; x2 < 2; x2++) {
                for (int x3 = 0; x3 < 2; x3++) {

                    if ((x1 != 1 && x2 == 1 && x3 == 1) || (x1 == 1&& x2 != 1 && x3 == 1) || (x1 == 1 && x2 == 1&& x3 != 1) || (x1 == 1 && x2 == 1 && x3 == 1)) {
                        System.out.println(x1 + "|" + x2 + "|" + x3+ "|" + 1);
                    } else {
                        System.out.println(x1 + "|" + x2 + "|" + x3 + "|" + 0);
                    }
                }
            }
        }
    }

    public static int[] ziehung(int n, int m) {
        int[] Lotto_zahlen = new int[n];
        for (int i = 0; i < n; i++) {
            Lotto_zahlen[i] = (int) (Math.random() * m);

            for (int j = 0; j < i; j++) {
                if (Lotto_zahlen[i] == Lotto_zahlen[j]) {

                }
            }
        }
        return Lotto_zahlen;
    }
}
