package me.msc.collection.controller;

import me.msc.collection.domain.Customer;
import me.msc.collection.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by jiachiliu on 2/12/15.
 */

@Controller
@RequestMapping("/collection")
public class CollectionController {

    @Autowired
    CustomerRepository customerRepository;

    @RequestMapping("/customers")
    public
    @ResponseBody
    List<Customer> customers() {
        List<Customer> customers = customerRepository.findAll();
        System.out.println(customers);
        return customers;
    }
}
