package com.assecor.usermanager.dao;

import com.assecor.usermanager.bean.User;

import java.util.List;

public interface DatabaseHandler {

    List<User> readAllData();
    User readSpecificData(int id);
    void writeData(User user);

}
