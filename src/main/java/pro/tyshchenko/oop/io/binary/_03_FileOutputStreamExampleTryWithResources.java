package pro.tyshchenko.oop.io.binary;


import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Alexander Tyshchenko.
 */
public class _03_FileOutputStreamExampleTryWithResources {

    public static void main(String[] args) {
        String source = "This text was written in file automatically\n";
        byte buffer[] = source.getBytes();

        String path_1 = "src/main/resources/io/binary/_02_FileOutputStreamExample_1.txt";
        String path_2 = "src/main/resources/io/binary/_02_FileOutputStreamExample_2.txt";
        String path_3 = "src/main/resources/io/binary/_02_FileOutputStreamExample_3.txt";
        // Use try-with-resources to close the files.
        try (FileOutputStream f0 = new FileOutputStream(path_1);
             FileOutputStream f1 = new FileOutputStream(path_2);
             FileOutputStream f2 = new FileOutputStream(path_3) )
        {

            // write to first file
            for (int i = 0; i < buffer.length; i += 2) {
                f0.write(buffer[i]);
            }

            // write to second file
            f1.write(buffer);

            // write to third file
            f2.write(buffer, buffer.length-buffer.length / 4, buffer.length / 4);
        } catch(IOException e) {
            System.out.println("I/O Error");
        }
    }

}
