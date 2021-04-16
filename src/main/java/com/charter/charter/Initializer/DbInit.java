package com.charter.charter.Initializer;

import com.charter.charter.models.Transaction;
import com.charter.charter.models.TransactionDao;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.Reader;

@Service
public class DbInit implements CommandLineRunner {

    @Autowired
    private TransactionDao transactionDao;

    @Override
    public void run(String... args) throws Exception {
        if(transactionDao.count() == 0){
            //TODO Shorten file path
            Reader in = new FileReader("/Users/wesleypark/Downloads/charter/src/main/java/com/charter/charter/Initializer/transactions.csv");
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.withHeader().parse(in);
            for (CSVRecord record : records) {
                Transaction transaction = new Transaction(record.get("name"),Integer.parseInt(record.get("receipt")));
                transactionDao.save(transaction);
            }
        }
    }
}
