package me.msc.integration;

import me.msc.collection.domain.Customer;
import me.msc.collection.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jiachiliu on 2/16/15.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:integration-context.xml"})
public class CustomerRepositoryIntegrationTest {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void testReadCustomers() {
        assertNotNull(customerRepository);
        List<Customer> customers = customerRepository.findAll();
        assertEquals(4, customers.size());
    }
}
