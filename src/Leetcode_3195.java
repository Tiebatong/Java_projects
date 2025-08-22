public class Leetcode_3195 {
    public static void main(String[] args) {
        int[][] grid = {
                {1,0},
                {0,0}
        };

        int left = 9999;
        int right = 0;
        int top = 9999;
        int bottom = 0;

        for (int i = 0; i < grid.length; i++) { //Höhe
            for (int j = 0; j < grid[0].length; j++) { // Breite
                if (grid[i][j] == 1 && j <= left) {
                    left = j;
                }
                if (grid[i][j] == 1 && j >= right) {
                    right = j;
                }
                if (grid[i][j] == 1 && i <= top) {
                    top = i;
                }
                if (grid[i][j] == 1 && i >= bottom) {
                    bottom = i;
                }
            }
        }
        right++;
        bottom++;
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
