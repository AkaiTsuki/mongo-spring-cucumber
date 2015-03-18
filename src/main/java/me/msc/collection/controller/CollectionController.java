package me.msc.collection.controller;

import me.msc.collection.domain.Customer;
import me.msc.collection.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * Created by jiachiliu on 2/12/15.
 */

@Controller
@RequestMapping("/collection")
public class CollectionController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    private MongoOperations mongoOperations;

    @RequestMapping("/customer")
    public
    @ResponseBody
    List<Customer> customers() {
        List<Customer> customers = customerRepository.findAll();
        System.out.println(customers);
        return customers;
    }

    @RequestMapping("/customer/{firstName}")
    public
    @ResponseBody
    List<Customer> viewCustomersByFirstName(@PathVariable String firstName) {
        return customerRepository.findByFirstName(firstName);
    }

    @RequestMapping("/all")
    public @ResponseBody Set<String> listDatabases(){
        return mongoOperations.getCollectionNames();
    }
}
