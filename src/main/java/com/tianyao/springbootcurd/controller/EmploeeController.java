package com.tianyao.springbootcurd.controller;

import com.tianyao.springbootcurd.dao.EmployeeDao;
import com.tianyao.springbootcurd.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class EmploeeController {
    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/emps")
    public String emps(ModelMap model){
        Collection<Employee> emps = employeeDao.getAll();
        model.put("emps",emps);
        return "emp/list";
    }
}
