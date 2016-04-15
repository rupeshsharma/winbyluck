package com.wbl.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "J_TICKET")
public class TicketModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -184082745183907472L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "PRODUCT")
	private ProductModel product;
	
	@Column(name="STATUS")
	private String status;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE", insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date createdDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "RESULT_DATE")
	private Date resultDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProductModel getProduct() {
		return product;
	}

	public void setProduct(ProductModel product) {
		this.product = product;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getResultDate() {
		return resultDate;
	}

	public void setResultDate(Date resultDate) {
		this.resultDate = resultDate;
	}

}
