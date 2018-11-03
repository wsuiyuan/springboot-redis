package com.wjw.springboot.controller;

import com.wjw.springboot.bean.Employee;
import com.wjw.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wujianwei on 2018/11/1 0001.
 */
@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping("get/{id}")
    public Employee getById(@PathVariable("id") Integer id){
        return employeeService.getById(id);
    }

    @RequestMapping("update")
    public Employee update(Employee employee){
        employeeService.updateEmp(employee);
        return employee;
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        employeeService.deleteEmpById(id);
        return "success";
    }
}
