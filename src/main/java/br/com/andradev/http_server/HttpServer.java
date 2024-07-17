package main.java.br.com.andradev.http_server;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class HttpServer {
  public static void main(String[] args)  throws IOException {
    int port = 8080;
    
    String content = "<html>" +
        "<head><title>My Java HTTP Server</title></head>" +
        "<body>" +
        "<h1>Welcome to My Java HTTP Server!</h1>" +
        "<p>This is a simple HTML response from the server.</p>" +
        "</body>" +
        "</html>";
    
    ServerSocket serverSocket = new ServerSocket(port);
    
    System.out.println(STR."Server is running on port: \{port}");
    
    while (true) {
      try(Socket socket = serverSocket.accept()) {
        String httpResponse = STR."""
HTTP/1.1 200 OK \r
Content-Type: text/html\r
Content-Length: \{content.length()}\r
\r
\{content}""";
      
      // Sends a message to the client
        OutputStream output = socket.getOutputStream();
        output.write(httpResponse.getBytes(StandardCharsets.UTF_8));
        output.flush();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
