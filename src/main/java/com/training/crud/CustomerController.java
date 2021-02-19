package com.training.crud;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequestMapping("/api/customers")
@RestController
public class CustomerController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerService customerService;

    @GetMapping(path = "{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> getCustomer(@PathVariable String customerId) {
        Optional<Customer> foundCustomer = customerService.getByCustomerId(customerId);

        if(foundCustomer.isPresent())
            return ResponseEntity.ok().body(foundCustomer.get());

        return ResponseEntity.notFound().build();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createCustomer(@RequestBody @Valid CustomerRequest customerRequest) {
        Customer customer = modelMapper.map(customerRequest, Customer.class);
        try {
            customerService.insert(customer);
        }
        catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateCustomer(@RequestBody @Valid CustomerRequest updateCustomerRequest) {
        Customer customer = modelMapper.map(updateCustomerRequest, Customer.class);
        try {
            customerService.update(customer);
        }
        catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable String customerId) {
        try {
            customerService.delete(customerId);
        }
        catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }

        return ResponseEntity.ok().build();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAll();

        return ResponseEntity.ok().body(customers);
    }
}
