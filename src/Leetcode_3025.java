public class Leetcode_3025 {
    public static void main(String[] args) {

        int[][] points = {{6,2},{4,4},{2,6}};

        int rectangle_count = 0;

        boolean blocked = false;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {

                if (i == j) continue;

                if (points[i][0] <= points[j][0] && points[i][1] >= points[j][1]) {
                    blocked = false;
                    for (int k = 0; k < points.length; k++) {
                        if (k == i || k == j) continue;
                        if (points[k][0] <= points[j][0] && points[k][1] >= points[j][1] && points[k][0] >= points[i][0] && points[k][1] <= points[i][1]) {
                            blocked = true;
                        }
                    }
                    if (!blocked) {
                        rectangle_count++;
                    }
                }



            }

        }
        System.out.println(rectangle_count);
    }
}
