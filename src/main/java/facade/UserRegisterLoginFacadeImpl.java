package facade;

import api.UserRegisterLoginFacade;
import api.UserService;
import entity.User;
import service.UserServiceImpl;

import java.io.IOException;
import java.io.InvalidObjectException;

public class UserRegisterLoginFacadeImpl implements UserRegisterLoginFacade {
    private UserService userService = UserServiceImpl.getInstance();
    private static UserRegisterLoginFacade instance = null;


    private UserRegisterLoginFacadeImpl() throws IOException {
    }

    public static UserRegisterLoginFacade getInstance() throws IOException {
        if(instance == null){
            instance = new UserRegisterLoginFacadeImpl();
        }
        return instance;
    }

    public boolean registerUser(User user){
        return userService.addUser(user);
    }

    public boolean loginUser(String login, String password) throws IOException {
        if(userService.isCorrectLoginAndPassword(login, password)){
            return true;
        }
        return false;
    }
}
