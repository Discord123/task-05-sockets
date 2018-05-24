package service.impl;

import dao.DAO;
import dao.DAOFactory;
import entity.Document;
import entity.Sentence;
import entity.Word;
import service.Service;
import service.util.ServiceUtil;

import java.util.ArrayList;
import java.util.List;

public class ServiceImpl implements Service {

    private DAOFactory daoFactory = DAOFactory.getInstance();
    private DAO dao = daoFactory.getDAO();

    @Override
    public Document createDocument() {
        Document document = new Document();

        List<Sentence> sentences = createSentenceList();
        document.setSentencesInDocument(sentences);

        return document;
    }

    @Override
    public Document reBuildDocument(int i, Document document) {
        Document reBuildDocument = ServiceUtil.reBuildDocument(i,document);

        return reBuildDocument;
    }

    private List<Sentence> createSentenceList(){
        List<Sentence> sentences;

        sentences = createSentenceFromWords();

        return sentences;
    }

    private synchronized List<Sentence> createSentenceFromWords() {

        List<Sentence> sentences = new ArrayList<>();

        List<Word> words = new ArrayList<>();

        dao.openConnectionToDB();

        while (dao.nextLineAvailable()) {

            String textLine = dao.readLineFromDB();
            List<Word> list = createWordsFromLine(textLine);

            for (Word w : list) {
                words.add(w);
                if(w.getWordName().contains(".") || w.getWordName().contains("!") || w.getWordName().contains("?")) {
                    sentences.add(new Sentence(words));
                    words = new ArrayList<>();
                }
            }
        }
        return sentences;
    }

    private synchronized List<Word> createWordsFromLine(String line) {
        List<Word> words = new ArrayList<>();

        String textLine = line.trim();
        String [] wordMas = textLine.split(" ");

        for (String s : wordMas) {
            words.add(new Word(s));
        }

        return words;
    }

}
