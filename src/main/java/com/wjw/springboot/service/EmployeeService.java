package com.wjw.springboot.service;

import com.wjw.springboot.bean.Employee;
import com.wjw.springboot.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by wujianwei on 2018/11/1 0001.
 */
@CacheConfig(cacheNames = "emp", cacheManager = "employeeCacheManager")
@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    @Cacheable()
    public Employee getById(Integer id){
        System.out.println("查询id为" + id + "的员工");
        return employeeMapper.getEmployeeById(id);
    }

    @CachePut(key = "#result.id")
    public Employee updateEmp(Employee employee){
        System.out.println("update employee :" + employee.getId());
        employeeMapper.updateEmp(employee);
        return employee;
    }

    @CacheEvict(beforeInvocation = true)
    public void  deleteEmpById(Integer id){
        System.out.println("delete Employee where id = " + id);
        employeeMapper.deleteEmpById(id);
    }
}
