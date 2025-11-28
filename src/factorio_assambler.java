import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class factorio_assambler {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();


        String read_file_path;
        String write_file_path;

        if(System.getProperty("os.name").equals("Windows 11")) {
            read_file_path = "C:\\Users\\Anwender\\Desktop\\alle_c_projekte\\Java_projekte\\github-intellij-test\\src\\read_file.txt";
            write_file_path = "C:\\Users\\Anwender\\Desktop\\alle_c_projekte\\Java_projekte\\github-intellij-test\\src\\write_file.txt";
        } else {
            read_file_path = "/home/philip/Desktop/Java_projects/src/read_file.txt";
            write_file_path = "/home/philip/Desktop/Java_projects/src/write_file.txt";
        }


        File file = new File(read_file_path);
        Scanner scan = new Scanner(file);
        FileWriter writer = new FileWriter(write_file_path);


        int Instruct_counter = 0;
        boolean Flag_found = false;


        writer.write("v3.0 hex words plain\n");

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            StringBuilder substring = new StringBuilder();
            ArrayList<String> Instruction_arr = new ArrayList<>();
            boolean white_space_flag = false;


            // checks for empty lines or leading white space
            if (line.isEmpty()) {
                white_space_flag = true;

            } else if (line.charAt(0) == ' ') {
                white_space_flag = true;
            }
            // warning for white space
            if (white_space_flag) {
                Flag_found = true;
                System.out.print("\u001B[31mWarning at line \u001B[0m");
                System.out.print(Instruct_counter + 1);
                System.out.println("\u001B[31m: leading white space not allowed, assambler will skip line\u001B[0m");
                Instruct_counter++;
                continue;
            }


            int i = 0;
            boolean line_end = false;
            while (!line_end) {

                boolean Error_flag = false;
                int dec_Instruction = 0;

                if (line.charAt(i) == ' ' || line.charAt(i) == ';') { // String found
                    Instruction_arr.add(substring.toString());
                    substring.setLength(0);
                }

                if (line.charAt(i) == ';') { // end of line
                    line_end = true;


                }
                if(line.charAt(i) != ' ') {
                    substring = substring.append(line.charAt(i));
                }

                i++;


                if(line_end) {

                    String mode = Instruction_arr.get(0);

                    switch (mode) {

                        case "Save":
                            if(Integer.parseInt(Instruction_arr.get(1)) > 63) {
                                //warning for too large save value
                                Error_flag = true;
                                Flag_found = true;
                                System.out.print("\u001B[31mWarning at line \u001B[0m");
                                System.out.print(Instruct_counter + 1);
                                System.out.println("\u001B[31m: save value too big, needs to be <= 63\u001B[0m");
                            } else {
                                dec_Instruction += Integer.parseInt(Instruction_arr.get(1));
                            }
                            break;

                        case "Move":
                            dec_Instruction += address_decoder(Instruction_arr.get(1), true);
                            dec_Instruction += address_decoder(Instruction_arr.get(3), false);
                            dec_Instruction += 64;

                            // Warning for too large Reg Index
                            for(int x = 0; x < 2; x++) {
                                int Index = 1;
                                if(x == 1) {
                                    Index = 3;
                                }
                                String address = Instruction_arr.get(Index).charAt(3) + "";
                                int adr = Integer.parseInt(address);
                                if(adr > 7) {
                                    Error_flag = true;
                                    Flag_found = true;
                                    System.out.print("\u001B[31mWarning at line \u001B[0m");
                                    System.out.print(Instruct_counter + 1);
                                    System.out.println("\u001B[31m: address too big, needs to be <= 7\u001B[0m");
                                }
                            }

                            break;

                        case "Add":
                            dec_Instruction += 128;
                            dec_Instruction += address_decoder(Instruction_arr.get(2), false);
                            break;

                        case "Sub":
                            dec_Instruction += 128 + 32; // | 1010_0000
                            dec_Instruction += address_decoder(Instruction_arr.get(2), false);
                            break;

                        case "Comp>":
                            dec_Instruction +=  128 + 64;
                            if (Instruction_arr.get(1).equals("stc")) {
                                dec_Instruction++;
                            }
                            break;

                        case "Comp<":
                            dec_Instruction += 128 + 64 + 8;
                            if (Instruction_arr.get(1).equals("stc")) {
                                dec_Instruction++;
                            }
                            break;

                        case "Comp>=":
                            dec_Instruction += 128 + 64 + 16;
                            if (Instruction_arr.get(1).equals("stc")) {
                                dec_Instruction++;
                            }
                            break;

                        case "Comp<=":
                            dec_Instruction += 128 + 64 + 16 + 8;
                            if (Instruction_arr.get(1).equals("stc")) {
                                dec_Instruction++;
                            }
                            break;

                        case "Comp=":
                            dec_Instruction += 128 + 64 + 32;
                            if (Instruction_arr.get(1).equals("stc")) {
                                dec_Instruction++;
                            }
                            break;

                        case "Comp!=":
                            dec_Instruction += 128 + 64 + 32 + 8;
                            if (Instruction_arr.get(1).equals("stc")) {
                                dec_Instruction++;
                            }
                            break;

                        case ">>":
                            dec_Instruction += 136;
                            dec_Instruction += address_decoder(Instruction_arr.get(2), false);
                            break;

                        case "<<":
                            dec_Instruction += 144;
                            dec_Instruction += address_decoder(Instruction_arr.get(2), false);
                            break;

                    }

                    String dec_instruct_str = String.valueOf(dec_Instruction);
                    if(!Error_flag) {
                        if (Instruct_counter < 10) {
                            writer.write(" " + Instruct_counter + ": ");
                        } else {
                            writer.write(Instruct_counter + ": ");
                        }

                        if (dec_instruct_str.length() == 1) {
                            writer.write("  ");
                        } else if (dec_instruct_str.length() == 2) {
                            writer.write(" ");
                        }
                        writer.write(dec_instruct_str);

                    } else {
                        writer.write("XX");
                    }
                    Error_flag = false;
                    Instruct_counter++;
                    writer.write(" ");
                    if(Instruct_counter % 4 == 0) {
                        writer.write("\n");
                    }

                    break;

                }

            }


        }



        writer.close();

        if (!Flag_found) {
            System.out.println("\nAssambly finished with 0 Flags");
        }

        long end = System.currentTimeMillis();

        long run_time = end - start;
        System.out.println("run_time = " + run_time + " ms");

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
        if(i == 0) {
            hex[0] = '0';
        }


        return hex;
    }

    public static int address_decoder(String address_str, boolean read) {

        int address = 0;
        int[] bin_arr = {0, 0, 0};
        int[] read_val = {32, 16, 8};
        int[] write_val = {4, 2, 1};
        String tmp = address_str.charAt(3) + "";
        int address_dec = Integer.parseInt(tmp);

        int j = 2;

        while(address_dec > 0 && j >= 0) {
            bin_arr[j] = address_dec % 2;
            address_dec /= 2;
            j--;
        }
        if (read) {
            for(int i = 0; i < 3; i++) {
                if(bin_arr[i] == 1) {
                    address += read_val[i];
                }
            }
        } else {
            for(int i = 0; i < 3; i++) {
                if(bin_arr[i] == 1) {
                    address += write_val[i];
                }
            }
        }

        return address;
    }

}
