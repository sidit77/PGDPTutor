package server;

import java.io.*;
import java.net.Socket;

public class CSVDownload {

    public static void main(String[] args) throws Exception{

        Socket server = new Socket("www2.in.tum.de", 80);

        BufferedReader br = new BufferedReader(new InputStreamReader(server.getInputStream()));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(server.getOutputStream()));

        String request = "GET /~kranzj/temperaturesEurope1963Till2013ByCity.csv HTTP/1.1";
        String host = "Host: www2.in.tum.de";

        pw.print(request + "\r\n" + host + "\r\n\r\n");
        pw.flush();


        OutputStream os =new FileOutputStream("temperatures.csv");

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os));

        br.lines().dropWhile(l -> !l.equals("")).skip(1).forEach(l -> {
            try {
                writer.write(l);
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        writer.close();

        pw.close();
        br.close();
        server.close();

    }

}
