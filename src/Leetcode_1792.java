import java.util.*;

public class Leetcode_1792 {
    public static void main(String[] args) {
        int[][] classes = {{2,4},{3,9},{4,5},{2,10}};
        int extraStudents = 4;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            double gainA = gain(a[0], a[1]);
            double gainB = gain(a[0], a[1]);
            return Double.compare(gainB, gainA);
        });

        for (int[] c : classes) {
            pq.add(c);
        }

        while (extraStudents > 0) {
            int[] best = pq.poll();
            best[0]++;
            best[1]++;
            pq.add(best);
            extraStudents--;
        }

        double pass = 0;
        for (int[] c : pq) {
            pass += (double) c[0] / c[1];
        }

        pass /= classes.length;
        System.out.println(pass);

    }
    private static double gain(int pass, int total) {
        return (double)(pass + 1) / (total + 1) - (double) pass / total;
    }
}
