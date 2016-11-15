package com.perficient.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@ComponentScan({ "com.perficient" })
@EnableConfigurationProperties
@EnableAspectJAutoProxy
public class App {
//	private App(){
//		
//	}
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);//NOSONAR 
	}
}
