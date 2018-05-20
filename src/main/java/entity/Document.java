package entity;

import java.io.Serializable;
import java.util.List;

public class Document implements Serializable{

    private static final long serialVersionUID = 5639389737306562747L;
    private List<Sentence> sentencesInDocument;

    public Document() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<Sentence> getSentencesInDocument() {
        return sentencesInDocument;
    }

    public void setSentencesInDocument(List<Sentence> sentencesInDocument) {
        this.sentencesInDocument = sentencesInDocument;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Document document = (Document) o;

        return sentencesInDocument != null ? sentencesInDocument.equals(document.sentencesInDocument) : document.sentencesInDocument == null;
    }

    @Override
    public int hashCode() {
        return sentencesInDocument != null ? sentencesInDocument.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Document{");
        sb.append("sentencesInDocument=").append(sentencesInDocument);
        sb.append('}');
        return sb.toString();
    }
}
