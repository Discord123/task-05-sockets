package client;

import entity.Document;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client implements Runnable {

    private final int serverPort = 6666;
    private final String address = "127.0.0.1";
    private final int numberSchemaOfRebuild;
    private Document document;

    public Client(int numberSchemaOfRebuild) {
        this.numberSchemaOfRebuild = numberSchemaOfRebuild;
    }

    @Override
    public void run(){

        try {
            InetAddress ipAddress = InetAddress.getByName(address);
            Socket socket = new Socket(ipAddress, serverPort);

            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            ObjectInputStream in = new ObjectInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            while (true) {
                out.writeInt(numberSchemaOfRebuild);
                out.flush();
                document = (Document) in.readObject();
            }
        } catch (Exception x) {
            x.printStackTrace();
        }
    }
}
