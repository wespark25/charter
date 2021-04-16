package com.charter.charter.Controllers;

import com.charter.charter.models.Transaction;
import com.charter.charter.models.TransactionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


//TODO Fix this garbage

@Controller
@RequestMapping("")
public class mainController {

    @Autowired
    TransactionDao transactionDao;

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("title", "Point System");
        Iterable<Transaction> transactionList = transactionDao.findAll();
        model.addAttribute("list", transactionList);
        return "index";
    }
}
