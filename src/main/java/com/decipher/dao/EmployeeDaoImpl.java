package com.decipher.dao;

import java.util.ArrayList;
import java.util.List;

import com.decipher.dao.Connection;
import com.decipher.dao.EmployeeDao;
import com.mongodb.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.decipher.Model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

@Autowired
private Connection connObj;


	@Override
	public List<Employee> findAll() {
		DBCollection collection = connObj.getCollection();
		DBCursor cursor = collection.find();
		List<Employee> emplist = new ArrayList<Employee>();

		while (cursor.hasNext())
		{
			DBObject empDBObject = cursor.next();
			Employee employee = new Employee();
			employee.setUserName(empDBObject.get("userName").toString());
			employee.setAddress(empDBObject.get("address").toString());
			employee.setRollNumber(empDBObject.get("rollNumber").toString());
			employee.setPhone(empDBObject.get("phone").toString());
			emplist.add(employee);
        		}
		return emplist;
	}

	@Override
	public void create(Employee employee)
	{
DBCollection collection = connObj.getCollection();
DBObject document = new BasicDBObject();
document.put("userName",employee.getUserName());
document.put("address",employee.getAddress());
document.put("rollNumber",employee.getRollNumber());
document.put("phone",employee.getPhone());
collection.insert(document);
     	}

	@Override
	public int chekboxroll( String roll) {
		DBCollection collection = connObj.getCollection();
		DBObject query = new BasicDBObject("rollNumber",roll) ;
  return collection.find(query).count();
	}

	@Override
	public int chekboxname(String name) {
  DBObject query = new BasicDBObject("userName",name);
           DBCollection collection = connObj.getCollection();
		return collection.find(query).count();
	}

	@Override
	public int chekroll(String roll) {
 DBObject query = new BasicDBObject("rollNumber",roll);
 DBCollection collection= connObj.getCollection();
 return collection.find(query).count();

	}

	@Override
	public void updatedb(Employee employee)
	  {
  DBObject query = new BasicDBObject("rollNumber",employee.getRollNumber());

  BasicDBObject document = new BasicDBObject();

  document.put("userName",employee.getUserName());
  document.put("address",employee.getAddress());
  document.put("phone",employee.getPhone());

  /*document.put("$set",document);*/

 DBObject update = new BasicDBObject();
 update.put("$set",document);

 DBCollection collection = connObj.getCollection();
collection.update(query,update);
	}

	@Override
	public int chekdbroll(String roll)
	{
		DBObject query = new BasicDBObject("rollNumber",roll);
DBCollection collection	= connObj.getCollection();
return collection.find(query).count();

	}

	@Override
	public void deletedoc(String roll)
	{
DBObject query = new BasicDBObject("rollNumber",roll);
DBCollection collection = connObj.getCollection();
collection.remove(query);
	}

}
