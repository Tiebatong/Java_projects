public class Leetcode_69 {
    public static void main(String[] args) {
        int x = 17;
        float aproximation;
        int tmp;
        int base;
        int[] squares = {1, 4, 9, 16, 25, 36, 49, 64, 81, 100};
        int[] diff = new int[squares.length];

        for (int i = 0; i < squares.length; i++) {
            tmp = squares[i] - x;
            if (tmp < 0) {
                tmp*= -1;
            }
            diff[i] = tmp;
        }
        int index_closest = diff[0];
        for (int j = 0; j < squares.length; j++) {
            if (diff[j] < index_closest) {
                index_closest = diff[j];
                base = j;
            }
        }
        float numinator = x - squares[index_closest];
        float denominator = base * 2;

        aproximation = squares[index_closest] + numinator / denominator;
        System.out.println(aproximation);

    }
}
