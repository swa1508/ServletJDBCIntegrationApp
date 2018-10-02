package com.app.factory;

import com.app.dao.IEmployeeDao;
import com.app.dao.impl.EmployeeDaoImpl;

public class EmployeeFactoryDao {
	
	public static IEmployeeDao getDao()
	{
		return new EmployeeDaoImpl();
	}

}
