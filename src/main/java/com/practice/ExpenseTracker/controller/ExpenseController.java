package com.practice.ExpenseTracker.controller;

import com.practice.ExpenseTracker.model.Expense;
import com.practice.ExpenseTracker.service.ExpenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/expensetracker")
public class ExpenseController {

    //service
    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/home")
    public ResponseEntity home(){
        return ResponseEntity.ok("Welcome to Expense Tracker");
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