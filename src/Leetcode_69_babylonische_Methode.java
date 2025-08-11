public class Leetcode_69_babylonische_Methode {
    public static void main(String[] args) {
        /*
         babylonische Methode für Annäherung an Quadratwurzel
         https://www.youtube.com/watch?v=MXveVqBxFow&t=51s
         */

        int x = 8;
        float aproximation;
        int tmp;
        int base = 0;
        int[] squares = {1, 4, 9, 16, 25, 36, 49, 64, 81, 100};
        int[] diff = new int[squares.length];

        for (int i = 0; i < squares.length; i++) {
            tmp = squares[i] - x;
            if (tmp < 0) {
                tmp*= -1;
            }
            diff[i] = tmp;
        }
        int closest = diff[0];
        int index_closest = 0;
        for (int j = 0; j < squares.length; j++) {
            if (diff[j] < closest) {
                closest = diff[j];
                index_closest = j;
            }
        }

        float numinator = x - squares[index_closest];
        float denominator = (index_closest + 1) * 2;
        aproximation = (index_closest + 1) + (numinator / denominator);
        System.out.println(aproximation);


    }
}
