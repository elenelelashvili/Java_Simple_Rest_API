package ge.ibsu.demo.controllers;

import ge.ibsu.demo.Entities.Customer;
import ge.ibsu.demo.Repositories.CustomerRepository;
import ge.ibsu.demo.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @RequestMapping(value="/all", method = RequestMethod.GET, produces = {"application/json"})
    public List<Customer> getAll(){
        return customerService.getAllCustomer();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET, produces = {"application/json"})
    public Customer getById(@PathVariable long id) throws Exception{
        return customerService.getCustomerById(id);
    }
}
