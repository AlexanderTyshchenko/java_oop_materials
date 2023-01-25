package pro.tyshchenko.oop.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author Alexander Tyshchenko.
 */
public class SocketExample1 {

    public static void main(String[] args) throws IOException {

        try(Socket socket = new Socket("www.google.com.ua", 80);
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            InputStream inputStream = socket.getInputStream())
        {
            pw.println("GET / HTTP/1.1");
            pw.println("Host: www.google.com.ua\n");
            pw.flush();

            byte[] buf = new byte[1000];
            int r;
            do {
                if ((r = inputStream.read(buf)) > 0)
                    System.out.println(new String(buf, 0, r));
            } while (r > 0);
        }
    }

}
