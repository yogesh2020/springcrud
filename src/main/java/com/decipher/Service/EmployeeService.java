package com.decipher.Service;

import com.decipher.Model.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> display();

   /* public int create(String name,String address,String roll,String phone);*/
    public int create(Employee employee);
    public abstract int chekroll(String roll);
    public  abstract void updatedb(Employee employee);
    public abstract int deletedoc(String roll);
}
