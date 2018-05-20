package dao;

public interface DAO {
    void openConnectionToDB();
    String readLineFromDB();
    void closeConnectionToDB();
    boolean nextLineAvailable();
}
