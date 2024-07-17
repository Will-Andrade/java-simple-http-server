package main.java.br.com.andradev.http_server;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class HttpClient {
  public static void main(String[] args) throws IOException {
    String host = "YOUR_SERVER_IP";
    Socket socket = new Socket(host, 8080);
    
    // Receives a message from the server and prints it
    Scanner input = new Scanner(socket.getInputStream());
    String line = input.nextLine();
    System.out.println(line);
  }
}
