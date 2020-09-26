package Validator;

import api.UserDao;
import dao.UserDaoImpl;
import entity.User;
import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;

import java.io.IOException;

public class UserValidator {

    private final int MIN_LENGTH_PASSWORD = 6;
    private final int MIN_LENGTH_LOGIN = 4;

    private static UserValidator instance = null;
    private UserDao userDao = UserDaoImpl.getInstance();


    private UserValidator() throws IOException {
    }

    public static UserValidator getInstance() throws IOException {
        if (instance == null) {
            instance = new UserValidator();
        }

        return instance;
    }

    public boolean isValidate(User user) throws UserLoginAlreadyExistException, UserShortLengthLoginException, UserShortLengthPasswordException {
        if (isPasswordlengthEnough(user.getPassword()))
            throw new UserShortLengthPasswordException("Za krotkie haslo");

        if (isLoginLengthEnough(user.getLogin()))
            throw new UserShortLengthLoginException("Za krótki login");
        return true;
        }

    private boolean isPasswordlengthEnough(String password) {
        return (password.length() > MIN_LENGTH_PASSWORD);
    }

    private boolean isLoginLengthEnough(String login) {
        return (login.length() > MIN_LENGTH_LOGIN);
    }

}