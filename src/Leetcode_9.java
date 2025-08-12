public class Leetcode_9 {

    public static void main(String[] args) {

        int x = 12321;
        int counter = 0;
        char[] char_array = String.valueOf(x).toCharArray();
        int j = char_array.length - 1;
        for ( int i = 0; i < (char_array.length / 2); i++) {
            if ( char_array[i] == char_array[j]) {
                counter++;
            }
            j--;
        }
        if (counter == char_array.length) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }


    }
}
