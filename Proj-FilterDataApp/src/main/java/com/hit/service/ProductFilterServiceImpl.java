package com.hit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hit.bo.Product;
import com.hit.dao.ProductDao;

@Service("filter")
public class ProductFilterServiceImpl{
	private ProductDao dao=null;

	//performing injection
	@Autowired
	public  ProductFilterServiceImpl(ProductDao dao) {
		this.dao=dao;
	}//constructor

	
	public List<Product> filterData() throws Exception {
		List<Product> getProductList=null;
		Stream<Product> lStream;
		Stream<Product> fData;

		getProductList=new ArrayList<Product>();
		//get record from the file
		getProductList=dao.getRecord();

		//adding collection to stream
		lStream=getProductList.stream();
		//filtering data
		fData=lStream.filter(pro->pro.getpPrice()>=5000);

		//convert stream to arraylist

		List<Product> resultProductList =fData 
				.collect(Collectors 
						.toCollection(ArrayList::new)); 

		// Return the ArrayList 
		return resultProductList; 
	} //methode

}//class


