package org.springsource.samples.cloudburst;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CloudBurstDemo {
	
	public static void main(String[] args) {
	  AbstractApplicationContext integrationContext = 
		new ClassPathXmlApplicationContext("classpath:META-INF/spring/*-context.xml");
	  integrationContext.registerShutdownHook();
	}
	
}