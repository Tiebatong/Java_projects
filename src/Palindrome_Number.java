public class Palindrome_Number {

    public static void main(String[] args) {

        int x = 12321;
        int int_length = String.valueOf(x).length();
        char[] char_array = String.valueOf(x).toCharArray();
        int [] int_array = new int[int_length];
        int [] int_array_reversed = new int[int_length];
        for(int i = 0; i < char_array.length; i++) {
            int_array[i] = Integer.parseInt(String.valueOf(char_array[i]));
            System.out.println(int_array[i]);
        }
        System.out.println(" ");
        int z = 0;
        for(int y = int_length - 1; y >= 0; y--) {
            int_array_reversed[z] = int_array[y];
            System.out.println(int_array_reversed[z]);
            z++;
        }
        for (int j = 0; j < int_length; j++) {
            if (int_array[j] == int_array_reversed[j]) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }


    }
}
