
import java.io.*;
import java.net.*;

public class Server {

  public static void main(String[] args) throws IOException {
    System.out.println("Welcome to Server side");
    ServerSocket servers;
    Socket fromclient;
    try (BufferedReader in = null) {
      PrintWriter out = null;

      servers = null;
      fromclient = null;

      // create server socket
      try {
        servers = new ServerSocket(4444);
      } catch (IOException e) {
        System.out.println("Couldn't listen to port 4444");
        System.exit(-1);
      }

      try {
        System.out.print("Waiting for a client...");
        fromclient = servers.accept();
        System.out.println("Client connected");
      } catch (IOException e) {
        System.out.println("Can't accept");
        System.exit(-1);
      }

      in = new BufferedReader(new InputStreamReader(fromclient.getInputStream()));
      out = new PrintWriter(fromclient.getOutputStream(), true);
      String input, output;

      System.out.println("Wait for messages");
      while ((input = in.readLine()) != null) {
        if (input.equalsIgnoreCase("exit")) break;
        out.println("S ::: " + input);
        System.out.println(input);
      }
      out.close();
      in.close();
    }
    fromclient.close();
    servers.close();
  }
}
