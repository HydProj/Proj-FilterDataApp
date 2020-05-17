package com.hit.dao;

import java.io.IOException;
import java.util.List;

import com.hit.bo.Product;

public interface ProductDao {
	
	public List<Product> getRecord()throws IOException;

}
