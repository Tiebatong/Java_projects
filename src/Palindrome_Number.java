public class Palindrome_Number {

    public static void main(String[] args) {

        int x = 12321;
        char[] char_array = String.valueOf(x).toCharArray();
        int [] int_array = new int[];
        for(int i = 0; i < char_array.length; i++) {
            int_array[i] = int.valueof(char_array[i]);
        }

        for(int j = 0; j < (String.valueOf(x).length() / 2); j++) {

        }
    }
}
