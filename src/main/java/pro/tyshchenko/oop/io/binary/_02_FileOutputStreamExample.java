package pro.tyshchenko.oop.io.binary;


import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Alexander Tyshchenko.
 */
public class _02_FileOutputStreamExample {

    public static void main(String[] args) {
        String source = "This text was written in file automatically\n";
        byte buf[] = source.getBytes();
        FileOutputStream fos_1 = null;
        FileOutputStream fos_2 = null;
        FileOutputStream fos_3 = null;

        try {
            fos_1 = new FileOutputStream("src/main/resources/io/binary/_02_FileOutputStreamExample_1.txt");
            fos_2 = new FileOutputStream("src/main/resources/io/binary/_02_FileOutputStreamExample_2.txt");
            fos_3 = new FileOutputStream("src/main/resources/io/binary/_02_FileOutputStreamExample_3.txt");

            // write to first file
            for (int i = 0; i < buf.length; i += 2)
                fos_1.write(buf[i]);

            // write to second file
            fos_2.write(buf);

            // write to third file
            fos_3.write(buf, buf.length - buf.length / 4, buf.length / 4);
        } catch(IOException e) {
            System.out.println("I/O Error");
        } finally {
            try {
                if (fos_1 != null) {
                    fos_1.close();
                }
            } catch(IOException e) {
                System.out.println("Error Closing file1.txt");
            }
            try {
                if (fos_2 != null) {
                    fos_2.close();
                }
            } catch(IOException e) {
                System.out.println("Error Closing file2.txt");
            }
            try {
                if (fos_3 != null) {
                    fos_3.close();
                }
            } catch(IOException e) {
                System.out.println("Error Closing file3.txt");
            }
        }
    }

}
