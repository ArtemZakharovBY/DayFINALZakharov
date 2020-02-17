package by.javatr.library.dao.impl;

import by.javatr.library.bean.book.BaseBook;
import by.javatr.library.dao.BookDAO;
import by.javatr.library.exception.dao.DAOException;

import java.util.List;

public class BookDAOImpl implements BookDAO {
    private static final BookDAOImpl INSTANCE = new BookDAOImpl();
// мы специально разбирали способ, чтобы уйти в коде от синглтона
    // и что я в итоге вижу?
    
    private BookDAOImpl(){}

    public static BookDAOImpl getINSTANCE() {
        return INSTANCE;
    }
// эм, а код где?
    @Override
    public BaseBook getBookById(int id) throws DAOException {
        return null;
    }

    @Override
    public List<BaseBook> getAllBooks(int bookType) throws DAOException {
        return null;
    }

    @Override
    public void addBook(BaseBook book) throws DAOException {

    }

    @Override
    public void takeBookById(int id) throws DAOException {

    }

    @Override
    public void giveBookBackById(int id) throws DAOException {

    }

    @Override
    public void deleteWebBookById(int id) throws DAOException {

    }
}
