package com.denisabramov.postings.service;

import com.denisabramov.postings.dao.entity.Posting;
import com.denisabramov.postings.dao.entity.User;
import com.denisabramov.postings.service.processor.TrimTabsProcessor;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;

@Service
public class CsvReader {
    private static final String LOGINS_FILE = "src/main/resources/logins.csv";
    private static final String POSTINGS_FILE = "src/main/resources/postings.csv";

    public List<User> readLogins() throws FileNotFoundException {
        Reader reader = new FileReader(LOGINS_FILE);
        var csvReader = new CSVReaderBuilder(reader)
                .withRowProcessor(new TrimTabsProcessor())
                .build();
        return new CsvToBeanBuilder<User>(csvReader)
                .withType(User.class)
                .build()
                .parse();
    }

    public List<Posting> readPostings() throws FileNotFoundException {
        Reader reader = new FileReader(POSTINGS_FILE);
        return new CsvToBeanBuilder<Posting>(reader)
                .withType(Posting.class)
                .withSeparator(';')
                .build()
                .parse();
    }

}
