package com.mediaocean.rest.beans;

import java.io.Serializable;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "SalesEntry")
//@NamedQueries({
//		   @NamedQuery(name = "SalesDetails.findAll", query = "SELECT s  FROM SalesDetails s,s.productDetails p where s.productId = s.productDetails.productId group by s.productDetails.productId "), })
public class SalesDetails implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Basic(optional = false)
	@Column(name = "sales_id")
	private int salesId;
	
	
	@ManyToOne(targetEntity = ProductDetails.class)
	@JoinColumn(name = "product_id", referencedColumnName = "product_id", insertable = false, updatable = false)
	private ProductDetails productDetails;
	
	@Column(name = "product_id")
	private int productId;
	
	@Column(name = "date_of_sale")
	private Timestamp dateofSale;
	
	
	@Column(name = "totals_sale")
	private long totalSale;
	
	
	@Column(name = "totals_amount")
	private long totalAmount;


	/**
	 * @return the salesId
	 */
	public int getSalesId() {
		return salesId;
	}


	/**
	 * @param salesId the salesId to set
	 */
	public void setSalesId(int salesId) {
		this.salesId = salesId;
	}


	/**
	 * @return the productDetails
	 */
	public ProductDetails getProductDetails() {
		return productDetails;
	}


	/**
	 * @param productDetails the productDetails to set
	 */
	public void setProductDetails(ProductDetails productDetails) {
		this.productDetails = productDetails;
	}


	/**
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}


	/**
	 * @param productId the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}


	/**
	 * @return the dateofSale
	 */
	public Timestamp getDateofSale() {
		return dateofSale;
	}


	/**
	 * @param dateofSale the dateofSale to set
	 */
	public void setDateofSale(Timestamp dateofSale) {
		this.dateofSale = dateofSale;
	}


	/**
	 * @return the totalSale
	 */
	public long getTotalSale() {
		return totalSale;
	}


	/**
	 * @param totalSale the totalSale to set
	 */
	public void setTotalSale(long totalSale) {
		this.totalSale = totalSale;
	}


	/**
	 * @return the totalAmount
	 */
	public long getTotalAmount() {
		return totalAmount;
	}


	/**
	 * @param totalAmount the totalAmount to set
	 */
	public void setTotalAmount(long totalAmount) {
		this.totalAmount = totalAmount;
	}
	


}
