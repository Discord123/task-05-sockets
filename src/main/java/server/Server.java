package server;

import entity.Document;
import service.util.ServiceUtil;

import java.io.*;
import java.net.Socket;

public class Server implements Runnable {
    private Socket socket;
    private int numberSchemaOfRebuild;
    private Document document;

    public Server(Socket socket, Document document) {
        this.socket = socket;
        this.document = document;
    }

    @Override
    public void run(){

        try {
            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            DataInputStream in = new DataInputStream(sin);
            ObjectOutputStream out = new ObjectOutputStream(sout);

            while(true) {
                numberSchemaOfRebuild = in.readInt();
                Document reBuildDocument = ServiceUtil.reBuildDocument(numberSchemaOfRebuild, document);
                out.writeObject(reBuildDocument);
                out.flush();
            }
        } catch(Exception x) { x.printStackTrace(); }
    }
}
