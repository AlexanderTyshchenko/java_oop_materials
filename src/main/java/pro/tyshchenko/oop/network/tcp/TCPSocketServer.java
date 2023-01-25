package pro.tyshchenko.oop.network.tcp;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.text.MessageFormat.format;

/**
 * @author Alexander Tyshchenko.
 */
public class TCPSocketServer {

    private Integer port = 4545;

    private ServerSocket serverSocket = null;

    public void start() {
        try {
            ExecutorService executor = Executors.newFixedThreadPool(10);
            // Created ServerSocket with specific port
            serverSocket = new ServerSocket(port);
            System.out.println(format("Server started [{0}:{1}]", InetAddress.getLocalHost(), port.toString()));
            // Method accept is blocking, here we are waiting for socket connections.
            // When socket connection established method accept returning socket Socket
            while (true) {
                executor.submit(new ClientHandlerThread(serverSocket.accept()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class ClientHandlerThread implements Runnable {

        private final Socket socket;
        private final InputStream input;
        private final OutputStream output;

        public ClientHandlerThread(Socket socket) throws IOException {
            this.socket = socket;
            // Getting socket InputStream for retrieving message
            this.input = socket.getInputStream();
            // Getting socket OutputStream for sending message to socket
            this.output = socket.getOutputStream();
        }

        @Override
        public void run() {
            try {
                // Creating read buffer for storing socket message
                byte[] readBuffer = new byte[1024];
                // Read bytes from socket input stream
                int numBytes = input.read(readBuffer);
                // Creating byte array for storing message
                byte[] tempBuffer = new byte[numBytes];

                System.arraycopy(readBuffer, 0, tempBuffer, 0, numBytes);
                // Creating string from byte buffer
                String message = new String(tempBuffer, "UTF-8");
                System.out.println(format("Received message from socket[{0}] = {1}",
                        socket.getInetAddress(),
                        message));

                String reply = "I've got your message.";
                byte[] replyBytes = reply.getBytes();
                output.write(replyBytes);
                output.flush();
                Thread.sleep(2000);
                socket.close();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        TCPSocketServer server = new TCPSocketServer();
        server.start();
    }
}