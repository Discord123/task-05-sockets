package main;

import entity.Document;
import entity.Sentence;
import entity.Word;
import service.ServiceFactory;
import service.impl.ServiceImpl;

import java.util.List;

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
    }
}
