package com.denisabramov.postings.service.processor;

import com.opencsv.processor.RowProcessor;

public class TrimTabsProcessor implements RowProcessor {
    @Override
    public String processColumnItem(String column) {
        return column.trim();
    }

    @Override
    public void processRow(String[] row) {
        for (int i = 0; i < row.length; i++) {
            row[i] = processColumnItem(row[i]);
        }
    }
}
