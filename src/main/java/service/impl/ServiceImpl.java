package service.impl;

import dao.DAO;
import dao.DAOFactory;
import entity.Document;
import entity.Sentence;
import entity.Word;
import service.Service;

import java.util.ArrayList;
import java.util.List;

public class ServiceImpl implements Service {

    private DAOFactory daoFactory = DAOFactory.getInstance();
    private DAO dao = daoFactory.getDAO();

    @Override
    public Document createDocument(int i) {
        Document document = new Document();

        List<Sentence> sentences = createSentenceList();
        document.setSentencesInDocument(sentences);

        return document;
    }

    private List<Sentence> createSentenceList(){
        List<Sentence> sentences = new ArrayList<>();

        dao.openConnectionToDB();

        while (dao.nextLineAvailable()) {
            String textLine = dao.readLineFromDB();


        }

        return sentences;
    }


}
