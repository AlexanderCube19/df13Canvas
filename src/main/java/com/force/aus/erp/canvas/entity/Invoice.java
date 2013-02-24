package com.force.aus.erp.canvas.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="invoice")
public class Invoice {

	@Id
	@GeneratedValue(generator="invoice_seq")
	@SequenceGenerator(name="invoice_seq", sequenceName="invoice_seq", allocationSize=1)
	private Long id;
	
	private Date invoiceDate;
	
	@OneToMany(mappedBy="invoice", fetch=FetchType.LAZY, cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private Set<InvoiceLineItem> lineItems;

	@ManyToOne
	@JoinColumn(name="account_id")
	private Account account;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public Set<InvoiceLineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(Set<InvoiceLineItem> lineItems) {
		this.lineItems = lineItems;
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
				+ ((invoiceDate == null) ? 0 : invoiceDate.hashCode());
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
		Invoice other = (Invoice) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (invoiceDate == null) {
			if (other.invoiceDate != null)
				return false;
		} else if (!invoiceDate.equals(other.invoiceDate))
			return false;
		return true;
	}

}
