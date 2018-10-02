package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.app.dao.IEmployeeDao;
import com.app.model.Employee;
import com.app.util.ConnUtil;

public class EmployeeDaoImpl implements IEmployeeDao{

	@Override
	public int insertEmployee(Employee emp) {
		
		String sql = "insert into emptabs values(?,?,?,?)";
		Connection con = null;
		PreparedStatement pstmt = null;
		int count = 0;
		
		try {
			
			//1. get the connection
			con = ConnUtil.getConnection();
			
			//2. create statement object
			pstmt = con.prepareStatement(sql);
			
			//3. set data to emp object
			pstmt.setInt(1, emp.getEmpId());
			pstmt.setString(2, emp.getEmpName());
			pstmt.setString(3, emp.getEmpGen());
			pstmt.setString(4, emp.getEmpAddr());
			
			//4. execute update 
			count = pstmt.executeUpdate();
		
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
	
		return count;
	}

}
