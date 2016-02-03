package com.mediaocean.rest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.mediaocean.rest.beans.SalesDetails;
import com.mediaocean.rest.dao.SalesDaoIF;
import com.mediaocean.rest.responseUtil.ResponseObj;
import com.mediaocean.rest.responseUtil.Status;
import com.mediaocean.rest.service.SalesServiceIF;
/*import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;*/
/**
 * @author mmediaocean
 *
 */



//@Api(value = "Sales Order", description = "Sales Order web services")
@Controller
@RequestMapping("salesDetails")
public class SalesHomeController {
	private final Logger _log = LoggerFactory.getLogger(SalesHomeController.class);
	
	
	
	@Autowired
	@Qualifier("SalesService")
	private SalesServiceIF SalesService;
	
	@RequestMapping(value = "get/products/all", method = RequestMethod.GET)
	@ResponseBody
	public  ResponseObj  getAllProductsDetails(@RequestHeader("AUTHENTICATION_ID") String tokenId) {
		List<SalesDetails>  salesDetails=null;
		ResponseObj response=new ResponseObj();
		try{
		_log.info("rest - All Product Details");
		
		     salesDetails    = SalesService.getAllProductsDetails();
		     response.setStatus(Status.SUCCESS);
		     response.setResult(salesDetails);
		
		}catch(Exception e){
			e.printStackTrace();
			response.setStatus(Status.FAILURE);
		     response.setResult(salesDetails);
		}
		return response;	
	}
	
	
	
	
	
}
