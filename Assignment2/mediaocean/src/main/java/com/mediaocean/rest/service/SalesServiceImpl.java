package com.mediaocean.rest.service;

import java.util.List;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mediaocean.rest.dao.SalesDaoIF;
import com.mediaocean.rest.exception.MediaOceanException;
import com.mediaocean.rest.beans.*;
import com.mediaocean.rest.service.SalesServiceIF;


@Service
@Qualifier("SalesService")
public class SalesServiceImpl implements SalesServiceIF {
	
	@Autowired
	@Qualifier("salesDAO")
	private SalesDaoIF salesDAO;
	
	
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	

	  @Override
	  public List<SalesDetails>  getAllProductsDetails() throws Exception,MediaOceanException{
	    
		  Session session= sessionFactory.openSession();
		  
		  List<SalesDetails>  SalesDetailsList=salesDAO.getAllProductsDetails(session);
		  
		  return SalesDetailsList;
		  
	  }
	  
	 /* @Override
	  public ListResult<PurchaseOrderInlineItem> getAllProductsDetails(){
		  
		  
	  }*/

}
