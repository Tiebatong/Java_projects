public class Leetcode_array_converter {
    public static void main(String[] args) {
        String to_convert = "[[6,2],[4,4],[2,6]]";


        String converted = to_convert.replace('[', '{').replace(']', '}');
        System.out.println(converted);
    }
}
