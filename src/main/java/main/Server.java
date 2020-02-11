package main;

import java.io.*;
import java.net.*;

public class Server {
  int port = 9876;
  ServerSocket s;

  public static void main(String[] args) {

    new Server().run();

  }

  public void run() {
    try {
      s = new ServerSocket(port);
      Socket c = s.accept();
      PrintWriter out = new PrintWriter(c.getOutputStream(), true);
      BufferedReader in = new BufferedReader(new InputStreamReader(c.getInputStream()));

      String clientMsg;
      Boolean exit = false;

      while ((clientMsg = in.readLine()) != null) {
        String echo = clientMsg;
        System.out.println("recieved " + clientMsg);
        System.out.println("response: " + echo);
        out.println(echo);
        out.flush();
        System.out.println("done");
      }
      in.close();
      out.close();
      s.close();
      System.out.println("communication.client disconnected");

    } catch(IOException e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
      return;
    }
  }

}
