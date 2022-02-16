package com.firstcode.practicecoding.controllers;

import java.util.List;

import com.firstcode.practicecoding.Repositories.Repository;
import com.firstcode.practicecoding.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CustomerRestController2 {

	@Autowired
	private Repository customerRepo;

	@GetMapping("/text")
	public String text(){
		return "text";
	}

	@GetMapping("/Customer")
	public List<Customer> getAllCustomer() {
		return customerRepo.findAll();
	}
	
	@PostMapping("/newAdd")							//save the data
	public String saveCustomer(@RequestBody Customer customer) {
		customerRepo.save(customer);
		return "Added";


	}

	@PutMapping("/update")						//update the data
	public String updateCustomer(@RequestBody Customer customer) {
		customerRepo.save(customer);
		return "saved";
	}

}
