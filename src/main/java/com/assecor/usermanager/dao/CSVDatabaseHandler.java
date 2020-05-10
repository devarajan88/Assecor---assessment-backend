package com.assecor.usermanager.dao;

import com.assecor.usermanager.bean.User;
import com.assecor.usermanager.parser.UserParser;

import java.util.ArrayList;
import java.util.List;

public class CSVDatabaseHandler implements DatabaseHandler {

    @Override
    public List<User> readAllData() {
        List<User> userList = new ArrayList<>();

        CSVFileReader csvFileReader = new CSVFileReader();
        UserParser userParser = new UserParser();
        userList = userParser.parseUserLine(csvFileReader.readLines());

        return userList;
    }

    @Override
    public User readSpecificData(int id) {
        UserParser userParser = new UserParser();
        CSVFileReader csvFileReader = new CSVFileReader();
        User user = userParser.createUser(csvFileReader.readSpecificLine(id));
        user.setId((long)id);
        return user;
    }

    @Override
    public void writeData(User user) {

    }
}
