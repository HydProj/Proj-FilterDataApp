package com.hit;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.hit.service.ProductFilterServiceImpl;


@SpringBootApplication
public class ProjFilterDataAppApplication {
	

	public static void main(String[] args) {
		
     ConfigurableApplicationContext ctx=SpringApplication.run(ProjFilterDataAppApplication.class, args);
     ProductFilterServiceImpl product=ctx.getBean("filter",ProductFilterServiceImpl.class);
     try {
       System.out.println(product.filterData());
        }
       catch(Exception e) {
    	   e.printStackTrace();
       }
       
}
	
}