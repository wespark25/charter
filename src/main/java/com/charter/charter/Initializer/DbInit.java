package com.charter.charter.Initializer;

import com.charter.charter.models.Customer;
import com.charter.charter.models.Transaction;
import com.charter.charter.models.data.CustomerDao;
import com.charter.charter.models.data.TransactionDao;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.Reader;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class DbInit implements CommandLineRunner {

    @Autowired
    private TransactionDao transactionDao;

    @Autowired
    private CustomerDao customerDao;

    @Override
    public void run(String... args) throws Exception {
        if (transactionDao.count() == 0) {
            //Found an excellent resource for parsing CSV files from. I also made it so the CSV file is always read in from the correct path.
            Reader in = new FileReader(System.getProperty("user.dir") + "/src/main/java/com/charter/charter/Initializer/transactions.csv");
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.withHeader().parse(in);
            for (CSVRecord record : records) {
                String name = record.get("name");
                if (customerDao.existsByName(name) == false) {
                    Customer customer = new Customer(name);
                    customerDao.save(customer);
                }

                Customer customer = customerDao.findByName(name);
                Transaction transaction = new Transaction(customer, Integer.parseInt(record.get("receipt")),assignDate());
                customer.addpoints(transaction.getPoints());
                transactionDao.save(transaction);
                customerDao.save(customer);
            }

            System.out.println(customerDao.findByName("Robin Park").getPoints());
        }


    }
    //Method for generating random date within the past year. I merged ideas from two solutions I found online to create something that works for this specific task.
    //I'm keeping the logic for this outside of the Transaction class because, hypothetically, if this is app was actually being used in the future this method would be unnecessary
    public static Date assignDate() {

        Date today = Date.from(ZonedDateTime.now().toInstant());
        Date oneYearAgo = Date.from(ZonedDateTime.now().minusYears(1).toInstant());


        long startMillis = oneYearAgo.getTime();
        long endMillis = today.getTime();
        long randomMillisSinceEpoch = ThreadLocalRandom
                .current()
                .nextLong(startMillis, endMillis);

        return new Date(randomMillisSinceEpoch);
    }
}
