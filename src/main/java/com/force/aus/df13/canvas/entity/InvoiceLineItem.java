package com.force.aus.df13.canvas.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="invoiceLineItem")
public class InvoiceLineItem {

	@Id
	@GeneratedValue(generator="line_item_seq")
	@SequenceGenerator(name="line_item_seq", sequenceName="line_item_seq", allocationSize=1)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;

	@ManyToOne
	@JoinColumn(name="invoice_id")
	private Invoice invoice;
	
	private BigDecimal lineItemPrice;
	
	private int quantity;
	
	@Transient
	private BigDecimal lineItemTotal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public BigDecimal getLineItemPrice() {
		return lineItemPrice;
	}

	public void setLineItemPrice(BigDecimal lineItemPrice) {
		this.lineItemPrice = lineItemPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getLineItemTotal() {
		return lineItemTotal;
	}

	public void setLineItemTotal(BigDecimal lineItemTotal) {
		this.lineItemTotal = lineItemTotal;
	}

	/*
	 * Override hash code and equals methods so that using these in a Set will work.
	 * Plenty of doc about it on Hibernate, quick explanation here 
	 * http://stackoverflow.com/questions/1638723/equals-and-hashcode-in-hibernate
	 *
	 * 
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((lineItemPrice == null) ? 0 : lineItemPrice.hashCode());
		result = prime * result
				+ ((lineItemTotal == null) ? 0 : lineItemTotal.hashCode());
		result = prime * result + ((invoice == null) ? 0 : invoice.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + quantity;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceLineItem other = (InvoiceLineItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lineItemPrice == null) {
			if (other.lineItemPrice != null)
				return false;
		} else if (!lineItemPrice.equals(other.lineItemPrice))
			return false;
		if (lineItemTotal == null) {
			if (other.lineItemTotal != null)
				return false;
		} else if (!lineItemTotal.equals(other.lineItemTotal))
			return false;
		if (invoice == null) {
			if (other.invoice != null)
				return false;
		} else if (!invoice.equals(other.invoice))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}
	
	
	
}
