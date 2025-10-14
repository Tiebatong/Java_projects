import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class File_reader {
    public static void main(String[] args) throws IOException {

        String read_file_path = "C:\\Users\\Anwender\\Desktop\\alle_c_projekte\\Java_projekte\\github-intellij-test\\src\\read_file";
        String write_file_path = "C:\\Users\\Anwender\\Desktop\\alle_c_projekte\\Java_projekte\\github-intellij-test\\src\\write_file";

        File file = new File(read_file_path);
        Scanner scan = new Scanner(file);
        FileWriter writer = new FileWriter(write_file_path);

        int[] Bit_arr = {-128, 64, 32, 16, 8, 4, 2, 1};


        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            StringBuilder substring = new StringBuilder();
            ArrayList<String> Instruction_arr = new ArrayList<>();



            int i = 0;
            boolean line_end = false;
            while (!line_end) {

                int dec_Instruction = 0;

                if (line.charAt(i) == ' ' || line.charAt(i) == ';') { // String found
                    Instruction_arr.add(substring.toString());
                    substring.setLength(0);
                }

                if (line.charAt(i) == ';') { // end of line
                    line_end = true;
                    writer.write("\n");

                }
                if(line.charAt(i) != ' ') {
                    substring = substring.append(line.charAt(i));
                }

                i++;

                if(line_end) {
                    String mode = Instruction_arr.get(0);

                    switch (mode) {

                        case "Save":
                            dec_Instruction += Integer.parseInt(Instruction_arr.get(1));
                            break;

                        case "Move":
                            dec_Instruction += adress_decoder(Instruction_arr.get(1), true);
                            dec_Instruction += adress_decoder(Instruction_arr.get(3), false);
                            dec_Instruction += 64;
                            break;

                        case "Add":
                            dec_Instruction += -128;
                            dec_Instruction += adress_decoder(Instruction_arr.get(2), false);
                            break;

                        case "Sub":
                            dec_Instruction += -96; // -128 + 32 | 1010,0000
                            dec_Instruction += adress_decoder(Instruction_arr.get(2), false);
                            break; //
                    }
                    writer.write(hex(dec_Instruction));

                    break;

                }

            }

        }


        writer.close();

    }
    public static char[] hex(int x) {

        char[] hex_digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] hex = {' ', ' '};
        if (x < 0) {
            x = 256 + x; // twos complement
        }


        int i = 1;
        while (x > 0) {
            hex[i] = hex_digits[x % 16];
            x /= 16;
            i--;
        }


        return hex;
    }

    public static int adress_decoder(String adress_str, boolean read) {

        int adress = 0;
        int[] bin_arr = {0, 0, 0};
        int[] read_val = {32, 16, 8};
        int[] write_val = {4, 2, 1};
        String tmp = adress_str.charAt(3) + "";
        int adress_dec = Integer.parseInt(tmp);

        int j = 2;

        while(adress_dec > 0) {
            bin_arr[j] = adress_dec % 2;
            adress_dec /= 2;
            j--;
        }
        if (read) {
            for(int i = 0; i < 3; i++) {
                if(bin_arr[i] == 1) {
                    adress += read_val[i];
                }
            }
        } else {
            for(int i = 0; i < 3; i++) {
                if(bin_arr[i] == 1) {
                    adress += write_val[i];
                }
            }
        }

        return adress;
    }


}
