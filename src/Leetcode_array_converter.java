public class Leetcode_array_converter {
    public static void main(String[] args) {
        String to_convert = "[2,5,1,3,4,7]";


        String converted = to_convert.replace('[', '{').replace(']', '}');
        System.out.println(converted);
    }
}
