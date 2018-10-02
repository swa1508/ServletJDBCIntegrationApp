package com.app.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dao.IEmployeeDao;
import com.app.factory.EmployeeFactoryDao;
import com.app.model.Employee;

public class EmployeeRegisterServlet extends HttpServlet {
public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	resp.setContentType("text/html");
	PrintWriter out = resp.getWriter();
	
	RequestDispatcher rd = req.getRequestDispatcher("EmpReg.html");
	rd.include(req, resp);
	
	//1.get the parameter
	String empId = req.getParameter("empId");
	String empName = req.getParameter("empName");
	String empGen = req.getParameter("empGen");
	String empAddr = req.getParameter("empAddr");
	
	//2. parase the data
	int eid = Integer.parseInt(empId);
	
	//3. create the model class object
	
	Employee emp = new Employee();
	
	//4. setting the data to the model class on=bject
	emp.setEmpId(eid);
	emp.setEmpName(empName);
	emp.setEmpGen(empGen);
	emp.setEmpAddr(empAddr);
	
	//5. create the dao class factory object
	
	IEmployeeDao dao = EmployeeFactoryDao.getDao();
	
	//6. call the insert method 
	
	int count = dao.insertEmployee(emp);
	
	//7. print final message
	
	if(count == 1)
	{
		out.println("Successfully inserted Employee by id = "+eid);
	}else {
		out.println("Failed to inserted..");
	}
}
}
