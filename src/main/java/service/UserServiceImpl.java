package service;

import Validator.ProductValidator;
import Validator.UserValidator;
import api.ProductDao;
import api.UserDao;
import api.UserService;
import dao.ProductDaoImpl;
import dao.UserDaoImpl;
import entity.User;
import exception.UserLoginAlreadyExistException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    private static UserServiceImpl instance = null;
    private UserDao userDao = UserDaoImpl.getInstance();
    private UserValidator userValidator = UserValidator.getInstance();

    private UserServiceImpl() throws IOException {

    }

    public static UserServiceImpl getInstance() throws IOException {
        if (instance == null) {
            instance = new UserServiceImpl();
        }
        return instance;
    }

    public List<User> getAllUsers() throws IOException{
        return userDao.getAllUsers();
    }

    public boolean addUser(User user) {
        try {
            if (isUserLoginAlreadyExist(user.getLogin())) {
                throw new UserLoginAlreadyExistException("Taki login juz istnieje");
            }
            if (userValidator.isValidate(user)) {
                userDao.saveUser(user);
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
private boolean isUserLoginAlreadyExist(String login) throws IOException {
        User user = getUserByLogin(login);
        return user != null;
    }

    public void removeUserById(Long userId) throws IOException {
        userDao.removeUserById(userId);
}
public User getUserById(Long userId) throws IOException{
    List<User> users = getAllUsers();
    for( User user : users){
        boolean isFoundUser = user.getId().equals(userId);
        if(isFoundUser){
            return user;
        }
    }
    return null;
    }

    public User getUserByLogin(String login) throws IOException{
        List<User> users = null;
        try{
            users = getAllUsers();
            for(User user : users){
                boolean isFoundUser = user.getLogin().equals(login);
                if(isFoundUser){
                    return user;
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
return null;
    }

    public boolean isCorrectLoginAndPassword(String login, String password) {
        User foundUser = getUserByLogin(login);

        if (foundUser == null) {
            return false;
        }

        boolean isCorrectLogin = foundUser.getLogin().equals(login);
        boolean isCorrectPass = foundUser.getPassword().equals(password);

        return isCorrectLogin && isCorrectPass;
    }
}