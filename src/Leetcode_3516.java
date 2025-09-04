public class Leetcode_3516 {
    public static void main(String[] args) {
        int x = 1;
        int y = 5;
        int z = 3;

        int x_distance = z - x;
        int y_distance = z - y;

        if (x_distance < 0) {
            x_distance *= -1;
        }
        if (y_distance < 0) {
            y_distance *= -1;
        }

        if (x_distance > y_distance) {
            System.out.println("2");
        } else if (x_distance < y_distance){
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
}
