public class Leetcode_3446 {
    public static void main(String[] args) {
        int[][] grid = {
                {1,7,3},
                {9,8,2},
                {4,5,6}
        };

        int[] temp = new int[grid.length * grid.length];

        int i = 0;
        int j = grid.length - 1;
        int Zeile = grid.length - 1;
        int Reihe = 0;
        boolean sorted = true;

        int counter = 0;


        while (counter < 9) {
            temp[counter] = grid[i][j];
            counter++;

            if (i == grid.length - 1) { // untere Grenze
                Reihe++;
                i = Reihe;
                j = 0;
            } else if (j == grid.length - 1) { // rechte Grenze
                Zeile--;
                j = Zeile;
                i = 0;
            } else {
                i++;
                j++;
            }
        }

        for (int i1 : temp) {
            System.out.print(" " + i1);
        }


    }

    public int[] sort(int[] array) {

        boolean sorted = false;
        while (!sorted) {
            for (int i = 0; i < array.length; i++) {

            }
        }


        return array;
    }
}
