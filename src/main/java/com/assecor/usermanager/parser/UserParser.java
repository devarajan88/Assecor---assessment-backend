package com.assecor.usermanager.parser;

import com.assecor.usermanager.bean.Colours;
import com.assecor.usermanager.bean.User;

import java.util.ArrayList;
import java.util.List;

public class UserParser {

    public List<User> parseUserLine(List<String> userLines) {
        List<User> users = new ArrayList<>();
        long userId = 1;
        for (String userLine : userLines) {
            User user = createUser(userLine);
            if (user != null) {
                user.setId(userId++);
                users.add(user);
            }
        }

        return users;
    }

    public User createUser(String userLine) {
        User user = null;
        String[] userCellData = null;
        Colours colours = new Colours();

        if (userLine != null) {
            userCellData = userLine.split(",");
            if (userCellData.length == 4) {
                user = new User();
                user.setName(userCellData[0]);
                user.setLastName(userCellData[1]);

                String[] zipcodeAndCity = splitZipcodeAndCity(userCellData[2]);
                user.setZipcode(zipcodeAndCity[0]);
                user.setCity(zipcodeAndCity[1]);
                user.setColor(colours.getColour(Integer.parseInt(userCellData[3].trim())));
            }
        }
        return user;
    }

    private String[] splitZipcodeAndCity(String userCellDatum) {
        String[] zipcodeAndCitySplit = userCellDatum.trim().split(" ");
        String[] zipcodeAndCity = new String[2];
        zipcodeAndCity[0] = zipcodeAndCitySplit[0].trim();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < zipcodeAndCitySplit.length; i++) {
            stringBuilder.append(zipcodeAndCitySplit[i]).append(" ");
        }

        zipcodeAndCity[1] = stringBuilder.toString();
        return zipcodeAndCity;
    }

}
