public class Progra_Übung {
    public static void main(String[] args) {

        Wahrheitstabelle();
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
}
