package com.firstcode.practicecoding.controllers;

import com.firstcode.practicecoding.entities.Customer;
import com.firstcode.practicecoding.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class customerController {
    @Autowired
    CustomerService customerService;

    @RequestMapping("/showCustomer")
    public String showCustomerInfo() {
        String showCustomer = "showCustomer";
        return showCustomer;

    }

    @RequestMapping(value = "saveCustomerData")
    public String saveCustomerInfo(@ModelAttribute("Customer") Customer customer, ModelMap modelMap) {
        customerService.saveCustomerInfo(customer);
        modelMap.addAttribute("msg", "Record is saved successfully!!");
        String showCustomer = "showCustomer";
        return showCustomer;
    }
}
