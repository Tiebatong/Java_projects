public class Leetcode_array_converter {
    public static void main(String[] args) {
        String to_convert = "[[0,0,0,0,0,1,0,0],[0,0,0,0,1,0,0,1],[0,0,0,0,1,0,0,0],[1,0,0,0,1,0,0,0],[0,0,1,1,0,0,0,0]]";
        String charArrToConvert = "\"a\",\"a\",\"b\",\"b\",\"c\",\"c\",\"c\"";

        String converted = to_convert.replace('[', '{').replace(']', '}');
        String charArrConverted = charArrToConvert.replace('[', '{').replace(']', '}').replace('"', '\'');
        System.out.println(converted);
        System.out.println(charArrConverted);
    }
}
