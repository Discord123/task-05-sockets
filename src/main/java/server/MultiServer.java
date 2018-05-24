package server;

import entity.Document;
import service.Service;
import service.ServiceFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer implements Runnable {

    private static final int PORT = 6666;
    private static final ServiceFactory FACTORY = ServiceFactory.getInstance();
    private static final Service SERVICE = FACTORY.getService();
    private Document document;

    @Override
    public void run() {

        document = SERVICE.createDocument();
        ServerSocket s = null;

        try {
            s = new ServerSocket(PORT);
            while (true) {
                Socket socket = s.accept();
                try {
                    new Thread(new Server(socket, document)).start();
                } catch (Exception e) {
                    socket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

