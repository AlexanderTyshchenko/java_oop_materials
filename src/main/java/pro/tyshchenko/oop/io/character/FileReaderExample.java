package pro.tyshchenko.oop.io.character;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author Alexander Tyshchenko.
 */
public class FileReaderExample {

    public static void main(String[] args) {
        try ( FileReader reader = new FileReader("src/main/resources/io/character/FileReaderExample.txt") )
        {
            int c;

            // Read and display the file.
            while((c = reader.read()) != -1)
                System.out.print((char) c);

        } catch(IOException e) {
            System.out.println("I/O Error: " + e);
        }
    }

}
