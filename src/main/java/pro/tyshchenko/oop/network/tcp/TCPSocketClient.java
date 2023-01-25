package pro.tyshchenko.oop.network.tcp;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author Alexander Tyshchenko.
 */
public class TCPSocketClient {

    public static void main(String[] args) {
        TCPSocketClient client = new TCPSocketClient();
        client.communicate();
    }

    public void communicate() {
        try(Socket socket = new Socket()) {

            socket.connect(new InetSocketAddress("", 4545), 3000);

            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            if (socket.isConnected()) {
                String messageString = "Hello from Alex";
                os.write(messageString.getBytes());
                System.out.println("Message has written to socket");
                byte[] byteBuffer = new byte[1024];
                int numBytes = is.read(byteBuffer);
                byte[] tempBuffer = new byte[numBytes];
                System.arraycopy(byteBuffer, 0, tempBuffer, 0, numBytes);
                String message = new String(tempBuffer, "UTF-8");
                System.out.println("Message from server = " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}