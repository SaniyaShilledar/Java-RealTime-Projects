package com.infotech.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.infotech.dao.EmployeeDAO;
import com.infotech.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	public DataSource getDataSource() {
		return dataSource;
	}
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public List<Employee> getAllDetail() {
		String SQL="SELECT * FROM EMPLOYEE";
		return jdbcTemplate.query(SQL, new EmployeeRowMapper());
	
	}

}
