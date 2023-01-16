package pro.tyshchenko.oop.io.binary;


import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Alexander Tyshchenko.
 */
public class _01_FileInputStreamExample {

    public static void main(String[] args) {
        int size;

        try {
            String path = "src/main/resources/io/binary/_01_FileInputStreamExample.txt";
            FileInputStream fis = new FileInputStream(path);
            System.out.println("Total Available Bytes: " + (size = fis.available()));

            int n = size / 40;
            System.out.println("First " + n + " bytes of the file one read() at a time");
            for (int i = 0; i < n; i++) {
                System.out.print((char) fis.read());
            }

            System.out.println("Still Available: " + fis.available());

            System.out.println("Reading the next " + n + " with one read(buffer[])");
            byte[] buffer = new byte[n];
            if (fis.read(buffer) != n) {
                System.err.println("couldn't read " + n + " bytes.");
            }

            System.out.println(new String(buffer, 0, n));
            System.out.println("Still Available: " + (size = fis.available()));
            System.out.println("Skipping half of remaining bytes with skip()");
            fis.skip(size / 2);
            System.out.println("Still Available: " + fis.available());

            System.out.println("Reading " + n / 2 + " into the end of array");
            if (fis.read(buffer, n / 2, n / 2) != n / 2) {
                System.err.println("couldn't read " + n / 2 + " bytes.");
            }

            System.out.println(new String(buffer, 0, buffer.length));
            System.out.println("Still Available: " + fis.available());
        } catch(IOException e) {
            System.out.println("I/O Error: " + e);
        }
    }

}