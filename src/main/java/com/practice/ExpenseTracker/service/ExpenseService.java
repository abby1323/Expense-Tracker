package com.practice.ExpenseTracker.service;

import com.practice.ExpenseTracker.model.Expense;
import com.practice.ExpenseTracker.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExpenseService {

    //repository
    private final ExpenseRepository expenseRepository;


    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public List<Expense> getAllExpense() {
        return expenseRepository.findAll();
    }

    public Expense addExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public Expense updateExpense(Expense expense) {
        List<Expense> expenseList = expenseRepository.findAll().stream().map(
                x -> x.getId()==expense.getId()?expense:x)
                        .collect(Collectors.toList());
        expenseRepository.saveAll(expenseList);
        return expense;

    }

    public String deleteExpense(Integer id) {

        List<Expense> expenseList = expenseRepository.findAll();
        boolean b = expenseList.removeIf(x -> expenseList.contains(expenseRepository.findById(id)));
        return b?"Deleted":"Not able to delete";
    }
}
