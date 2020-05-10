package com.assecor.usermanager.service;

import com.assecor.usermanager.bean.User;
import com.assecor.usermanager.dao.CSVDatabaseHandler;
import com.assecor.usermanager.dao.DatabaseHandler;
import com.assecor.usermanager.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        DatabaseHandler databaseHandler = new CSVDatabaseHandler();
        List<User> userList = databaseHandler.readAllData();
        return userList;
    }

    public User getSpecificUser(int id){
        DatabaseHandler databaseHandler = new CSVDatabaseHandler();
        return databaseHandler.readSpecificData(id);
    }

    public List<User> getUsersByColour(String colour) {
        List<User> userList = getAllUsers();
        List<User> users = new ArrayList<>();
        for(User user : userList)  {
            if(user.getColor().equalsIgnoreCase(colour)) {
                users.add(user);
            }
        }
        return users;
    }

    public User createUser(User user) {
        User userCreated = userRepository.save(user);
        return userCreated;
    }

}
