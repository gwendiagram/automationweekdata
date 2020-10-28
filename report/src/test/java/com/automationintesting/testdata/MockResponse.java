package com.automationintesting.testdata;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MockResponse {

    public void jsonData(ReportRoot report) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String json = gson.toJson(report);

        try {
            FileWriter file = new FileWriter("./output.json");
            file.write(json);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("JSON file created: " + json);
    }

}
