public class Leetcode_498 {
    public static void main(String[] args) {

        int[][] mat = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        int[] output = new int[mat.length * mat[0].length];
        int i = 0;
        int j = 0;
        boolean up = true;
        int counter = 0;

        while (counter < output.length) {

            while (up && counter < output.length) {
                output[counter] = mat[i][j];
                counter++;


                if (j == mat[0].length - 1) {
                    i++;
                    up = false;
                } else if (i == 0) {
                    j++;
                    up = false;
                } else {
                    i = i - 1;
                    j = j + 1;
                }

            }

            while (!up && counter < output.length) {
                output[counter] = mat[i][j];
                counter++;


                if (i == mat.length - 1 ) {
                    j++;
                    up = true;
                } else if (j == 0) {
                    i++;
                    up = true;

                } else {
                    i = i + 1;
                    j = j - 1;
                }

            }
        }


        for (int i1 : output) {
            System.out.print(i1 + " ");
        }




    }
}
