package com.hit.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.hit.bo.Product;

@Repository("productdao")
public class ProductDaoImpl implements ProductDao {

	@Override
	public List<Product> getRecord() throws IOException {
	        List<Product> productResultList=null;
			BufferedReader reader=null;
			Product product=null;
			String line=null;
			productResultList=new ArrayList<Product>();
			//productResultList=new ArrayList<Product>();
			//load and read the file data line by line
			reader=new BufferedReader(new FileReader("F:\\product.csv"));
			//read line from files
			line=reader.readLine();
			//read upto reach EOF
			while(line!=null) {
				String[] record=line.split(",");
				product=getProductBean(record);

				//adding one record of product to list
				productResultList.add(product);
				//read next line
				line=reader.readLine();
			}//while 

			return productResultList;

		}//methode

		//convert String data to required value and Returning product object
		public Product getProductBean(String[] rawData) {
			int id;
			String name;
			double price;
			id=Integer.parseInt(rawData[0]);
			name=rawData[1];
			price=Integer.parseInt(rawData[2]);
			 
			return new Product(id,name,price);


		}//methode

	}//class











