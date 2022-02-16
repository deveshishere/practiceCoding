package com.firstcode.practicecoding.services;

import com.firstcode.practicecoding.Repositories.Repository;
import com.firstcode.practicecoding.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceimpl implements CustomerService {
	
	@Autowired
	private Repository CustomerRepo;

	@Override
	public void saveCustomerInfo(Customer customer) {
		CustomerRepo.save(customer);
	}


}
