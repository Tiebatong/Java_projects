public class Dec_to_Hex {
    public static void main(String[] args) {

        char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        char[] hex = {' ', ' '}; // 2 digits only

        int x = -45; //TEMP

        if (x < 0) {
            x = binary(x);
        }

        StringBuilder sb = new StringBuilder();

        int j = 1;
        while (x > 0) {
            int tmp = x % 16;
            hex[j] = digits[tmp];
            x /= 16;
            j--;
        }
        sb.append(hex[0]);
        sb.append(hex[1]);

        System.out.println(sb);



    }

    public static int binary(int x) {


        int y = 128;
        int[] digits = new int[8];
        for (int i = 0 ; i < 8; i++) {
            digits[i] = y;
            y /= 2;
        }
        x *= -1;
        int counter = 7;
        int[] binary_arr = new int[8];
        while (x > 0) {
            binary_arr[counter] = x % 2;
            x /= 2;
            counter--;
        }
        int twos_complement = 0;

        for (int i = 0; i < 8; i++) {
            if (binary_arr[i] == 1) {
                binary_arr[i] = 0;
            } else {
                binary_arr[i] = 1;
            }
            twos_complement += digits[i];
        }


        return twos_complement;
    }
}
