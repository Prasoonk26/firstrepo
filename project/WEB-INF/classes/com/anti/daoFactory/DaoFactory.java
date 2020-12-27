package com.anti.daoFactory;

import com.anti.dao.Dao;
import com.anti.dao.DaoImpl;

public class DaoFactory {

	public static  Dao getInstance()
	{
		return new DaoImpl();
		
	}
}
