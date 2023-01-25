package pro.tyshchenko.oop.network.udp;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author Alexander Tyshchenko.
 */
public class UDPSocketServer {

    public static void main(String[] args) {
        UDPSocketServer server = new UDPSocketServer();
        server.startServer();
    }

    public void startServer() {
        try(DatagramSocket socket = new DatagramSocket(9999)) {
            byte[] incomingData = new byte[1024];

            while (true) {
                DatagramPacket incomingPacket = new DatagramPacket(incomingData, incomingData.length);
                socket.receive(incomingPacket);
                String message = new String(incomingPacket.getData()).trim();

                System.out.println("Received message from client: " + message);
                InetAddress IPAddress = incomingPacket.getAddress();
                int port = incomingPacket.getPort();
                String reply = "Thank you for the message";
                byte[] data = reply.getBytes();
                DatagramPacket replyPacket =
                        new DatagramPacket(data, data.length, IPAddress, port);
                socket.send(replyPacket);
                Thread.sleep(2000);
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}