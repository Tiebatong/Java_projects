import java.util.ArrayList;
import java.util.List;

public class Leetcode_118 {
    public static void main(String[] args) {

        int numRows = 8;

        ArrayList<List<Integer>> list = new ArrayList<>();


        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> name = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    name.add(1);
                } else {
                    int c = (list.get(i - 1).get(j - 1)) + (list.get(i - 1).get(j));
                    name.add(j, c);
                }
            }
            list.add(name);
        }

        System.out.println(list);


    }
}
