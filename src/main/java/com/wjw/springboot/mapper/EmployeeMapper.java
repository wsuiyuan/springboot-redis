package com.wjw.springboot.mapper;

import com.wjw.springboot.bean.Employee;
import org.apache.ibatis.annotations.*;

/**
 * Created by wujianwei on 2018/11/1 0001.
 */
@Mapper
public interface EmployeeMapper {

    @Select("SELECT * FROM employee where id = #{id}")
    public Employee getEmployeeById(Integer id);

    @Update("UPDATE employee SET lastName = #{lastName}, email = #{email}, gender = #{gender}, d_id = #{dId} where id = #{id} ")
    public void updateEmp(Employee employee);

    @Delete("DELETE FROM employee WHERE id = #{id}")
    public void deleteEmpById(Integer id);
/*
    @Insert("INSERT INTO employee(lastName, email, gender, d_id) values(#{lastName}, #{email}, #{gender), #{dId})")
    public void insertEmployee(Employee employee);*/
}
