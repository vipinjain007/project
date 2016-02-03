package com.mediaocean.rest.dao;
import java.util.List;

import org.hibernate.*;
import org.hibernate.criterion.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Repository;

import com.mediaocean.rest.beans.ProductDetails;
import com.mediaocean.rest.beans.SalesDetails;
import com.mediaocean.rest.exception.MediaOceanException;

@Repository
@Qualifier("salesDAO")
public class SalesDaoImpl implements SalesDaoIF {
	
	private static final Logger log = LoggerFactory
			.getLogger(SalesDaoImpl.class);
	
	
	 public List<SalesDetails> getAllProductsDetails(Session session) throws Exception, MediaOceanException{
		 List<SalesDetails> salesDetailslist=null;
		 
	
		 
		 Criteria c = session.createCriteria(SalesDetails.class, "salesDetails");
         c.createAlias("salesDetails.productDetails", "productDetails");
		 c.add(Restrictions.eqProperty("salesDetails.productId", "productDetails.productId")).setProjection(Projections.projectionList()
                           .add(Projections.groupProperty("productDetails.productId"))
                           .add(Projections.property("productDetails.productName")) 
                           .add(Projections.sum("totalSale"))
                           .add(Projections.sum("totalAmount")));
		 salesDetailslist =(List<SalesDetails>)c.list();
		 
							
		  return salesDetailslist;
		  
	}

}
