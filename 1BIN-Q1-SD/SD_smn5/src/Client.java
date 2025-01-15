import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try {
            // Connect to the server
            Socket socket = new Socket("4.tcp.eu.ngrok.io", 14070);

            // Create an OutputStream to send messages to the server
            OutputStream outputStream = socket.getOutputStream();

            // Create a BufferedReader to read input from the console
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

            // Read messages from the console and send them to the server
            String message;
            while ((message = consoleReader.readLine()) != null) {
                // Send the message to the server
                outputStream.write((message + "\n").getBytes());
            }

            // Close the sockets and streams
            consoleReader.close();
            outputStream.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}