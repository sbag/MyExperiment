package com.baxter.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baxter.dao.ProductDao;
import com.baxter.entity.Product;

public class App {

	public static void main(String[] args) {
			AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
			
			Product product = new Product("Apple Phone",1,500.00);
			ProductDao dao = (ProductDao)context.getBean("productDao");
			dao.createProduct(product);
			context.close();
	}

}
