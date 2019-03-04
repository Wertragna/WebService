package com.epam.producing.testProject.web;

import com.epam.producing.testProject.exceptions.AddressNotFoundException;
import com.epam.producing.testProject.exceptions.CustomerNotFoundException;
import com.epam.producing.testProject.model.Address;
import com.epam.producing.testProject.model.Customer;
import com.epam.producing.testProject.repository.AddressRepository;
import com.epam.producing.testProject.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers/{id}/addresses")
public class AddressController {
    @Autowired
    private AddressRepository repository;
    @Autowired
    private CustomersRepository customersRepository;

    @GetMapping
    public List<Address> getAddresses(@PathVariable Long id) {
        return repository.findByCustomer_Id(id);
    }

    @PostMapping
    public Address newAddress(@PathVariable Long id, @RequestBody Address newAddress) {
        Customer customer = customersRepository.findById(id).orElseThrow(() -> new AddressNotFoundException(id));
        newAddress.setCustomer(customer);
        return repository.save(newAddress);
    }

    @GetMapping("/{addressId}")
    public Address newAddress(@PathVariable Long id, @PathVariable Long addressId) {
        return repository.findById(addressId).filter(address -> id.equals(address.getCustomer().getId())).orElseThrow(() -> new AddressNotFoundException(addressId));
    }


    @DeleteMapping("/{addressId}")
    public void deleteAddress(@PathVariable Long id, @PathVariable Long addressId) {
        repository.findById(addressId)
                .filter(address -> id.equals(address.getCustomer().getId()))
                .orElseThrow(() -> new AddressNotFoundException(id));
        repository.deleteById(addressId);
    }

    @PutMapping("/{addressId}")
    public void updateAddress(@PathVariable Long id, @PathVariable Long addressId, @RequestBody Address updateAddress) {
        Address address = repository.findById(addressId)
                .filter(a -> id.equals(a.getCustomer().getId()))
                .orElseThrow(() -> new AddressNotFoundException(id));

        address.setCity(updateAddress.getCity());
        repository.save(address);
    }

}
