package pro.tyshchenko.oop.network.udp;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author Alexander Tyshchenko.
 */
public class UDPSocketClient {

    public static void main(String[] args) {
        UDPSocketClient client = new UDPSocketClient();
        client.startClient();
    }

    public void startClient() {
        try(DatagramSocket socket = new DatagramSocket()) {

            InetAddress IPAddress = InetAddress.getByName("");
            byte[] incomingData = new byte[1024];
            String sentence = "This is a message from client";
            byte[] data = sentence.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(data, data.length, IPAddress, 9999);
            socket.send(sendPacket);
            System.out.println("Message sent from client");
            DatagramPacket incomingPacket = new DatagramPacket(incomingData, incomingData.length);
            socket.receive(incomingPacket);
            String response = new String(incomingPacket.getData()).trim();
            System.out.println("Response from server:" + response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

