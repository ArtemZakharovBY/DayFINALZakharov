package by.javatr.library.service.impl;

import by.javatr.library.bean.book.BaseBook;
import by.javatr.library.bean.book.PaperBook;
import by.javatr.library.bean.book.WebBook;
import by.javatr.library.dao.impl.BookDAOImpl;
import by.javatr.library.dao.impl.UserDAOImpl;
import by.javatr.library.exception.dao.DAOException;
import by.javatr.library.exception.service.ServiceException;
import by.javatr.library.service.UserService;

import java.util.List;

/**
 *Class of user's service,implements {@link UserService}, all methods throws {@link ServiceException}
 *with properties: INSTANCE
 *@author Zakharov Artem
 *@version 1.0
 */
public class UserServiceImpl implements UserService{

    /**@value UserServiceImpl field */
    private static final UserServiceImpl instance = new UserServiceImpl();// аналогично слою дао

    /**
     * Default Constructor - don't create new object
     * @see UserServiceImpl#UserServiceImpl()
     */
    private UserServiceImpl(){}

    /**
     * Static method to initialize our @value instance
     * @return object of {@link UserServiceImpl}
     */
    public static UserServiceImpl getINSTANCE() {
        return instance;
    }

    /** field of BookDAOImpl*/
    private BookDAOImpl bookDAO = BookDAOImpl.getINSTANCE();
    /** field of UserDAOImpl*/
    private UserDAOImpl userDAO = UserDAOImpl.getINSTANCE();

    /**
     * Getting a list of {@link WebBook} or {@link PaperBook} with hole information
     * @param bookType type of book (1 - paper, 0 - web)
     * @return list of {@link WebBook} or {@link PaperBook}
     * @throws ServiceException if {@link DAOException} was caught
     */
    @Override
    public List<BaseBook> seeAllBooks(int bookType) throws ServiceException {
        try {
            return bookDAO.getAllBooks(bookType);
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    /**
     * Method of taking a book from user
     * @param id identifier of book parameter
     * @throws ServiceException if {@link DAOException} was caught
     */
    @Override
    public void takeBookById(int id) throws ServiceException {
        try {
            bookDAO.takeBookById(id);
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    /**
     * Method of giving a book back to library
     * @param id identifier of paper book
     * @throws ServiceException if {@link DAOException} was caught
     */
    @Override
    public void givePaperBookBack(int id) throws ServiceException {
        try {
            bookDAO.giveBookBackById(id);
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }
}
