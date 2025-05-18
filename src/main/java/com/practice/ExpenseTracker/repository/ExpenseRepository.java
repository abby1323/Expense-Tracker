package com.practice.ExpenseTracker.repository;

import com.practice.ExpenseTracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ExpenseRepository extends JpaRepository<Expense,Integer> {


}
