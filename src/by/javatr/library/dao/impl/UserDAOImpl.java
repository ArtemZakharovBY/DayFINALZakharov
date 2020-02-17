package by.javatr.library.dao.impl;

import by.javatr.library.bean.user.User;
import by.javatr.library.dao.UserDAO;
import by.javatr.library.exception.dao.DAOException;

import java.util.List;

public class UserDAOImpl implements UserDAO {// аналогично предыдущему
    private static final UserDAOImpl INSTANCE = new UserDAOImpl();

    private UserDAOImpl(){}

    public static UserDAOImpl getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public List<User> seeAllUsers() throws DAOException {
        return null;
    }

    @Override
    public User getUserById(int id) throws DAOException {
        return null;
    }

    @Override
    public List<User> seeAllUsersSorted(String sortParameter, int sortType) throws DAOException {
        return null;
    }

    @Override
    public void deleteUserById(int id) throws DAOException {

    }

    @Override
    public void createAccount(User user, String encoded) throws DAOException {

    }

    @Override
    public User getUser(String name, String encoded) throws DAOException {
        return null;
    }

    @Override
    public void changePassword(int id, String encodedNewPassword) throws DAOException {

    }
}
