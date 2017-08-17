package com.baxter.dao;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.baxter.entity.Product;
@Transactional
@Component("productDao")
public class ProductDao {
	
	private JdbcTemplate jdbc;
	
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new JdbcTemplate(jdbc);
	}
	
	public Session createSession()
	{
		return sessionFactory.getCurrentSession();
	}
	
	@Transactional
	public void createProduct(Product product)
	{
		System.out.println("Creating product...");
		createSession().persist(product);
	}
	

}
