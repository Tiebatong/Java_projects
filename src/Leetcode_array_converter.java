public class Leetcode_array_converter {
    public static void main(String[] args) {
        String to_convert = "[[7,3,1,9],[3,4,6,9],[6,9,6,6],[9,5,8,5]]";


        String converted = to_convert.replace('[', '{').replace(']', '}');
        System.out.println(converted);
    }
}
