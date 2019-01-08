package server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {


    public static void main(String[] args) throws Exception{
        Socket server = new Socket("127.0.0.1", 8000);

        BufferedReader br = new BufferedReader(new InputStreamReader(server.getInputStream()));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(server.getOutputStream()));

        String line;
        while((line = Terminal.readString()) != null){
            pw.println(line);
            pw.flush();

            line = br.readLine();
            if(line == null)
                break;
            System.out.println(line);
        }

        br.close();
        pw.close();

        server.close();
    }


}
