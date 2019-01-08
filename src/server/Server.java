package server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(8000);

        while(true) {

            Socket client = serverSocket.accept();

            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));

            String line;
            while ((line = br.readLine()) != null) {
                if (line.equals("exit"))
                    break;

                pw.println(new StringBuilder(line).reverse().toString());
                pw.flush();
            }

            br.close();
            pw.close();

            client.close();
        }
    }

}
