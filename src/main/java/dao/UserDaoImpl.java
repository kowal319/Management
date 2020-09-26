package dao;

import Validator.UserValidator;
import api.UserDao;
import entity.User;
import entity.parser.UserParser;
import utils.FileUtils;

import java.io.*;
import java.util.List;

import static utils.FileUtils.clearFile;

public class UserDaoImpl implements UserDao {
    private static final String fileName = "users.data";
private static UserDaoImpl instance = null;



    private UserDaoImpl() throws IOException {
        try {
            FileUtils.createNewFile(fileName);
        } catch (IOException e){
            System.out.println("Error with the file path");
            System.exit(-1);
        }
    }

    public static UserDao getInstance() throws IOException {
        if(instance == null){
            instance = new UserDaoImpl();
        }
        return instance;
    }

    public void saveUser(User user) throws IOException {
        List<User> users = getAllUsers();
        users.add(user);
        saveUsers(users);
    }

    public void saveUsers(List<User> users) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(fileName, true));
        for (User user : users) {
            printWriter.write(user.toString() + "\n");
        }
        printWriter.close();
    }

    public void removeUserById(Long userId) throws IOException {
        List<User> users = getAllUsers();
        for (int i = 0; i < users.size(); i++) {
            boolean isFoundUser = users.get(i).getId().equals(userId);
            if (isFoundUser) {
                users.remove(i);
            }
        }
        saveUsers(users);
    }

    public void removeUserByLogin(String login) throws IOException {
        List<User> users = getAllUsers();
        for (int i = 0; i < users.size(); i++) {
            boolean isFoundUser = users.get(i).getLogin().equals(login);
            if (isFoundUser) {
                users.remove(i);
            }
        }
        saveUsers(users);
    }

    public List<User> getAllUsers() throws IOException {
        List<User> users = getAllUsers();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

        String readLine = bufferedReader.readLine();
        while (readLine != null) {
            User user = UserParser.stringToUser(readLine);
            if (user != null) {
                users.add(user);
            }
        }
        bufferedReader.close();

        return users;
    }

    public User getUserById(Long userId) throws IOException {
        List<User> users = getAllUsers();
        for (User user : users) {
            boolean isFoundUser = user.getId().equals(userId);
            if (isFoundUser) {
                return user;
            }
        }
        return null;

    }

    public User getUserByUserLogin(String login) throws IOException {
        List<User> users = getAllUsers();
        for (User user : users) {
            boolean isFoundUser = user.getLogin().equals(login);
            if (isFoundUser) {
                return user;
            }
        }
        return null;
    }
}