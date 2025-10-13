import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class File_reader {
    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\Anwender\\Desktop\\alle_c_projekte\\Java_projekte\\github-intellij-test\\src\\read_file");
        Scanner scan = new Scanner(file);


        String new_line = "";
        String new_write = "";
        while (scan.hasNextLine()) {
            String line = scan.nextLine();

            if (line.equals("one")) {
                new_line = "1";
            } else if (line.equals("zero")) {
                new_line = "0";
            }

            new_write = new_write.concat(new_line);

        }
        FileWriter writer = new FileWriter("C:\\Users\\Anwender\\Desktop\\alle_c_projekte\\Java_projekte\\github-intellij-test\\src\\write_file");
        writer.write(new_write);
        writer.close();

    }
}
