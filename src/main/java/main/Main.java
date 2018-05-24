package main;

import client.Client;
import entity.Document;
import entity.Sentence;
import entity.Word;
import server.MultiServer;
import server.Server;
import service.ServiceFactory;
import service.impl.ServiceImpl;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

        public static void main(String[] args) {

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ServiceImpl service = (ServiceImpl) serviceFactory.getService();

        Document document = service.createDocument();

        List<Sentence> sentences = document.getSentencesInDocument();

        for (Sentence s : sentences) {
            System.out.println(s.getWordsInSentence().size());

            for (Word w : s.getWordsInSentence()) {
                System.out.println(w);
            }
        }
        System.out.println(sentences.size());



        MultiServer server = new MultiServer();
        Client client = new Client(5);

      new Thread(server).start();
        new Thread(client).start();
    }

}
