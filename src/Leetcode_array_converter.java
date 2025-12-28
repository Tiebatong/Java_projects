public class Leetcode_array_converter {
    public static void main(String[] args) {
        String to_convert = "[[3,2],[1,0]]";


        String converted = to_convert.replace('[', '{').replace(']', '}');
        System.out.println(converted);
    }
}
