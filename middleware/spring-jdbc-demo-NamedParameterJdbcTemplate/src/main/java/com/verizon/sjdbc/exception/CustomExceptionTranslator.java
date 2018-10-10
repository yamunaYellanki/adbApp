package com.verizon.sjdbc.exception;

import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.support.SQLExceptionTranslator;
import org.springframework.stereotype.Component;


//this is all to convert a SQL exception to DataAccessException just to make it runtime
@Component("customExceptionTranslator")
public class CustomExceptionTranslator implements SQLExceptionTranslator {
	
	@SuppressWarnings("serial")
	@Override
	public DataAccessException translate(String task,String sql,
				SQLException exception)
	{
		return new DataAccessException(exception.toString()){
	};
	}

}

