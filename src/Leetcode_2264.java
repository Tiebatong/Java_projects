import java.util.ArrayList;

public class Leetcode_2264 {
    public static void main(String[] args) {

        String num = "1221000";

        ArrayList<String> list = new ArrayList<>();
        String substring = num.substring(0, 3);
        int i = 0;
        do {
            substring = num.substring(i, i + 3);
            if (substring.charAt(0) == substring.charAt(1) && substring.charAt(1) == substring.charAt(2)) {

                list.add(substring);
            }
            i++;
        } while (i < num.length() - 2);
        String solution = "";
        if (list.isEmpty()) {
            System.out.println("");;
        } else {
            solution = list.getFirst();
            for (int j = 1; j < list.size(); j++) {
                if(Integer.valueOf(solution) <  Integer.valueOf(list.get(j))) {
                    solution = list.get(j);
                }
            }
        }

        System.out.println(solution);
    }
}
