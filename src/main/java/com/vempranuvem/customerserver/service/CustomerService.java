package com.vempranuvem.customerserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vempranuvem.customerserver.exception.CustomerAlreadExistsException;
import com.vempranuvem.customerserver.exception.CustomerNotFoundException;
import com.vempranuvem.customerserver.model.Customer;
import com.vempranuvem.customerserver.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository repository;

	public List<Customer> findAll() {
		return repository.findAll();
	}

	public Customer getById(String cpf) {
		return repository.findById(cpf).orElseThrow(() -> new CustomerNotFoundException(cpf));
	}

	public Customer save(Customer newCustomer) {
		if (isPresent(newCustomer.getCpf())) {
			throw new CustomerAlreadExistsException();
		}
		return repository.save(newCustomer);
	}

	public Customer update(String id, Customer customer) {
		if (!isPresent(id)) {
			new CustomerNotFoundException(id);
		}
		customer.setCpf(id);
		return repository.save(customer);
	}

	public void deleteById(String id) {
		if (!isPresent(id)) {
			new CustomerNotFoundException(id);
		}
		repository.deleteById(id);
	}

	private Boolean isPresent(String id) {
		return repository.findById(id).isPresent();
	}

}
