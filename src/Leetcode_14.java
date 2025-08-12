public class Leetcode_14 {
    public static void main(String[] args) {

        String[] strs = {"flower","flow","flight"};
        String output;

        if (strs.length == 0) {
            output = "";
        } else {
            output = strs[0];
        }


        for (int i = 0; i < strs.length; i++) {

            while (!strs[i].startsWith(output)) {
                output = output.substring(0, output.length() -1);
            }


        }

        System.out.println(output);
    }
}
