package com.charter.charter.Controllers;

import com.charter.charter.models.Transaction;
import com.charter.charter.models.data.CustomerDao;
import com.charter.charter.models.data.TransactionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


//TODO Fix this garbage

@Controller
@RequestMapping("")
public class mainController {

    @Autowired
    TransactionDao transactionDao;

    @Autowired
    CustomerDao customerDao;

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("title", "Point System");
        Iterable<Transaction> transactionList = transactionDao.findAll();
        model.addAttribute("list", transactionList);
        return "index";
    }
}
