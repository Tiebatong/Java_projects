public class Leetcode_array_converter {
    public static void main(String[] args) {
        String to_convert = "[[2,4],[3,9],[4,5],[2,10]]";

        String converted = to_convert.replace('[', '{').replace(']', '}');
        System.out.println(converted);
    }
}
