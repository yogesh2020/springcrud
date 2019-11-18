package com.decipher.Service;

import java.util.List;

import com.decipher.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.decipher.Model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	/*EmployeeDao employeeDao = new EmployeeDaoImpl();*/

	@Autowired
	private EmployeeDao employeeDao;

	public List<Employee> display()
	{
		return employeeDao.findAll();
	}

	@Override
	public int create(Employee employee)
	  {
		int countRoll = employeeDao.chekboxroll(employee.getRollNumber());
		int countName = employeeDao.chekboxname(employee.getUserName());
		  System.out.println(countRoll+" "+countName);
		if (countRoll==0 && countName==0){
			employeeDao.create(employee);
			return countRoll;
		}
		return 1;
}

	@Override
	public int chekroll(String roll)
	{
return employeeDao.chekroll(roll);

	}

	@Override
	public void updatedb(Employee employee)
	{
employeeDao.updatedb(employee);
	}
@Override
	public int deletedoc(String roll)
   {
  int count = employeeDao.chekdbroll(roll);

if(count==1)
{
employeeDao.deletedoc(roll);
}
	   return count;
      }

}
