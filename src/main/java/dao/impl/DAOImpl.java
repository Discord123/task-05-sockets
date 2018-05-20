package dao.impl;

import dao.DAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DAOImpl implements DAO {

    private static final String DATABASE_FILE_NAME = "text_db.txt";
    private static final ClassLoader CLASS_LOADER = DAOImpl.class.getClassLoader();
    private InputStream is;
    private BufferedReader br;

    @Override
    public void openConnectionToDB() {
        is = CLASS_LOADER.getResourceAsStream(DATABASE_FILE_NAME);
        br = new BufferedReader(new InputStreamReader(is));
    }

    @Override
    public String readLineFromDB() {

        String readLine = "";
        try {

            while ((readLine = br.readLine()) != null) {
                return readLine;
            }
        } catch (IOException e) {
            System.out.println("IOException in readLineFromDB method");
            e.printStackTrace();
        }

        return readLine;
    }

    @Override
    public boolean nextLineAvailable() {
        boolean nextLineAvailable = false;

        try {
            nextLineAvailable = is.available() > 0;
        } catch (IOException e) {
            System.out.println("IOException in nextLineAvailable method");
            e.printStackTrace();
        }

        return nextLineAvailable;
    }

    @Override
    public void closeConnectionToDB() {

        try {
            br.close();
            is.close();
        } catch (IOException e) {
            System.out.println("IOException in closeConnectionToDB method");
            e.printStackTrace();
        }
    }
}
