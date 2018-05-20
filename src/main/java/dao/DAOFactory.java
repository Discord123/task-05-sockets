package dao;

import dao.impl.DAOImpl;

public class DAOFactory {

    private static final DAOFactory instance = new DAOFactory();

    private final DAO DAO = new DAOImpl();

    private DAOFactory() {}

    public DAO getDAO() {
        return DAO;
    }

    public static DAOFactory getInstance() {
        return instance;
    }
}
