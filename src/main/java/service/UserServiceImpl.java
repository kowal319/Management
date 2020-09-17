package service;

import api.UserService;
import entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    List<User> users;

    public UserServiceImpl() {
        this.users = new ArrayList<User>();
    }

    public UserServiceImpl(List<User> users) {
        this.users = users;
    }

    public List<User> getAllUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUserById (Long userId){
        for (int i = 0; i<users.size(); i++){
            //wyciagniecie i=tego usera z listy
            User userFromList = users.get(i);
            //jezel id usera z listy jest rowne podanemu userId do usunieca
            if(userFromList.getId() == userId){
                //to usun tego usera z pod i tego indexu
                users.remove(i);
                //i przerwij ptele w koncu user juz zostal usuniety
                break;
            }
        }
    }
}