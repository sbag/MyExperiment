package com.baxter.helloWS;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class HelloWorld {
	@WebMethod
	public String sayHello()
	{
		return "Hello World";
	}

}
