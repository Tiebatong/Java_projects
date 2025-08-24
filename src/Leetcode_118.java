import java.util.ArrayList;
import java.util.List;

public class Leetcode_118 {
    public static void main(String[] args) {

        int numRows = 15;

        ArrayList<List<Integer>> list = new ArrayList<>();



        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> name = new ArrayList<>();
            int x = i - 1;
            for (int j = 0; j <= i / 2; j++) {
                if (j == 0 || j == i / 2) {
                    name.add(1);
                } else {
                    int z = (list.get(i - 1).get(j - 1)) + (list.get(i - 1).get(j));
                    name.add(j, z);
                    name.add(x, z);
                    x++;
                }
            }
            list.add(name);
        }

        for (int i = 0; i < numRows; i++) {

            System.out.println(list.get(i));

        }


    }
}
