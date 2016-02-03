package com.mediaocean.rest.service;

import java.util.List;

import com.mediaocean.rest.beans.SalesDetails;
import com.mediaocean.rest.exception.MediaOceanException;

public interface SalesServiceIF {
	
	public List<SalesDetails>  getAllProductsDetails()throws Exception,MediaOceanException;
	
	

}
