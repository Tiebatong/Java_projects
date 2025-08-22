public class Leetcode_3195 {
    public static void main(String[] args) {
        int[][] grid = {
                {0,1,0},
                {0,0,1}
        };


        int left = 0;
        int right = 0;
        int top = 0;
        int bottom = 0;
        boolean bool = true;

        for (int i = 0; i < grid.length; i++) {
            if (!bool){
                break;
            }
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    top = i;
                    bool = false;
                    break;

                }
            }
        }
        bool = true;


        for (int i = grid.length - 1; i >= 0; i--) {
            if (!bool){
                break;
            }
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    bottom = i + 1;
                    bool = false;
                    break;

                }
            }
        }
        bool = true;

        for (int j = 0; j < grid[0].length; j++) {
            if (!bool){
                break;
            }
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][j] == 1) {
                    left = j;
                    bool = false;
                    break;

                }
            }
        }
        bool = true;

        for (int j = grid[0].length - 1; j >= 0; j--) {
            if (!bool){
                break;
            }
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][j] == 1) {
                    right = j + 1;
                    bool = false;
                    break;

                }
            }
        }
        bool = true;





        int x = right - left;
        int y = bottom - top;
        int z = x * y;
        System.out.println("left = " + left);
        System.out.println("right = " + right);
        System.out.println("top = " + top);
        System.out.println("bottom = " + bottom);
        System.out.println("Flächeninhalt = " + z);
    }
}
