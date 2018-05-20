package entity;

import java.io.Serializable;

public class Word implements Serializable{

    private static final long serialVersionUID = 7756800063168642898L;
    private String wordName;

    public Word() {
    }

    public Word(String wordName) {
        this.wordName = wordName;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getWordName() {
        return wordName;
    }

    public void setWordName(String wordName) {
        this.wordName = wordName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word word = (Word) o;

        return wordName != null ? wordName.equals(word.wordName) : word.wordName == null;
    }

    @Override
    public int hashCode() {
        return wordName != null ? wordName.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Word{");
        sb.append("wordName='").append(wordName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
