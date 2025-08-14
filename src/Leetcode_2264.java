import java.util.ArrayList;

public class Leetcode_2264 {
    public static void main(String[] args) {

        String num = "11234534576";
        String solution = "";
        String substring = num.substring(0, 3);
        int i = 0;
        do {
            substring = num.substring(i, i + 3);
            if (substring.charAt(0) == substring.charAt(1) && substring.charAt(1) == substring.charAt(2)) {

                if (solution == "") {
                    solution = substring;
                } else if (Integer.valueOf(solution) < Integer.valueOf(substring)) {
                    solution = substring;
                }

            }
            i++;
        } while (i < num.length() - 2);

        System.out.println(solution);
    }
}
