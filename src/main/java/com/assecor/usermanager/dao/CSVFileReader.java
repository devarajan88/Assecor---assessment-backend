package com.assecor.usermanager.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVFileReader {

    static final String CSV_FILE = "sample-input.csv";

    public List<String> readLines() {
        List<String> userLineData = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(CSV_FILE));
            String line;
            while ((line = reader.readLine()) != null) {
                userLineData.add(line);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userLineData;
    }

    public String readSpecificLine(int lineNo) {
        String line = null;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(CSV_FILE));
            for (int i = 0; i < lineNo - 1; i++) {
                reader.readLine();
            }
            line = reader.readLine();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return line;
    }
}
