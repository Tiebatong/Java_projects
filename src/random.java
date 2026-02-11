public class random {
    public static void main() {


        int untere_grenze = 1;
        int obere_grenze = 6;

        System.out.println(dice_roll(untere_grenze, obere_grenze));




    }

    static int dice_roll(int untere_grenze, int obere_grenze) {
        return (int) (Math.random() * (obere_grenze + 1));
    }

}

