package com.vempranuvem.customerserver.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String cpf;

	@Column(length = 10, nullable = false)
	@NotEmpty(message = "The rg cannot be empty")
	private String rg;

	@Column(length = 50, nullable = false)
	@NotEmpty(message = "The name cannot be empty")
	private String name;

	@Column(length = 50, nullable = false)
	@NotEmpty(message = "The email cannot be empty")
	private String email;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "id", nullable = false)
	@NotNull
	private CustomerAddress customerAddress;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinTable(name = "customer_contacts", joinColumns = { @JoinColumn(name = "customer_id") }, inverseJoinColumns = {
			@JoinColumn(name = "contact_id") })
	private Set<Contact> contacts = new HashSet<>();

	public Customer() {
	}

	public Customer(String cpf, String name, CustomerAddress customerAddress) {
		this.cpf = cpf;
		this.name = name;
		this.customerAddress = customerAddress;
	}

	public Customer(String cpf, String rg, String name, String email, CustomerAddress customerAddress,
			Set<Contact> contacts) {
		this.cpf = cpf;
		this.rg = rg;
		this.name = name;
		this.email = email;
		this.customerAddress = customerAddress;
		this.contacts = contacts;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public CustomerAddress getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(CustomerAddress customerAddress) {
		this.customerAddress = customerAddress;
	}

	public Set<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
		Customer other = (Customer) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [contacts=" + contacts + ", cpf=" + cpf + ", customerAddress=" + customerAddress + ", name="
				+ name + ", rg=" + rg + "]";
	}

}
