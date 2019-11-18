package com.decipher.dao;

import com.decipher.Model.Employee;

import java.util.List;

public interface EmployeeDao {
    public List<Employee> findAll();
   /* public void create(String name,String address,String roll,String phone);*/
    public void create(Employee employee);
      public int chekboxroll(String roll);
      public int chekboxname(String name);
      public  abstract  int chekroll(String roll);
      public abstract void updatedb(Employee employee);
      public abstract int chekdbroll(String roll);
      public abstract void deletedoc(String roll);
}
