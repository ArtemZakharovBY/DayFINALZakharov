package by.javatr.library.service.impl;

import by.javatr.library.bean.book.BaseBook;
import by.javatr.library.bean.book.PaperBook;
import by.javatr.library.bean.book.WebBook;
import by.javatr.library.bean.user.User;
import by.javatr.library.dao.BookDAO;
import by.javatr.library.dao.UserDAO;
import by.javatr.library.dao.impl.BookDAOImpl;
import by.javatr.library.dao.impl.UserDAOImpl;
import by.javatr.library.exception.dao.DAOException;
import by.javatr.library.exception.service.ServiceException;
import by.javatr.library.exception.service.book.InvalidPaperBookValuesException;
import by.javatr.library.exception.service.book.InvalidWebBookValuesException;
import by.javatr.library.service.AdministratorService;
import by.javatr.library.util.builder.book.PaperBookBuilder;
import by.javatr.library.util.builder.book.WebBookBuilder;
import by.javatr.library.util.validator.BookValuesValidator;

import java.util.List;

/**
 *Class of administrator's service,implemets {@link AdministratorService} all methods throws {@link ServiceException}
 *with properties: instance
 *@author Zakharov Artem
 *@version 1.0
 */
public class AdministratorServiceImpl implements AdministratorService{
    /** @value AdministratorServiceImpl*/
    private static final AdministratorServiceImpl INSTANCE = new AdministratorServiceImpl();

    /**
     * Default Constructor - don't create new object
     * @see AdministratorServiceImpl#AdministratorServiceImpl()
     */
    private AdministratorServiceImpl(){}

    /**
     * Static Method to initialize our @value instance;
     * @return object of {@link AdministratorServiceImpl}
     */
    public static AdministratorServiceImpl getINSTANCE() {
        return INSTANCE;
    }

    /** field of BookDAOImpl*/
    private BookDAO bookDAO = BookDAOImpl.getINSTANCE();
    /** field of UserDAOImpl*/
    private UserDAO userDAO = UserDAOImpl.getINSTANCE();

    /**
     * Method of getting information about all users
     * @return list of {@link User}
     * @throws ServiceException if was an error during the process of getting the information
     */
    @Override
    public List<User> seeAllUsers() throws ServiceException {
        try {
            return userDAO.seeAllUsers();
        } catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    /**
     * Method of getting a user with given id
     * @param id identifier of user
     * @return object of {@link User}
     * @throws ServiceException if was an error during the process of getting the information
     */
    @Override
    public User seeUserById(int id) throws ServiceException {
        try {
            return userDAO.getUserById(id);
        } catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    /**
     * Method of getting sorted information about all users
     * @param sortParameter sorting parameter (example: id, name)
     * @param sortType sorting type (means ascending or descending)
     * @return list of {@link User}
     * @throws ServiceException if was an error during the process of getting the information
     */
    @Override
    public List<User> seeAllUsersSorted(String sortParameter, int sortType) throws ServiceException {
        try {
            return userDAO.seeAllUsersSorted(sortParameter, sortType);
        } catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    /**
     * Method of adding new paper book
     * @param title title of new paper book
     * @param author author of new paper book
     * @param dateOfPublishing publishing date of new paper book
     * @param bookAmount amount of examples of new paper book
     * @throws ServiceException if was an error during the process of setting the information
     */
    @Override
    // в слой сервисов уже нет необходимости передавать россыпь параметров, нормальный объект можно создать уровнем выше
    public void addBook(String title, String author, int dateOfPublishing, int bookAmount) throws ServiceException {
        if (!BookValuesValidator.validate(title, author, dateOfPublishing, bookAmount)){
            throw new InvalidPaperBookValuesException("Invalid paper book values!");
        }
        PaperBookBuilder builder = new PaperBookBuilder();
        PaperBook book = (PaperBook) builder.setBookAmount(bookAmount).setTitle(title)
                .setAuthor(author).setDateOfPublishing(dateOfPublishing)
                .create();
        try {
            bookDAO.addBook(book);
        } catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    /**
     * Method of adding new web-book
     * @param title title of new paper book
     * @param author author of new paper book
     * @param publishingDate date of publishing
     * @param price price of book
     * @param source web source of book
     * @throws ServiceException if was an error during the process of setting the information
     */
    @Override
    public void addBook(String title, String author, int publishingDate, int price, String source)
            throws ServiceException {
        if (!BookValuesValidator.validate(title, author, publishingDate, price, source)){
            throw new InvalidWebBookValuesException("Invalid web book values!");

        }
        WebBookBuilder builder = new WebBookBuilder();
        WebBook book = (WebBook) builder.setPrice(price).setSource(source)
                                        .setTitle(title).setAuthor(author)
                                        .setDateOfPublishing(publishingDate)
                                        .create();
        try {
            bookDAO.addBook(book);
        } catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    /**
     * Method of deleting web book by id
     * @param id identifier of web book, we want to delete
     * @throws ServiceException if was an error during the process of deleting the information
     */
    @Override
    public void deleteWebBook(int id) throws ServiceException {
        try {
            bookDAO.deleteWebBookById(id);
        } catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    /**
     * Getting the information about {@link PaperBook} or {@link WebBook}
     * @return list of {@link PaperBook} or {@link WebBook}
     * @throws ServiceException if was an error during the process of getting the information
     */
    @Override
    public List<BaseBook> seeAllBooks(int bookType) throws ServiceException {
        try {
            return bookDAO.getAllBooks(bookType);
        } catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    public void setBookDAO(BookDAO bookDAOFromdeveloper) {
        bookDAO = bookDAOFromdeveloper;
    }

    public void setUserDAO(UserDAO userDAOFromDeveloper) {
        userDAO = userDAOFromDeveloper;
    }
}
