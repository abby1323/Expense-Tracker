package com.practice.ExpenseTracker.controller;

import com.practice.ExpenseTracker.model.Expense;
import com.practice.ExpenseTracker.service.ExpenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/api/v1/expensetracker")
public class ExpenseController {

    //service
    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

//    @GetMapping("/thymeleaf")
//    public String home(Model model) {
//        model.addAttribute("name", "Spring Boot User");
//        return "index"; // corresponds to index.html
//    }

    @GetMapping("/home")
    public String home(Model model){
        return "home";
    }

    @PostMapping("/switch")
    public String handleAction(@RequestParam("action") String action, Model model) {
        if ("addExpense".equals(action)) {
            return "addExpense";
        }else if ("updateExpense".equals(action)){
            return "updateExpense";
        }else if ("deleteExpense".equals(action)) {
            return "deleteExpense";
        } else if ("viewAll".equals(action)) {
            List<Expense> expenseList = expenseService.getAllExpense();
            model.addAttribute("expenses", "expenseList");
            return "viewAll";
        } else if ("viewSummary".equals(action)) {
            return "viewSummary";
        }else if ("viewSummaryMonthly".equals(action)) {
            return "viewSummaryMonthly";
        } else {
            return "invalidOption";
        }
    }

    @PostMapping("/expenseAdd")
    public String processAddExpense(@RequestParam String name,
                                    @RequestParam String amount,
                                    Model model){
        expenseService.addExpense(name,amount);
        return "expenseAdded";
    }

    @GetMapping("/expenses")
    public List<Expense> getAllExpense(){
        return expenseService.getAllExpense();
    }

    @PostMapping("/addExpense")
    public Expense addExpense(@RequestBody Expense expense){
        return expenseService.addExpense(expense);
    }

    @PutMapping("updateExpense")
    public Expense updateExpense(@RequestBody Expense expense){
        return expenseService.updateExpense(expense);
    }

    @DeleteMapping("deleteExpense")
    public String deleteExpense(@RequestBody Integer id){
        return expenseService.deleteExpense(id);
    }
}