package main;

import java.io.*;
import java.net.*;

public class Client {
  int port = 9876;
  String host = "localhost";
  Socket s;

  public static void main(String[] args) {
    new Client().run();
  }

  public void run() {
    try {
      s = new Socket(host, port);
      // OutputStream out = s.getOutputStream();
      // InputStream in = s.getInputStream();

      BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter out = new PrintWriter(s.getOutputStream(), true);
      BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

      String msg;
      while (true) {

        System.out.println(">");
        msg = read.readLine();

        if (msg == "exit") {
          break;
        }

        System.out.print("sending '" + msg + "' to communication.server...");
        out.println(msg);
        out.flush();
        System.out.println("done");

        System.out.println("received '" + in.readLine() + "' from communication.server\n");
      }
      in.close();
      out.close();
      read.close();
      s.close();


    } catch(Exception e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
  }

}
