import java.net.ServerSocket;
import java.io.IOException;
import java.util.Scanner;
import java.net.Socket;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Servidor {
  public static void main(String[] args) throws IOException {
    try {
      ServerSocket server = new ServerSocket(12345);
      System.out.println("Porta 12345 aberta!");

      Socket clSocket = server.accept();
      InputStream in = clSocket.getInputStream();
      InputStreamReader isr = new InputStreamReader(in);
      BufferedReader reader = new BufferedReader(isr);
      // String fName = reader.readLine();
      // System.out.println(fName);
      File f1 = new File("/home/robson/pos/tr_pd_01/arquivo_transferido.txt");
      FileOutputStream out = new FileOutputStream(f1);
          int tamanho = 4096; // buffer de 4KB  
          byte[] buffer = new byte[tamanho];  
          int lidos = -1;  
          while ((lidos = in.read(buffer, 0, tamanho)) != -1) {  
            System.out.println(lidos);
              out.write(buffer, 0, lidos);  
          }  
          out.flush();  
    } catch (IOException e) {
    }
    
  }
}
