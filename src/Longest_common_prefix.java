public class Longest_common_prefix {
    public static void main(String[] args) {

        String[] strs = {"flower","flow","flight"};
        String output;

        if (strs.length == 0) {
            output = "";
        } else {
            output = strs[0];
        }


        for (int i = 0; i < strs.length; i++) {
            boolean weiter = true;
            while (weiter) {
                if (!strs[i].startsWith(output)) {
                    output = output.substring(0, output.length() -1);
                } else {
                    weiter = false;
                }
            }

        }

        System.out.println(output);
    }
}
