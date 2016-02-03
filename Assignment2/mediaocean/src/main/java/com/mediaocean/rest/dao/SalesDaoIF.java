package com.mediaocean.rest.dao;

import java.util.List;

import org.hibernate.Session;

import com.mediaocean.rest.beans.ProductDetails;
import com.mediaocean.rest.beans.SalesDetails;
import com.mediaocean.rest.exception.MediaOceanException;

public interface SalesDaoIF {
	
	public List<SalesDetails> getAllProductsDetails(Session session) throws Exception, MediaOceanException;

}
