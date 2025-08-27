public class Leetcode_array_converter {
    public static void main(String[] args) {
        String to_convert = "";

        StringBuilder sb = new StringBuilder(to_convert);
        for (int i = 0; i < to_convert.length(); i++) {
            if (to_convert.charAt(i) == '[') {
                sb.setCharAt(i, '{');
            } else if (to_convert.charAt(i) == ']') {
                sb.setCharAt(i, '}');
            } else {
                sb.setCharAt(i, to_convert.charAt(i));
            }
        }
        System.out.println(sb);
    }
}
