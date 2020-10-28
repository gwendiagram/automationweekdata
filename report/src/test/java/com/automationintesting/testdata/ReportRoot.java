package com.automationintesting.testdata;

import java.util.List;

public class ReportRoot {
    public ReportRoot(String name, List<ReportItem> reportItemList) {
        this.report = reportItemList;
    }

    List<ReportItem> report;
}
