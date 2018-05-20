package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Sentence implements Serializable{

    private static final long serialVersionUID = 668707195864894563L;
    private final List<Word> wordsInSentence = new ArrayList<>();

    public Sentence() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<Word> getWordsInSentence() {
        return wordsInSentence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sentence sentence = (Sentence) o;

        return wordsInSentence != null ? wordsInSentence.equals(sentence.wordsInSentence) : sentence.wordsInSentence == null;
    }

    @Override
    public int hashCode() {
        return wordsInSentence != null ? wordsInSentence.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Sentence{");
        sb.append("wordsInSentence=").append(wordsInSentence);
        sb.append('}');
        return sb.toString();
    }
}
