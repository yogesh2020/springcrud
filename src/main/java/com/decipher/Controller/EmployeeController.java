package com.decipher.Controller;

import com.decipher.Model.Employee;
import com.decipher.Service.EmployeeService;
import com.decipher.Service.EmployeeServiceImpl;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
/*@RequestMapping(value = "/control")*/
public class EmployeeController
   {
	@Autowired
    private EmployeeService employeeService;

	@RequestMapping(value = "hello")
	public String hello() {
        System.out.println("helloo yogesh sharma");
       	return "/hello";
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String viewemp(Model m, HttpServletRequest request)
     {
		System.out.println("controll");
		List<Employee> empList = employeeService.display();

   		HttpSession session = request.getSession();
		session.setAttribute("employeeList", empList);
		return "/display";
	}

	/*@RequestMapping(value = "/add",method = RequestMethod.POST)*/
             /*@RequestMapping(value = "/add")*/
       @PostMapping(value = "/add")
	public String insrt(Model m, HttpServletRequest request)
    {
     /* String YU = request.getParameter("phone");
        System.out.println(YU);
        return "y";*/

     Employee employee = new Employee();

     employee.setUserName(request.getParameter("username"));
     employee.setAddress(request.getParameter("address"));
     employee.setRollNumber(request.getParameter("roll"));
     employee.setPhone(request.getParameter("phone"));

        int count = employeeService.create(employee);

         if (count>0){
          return "/idexist";
         }
         else {
             return "/datainsert";
         }
              /*    String name = request.getParameter("username");
        System.out.println(name);
           String address = request.getParameter("address");
         String roll = request.getParameter("roll");
          String phone = request.getParameter("phone");
          int count =  employeeService.create(name,address,roll,phone);*/
    }
       @PostMapping(value = "/update")
    public String update(Model m,HttpServletRequest request)
    {
        String roll = request.getParameter("roll");

        System.out.println("devansh sharma");

       if (request.getParameter("button").equals("update"))
       {
           System.out.println("raju");

        int count = employeeService.chekroll(roll);

   if(count==0){
    return "/noresult";
   }
   else {
       System.out.println("kana");
       HttpSession session = request.getSession();
       session.setAttribute("rollNumber",roll);
       return "/updateform";
   }
       }

    else {
           System.out.println("uday");
           Employee employee = new Employee();

    employee.setUserName(request.getParameter("username"));
     employee.setAddress( request.getParameter("address"));
    employee.setPhone(request.getParameter("phone"));

    HttpSession session = request.getSession();
  String rollNumber= session.getAttribute("rollNumber").toString();
employee.setRollNumber(rollNumber);

     employeeService.updatedb(employee);
           return "/updated";
       }
    }
    @PostMapping(value = "/delete")
    public String delete(Model m,HttpServletRequest request)
    {
     String roll = (request.getParameter("roll"));
    int count = employeeService.deletedoc(roll);
    if (count==1)
    {
return "/deleted";
    }
else {
        return "noresult";
    }

    }

 }
