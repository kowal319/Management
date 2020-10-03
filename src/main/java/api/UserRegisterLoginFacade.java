package api;

import entity.User;

import java.io.IOException;

public interface UserRegisterLoginFacade {
    boolean registerUser (User user);
    boolean loginUser(String login, String password) throws IOException;
}


