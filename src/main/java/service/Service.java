package service;

import entity.Document;

public interface Service {
    Document createDocument();
    Document reBuildDocument(int i, Document document);
}
