package com.automationintesting.testdata;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.github.javafaker.Faker;

import org.junit.Test;

public class CreateTestDataTest {
    @Test
    public void createTestData() {
        ArrayList<ReportItem> reportItems = new ArrayList<>();
        int i = 0;
        while (i < 1000) {
            final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;

            Faker faker = new Faker();
            String startDate = ZonedDateTime.now(ZoneOffset.UTC).plusDays(10).format(formatter);
            String endDate = ZonedDateTime.now(ZoneOffset.UTC).plusDays(20).format(formatter);
            String fullName = faker.name().fullName();
            Integer roomNumber = faker.number().numberBetween(1, 10000);
            String title = fullName + " - Room: " + roomNumber;

            ReportItem reportItem = new ReportItem(startDate, endDate, title);
            reportItems.add(reportItem);
            i++;
        }
        ReportRoot report = new ReportRoot("report", reportItems);
        MockResponse mockResponse = new MockResponse();
        mockResponse.jsonData(report);

        // assertEquals(expected, actual);
    }

}
