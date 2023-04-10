package ge.ibsu.demo.controllers;

import ge.ibsu.demo.Entities.Customer;
import ge.ibsu.demo.Repositories.CustomerRepository;
import ge.ibsu.demo.Services.CustomerService;
import ge.ibsu.demo.dto.RequestData;
import ge.ibsu.demo.dto.SearchCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value="/search", method = RequestMethod.POST, produces = {"application/json"})
    public Slice<Customer> search(@RequestBody RequestData <SearchCustomer> rd) throws Exception{
        return customerService.search(rd.getData(), rd.getPaging());
    }
}
