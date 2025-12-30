public class Leetcode_array_converter {
    public static void main(String[] args) {
        String to_convert = "[[3,2,9,2,7],[6,1,8,4,2],[7,5,3,2,7],[2,9,4,9,6],[4,3,8,2,5]]";


        String converted = to_convert.replace('[', '{').replace(']', '}');
        System.out.println(converted);
    }
}
