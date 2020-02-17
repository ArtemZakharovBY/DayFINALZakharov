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
 *class of getting sorted information about users, implements{@link Command}
 *@author Zakharov Artem
 *@version 1.0
 */
public class GetUsersSortedCommand implements Command {
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
    public GetUsersSortedCommand(ConsoleRequest requestFromUser) {
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
        String sortParameter = request.getParameter("sortParameter");
        int sortType = Integer.parseInt(request.getParameter("sortType"));
        try {
            List<User> users = service.seeAllUsersSorted(sortParameter, sortType);
            response = new ConsoleResponse("Sorted users by parameter: " + sortParameter + "\n" + users.toString());

            return response.getResponse();// зачем создавать целый объект, чтобы возвращать только строку из него?
            // где уснула твоя логика?
        } catch (ServiceException e) {
            response = new ConsoleResponse("Error with sort type or parameter of sorting");
            throw new CommandException(response.getResponse(), e);
        }
    }
}
