package by.javatr.library.controller_command.impl;

import by.javatr.library.bean.user.User;
import by.javatr.library.controller_command.Command;
import by.javatr.library.console.ConsoleRequest;
import by.javatr.library.console.ConsoleResponse;
import by.javatr.library.exception.command.CommandException;
import by.javatr.library.exception.service.ServiceException;
import by.javatr.library.service.AdministratorService;
import by.javatr.library.service.impl.AdministratorServiceImpl;

import java.util.List;

/**
 *class of getting all information about users, implements{@link Command}
 *@author Zakharov Artem
 *@version 1.0
 */
public class GetAllUsersCommand implements Command {
    // мы разбирали реализацию команды и остановились на другой реализации
    // однопоточную реализацию не используем
    
    /** field service*/
    private AdministratorService service;
    /** field request*/
    private ConsoleRequest request;
    /** field response*/
    private ConsoleResponse response;

    /**
     * Constructor - makes an object
     * @param requestFromUser request with some information
     */
    public GetAllUsersCommand(ConsoleRequest requestFromUser) {
        service = AdministratorServiceImpl.getINSTANCE();
        request = requestFromUser;
    }

    /**
     * Method with UI logic
     * @return text of {@link ConsoleResponse}
     * @throws CommandException if was an error during the getting information
     */
    @Override
    public String execute() throws CommandException {
        try {
            List<User> users = service.seeAllUsers();
            response = new ConsoleResponse("Users: \n" + users.toString());

            return response.getResponse();
        } catch (ServiceException e) {
            response = new ConsoleResponse("Can\'t find list of books");// у этого оператора нет логического смылка в выполнении
            // throw все равно угробит этот объект
            throw new CommandException(response.getResponse(), e);
        }
    }
}
