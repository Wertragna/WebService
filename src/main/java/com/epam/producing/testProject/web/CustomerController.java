package com.epam.producing.testProject.web;

import com.epam.producing.testProject.model.Customer;
import com.epam.producing.testProject.repository.CustomersRepository;
import com.epam.producing.testProject.exceptions.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomersRepository repository;

    @GetMapping
    public List<Customer> getEmployees() {
        return repository.findAll();
    }

    @PostMapping
    public Customer newEmployee(@RequestBody Customer newCustomer) {
        return repository.save(newCustomer);
    }

    @GetMapping("/{id}")
    public Customer newEmployee(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
    }


    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
         repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void updateCustomer(@PathVariable Long id, @RequestBody Customer updateCustomer) {
        Customer customer = repository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
        customer.setName(updateCustomer.getName());
        customer.setRole(updateCustomer.getRole());
        repository.save(customer);
    }


}

