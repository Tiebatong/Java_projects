public class Dec_to_Hex {
    public static void main(String[] args) {

        int x = -79;

        System.out.println(hex(x));

    }

    public static String hex(int x) {
        char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        char[] hex = {' ', ' '}; // 2 digits only

        StringBuilder sb = new StringBuilder();

        if ( x < 0) {
            int y = 128;
            int[] bin_digits = new int[8];
            for (int i = 0 ; i < 8; i++) { // create array with binary values: 128, 64, 32...
                bin_digits[i] = y;
                y /= 2;
            }
            x *= -1;
            int counter = 7;
            int[] binary_arr = new int[8];
            while (x > 0) {
                binary_arr[counter] = x % 2; // convert to binary
                x /= 2;
                counter--;
            }
            int twos_complement = 0;

            // twos complement, flip all bits
            for (int i = 0; i < 8; i++) {
                if (binary_arr[i] == 1) {
                    binary_arr[i] = 0;
                } else {
                    binary_arr[i] = 1;
                }
            }
            boolean one_added = false;
            //boolean leading_one = false;
            int index = 7;
            int step_counter = 0;
            while (!one_added) {
                if (binary_arr[index] == 0) {
                    binary_arr[index] = 1;
                    one_added = true;
                    for (int i = 0; i < step_counter; i++) {
                        binary_arr[i] = 0;
                    }
                } else {
                    step_counter++;
                }
            }



            // convert binary to Dec
            for (int i = 0; i < 8; i++) {
                if (binary_arr[i] == 1) {
                    x += digits[i];
                }
            }


        }

        int j = 1;
        while (x > 0) {
            int tmp = x % 16; // convert to hex
            hex[j] = digits[tmp];
            x /= 16;
            j--;
        }
        sb.append(hex[0]);
        sb.append(hex[1]);


        String hexa = sb.toString();

        return hexa;
    }

}


