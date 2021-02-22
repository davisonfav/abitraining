package com.training.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Optional<Customer> getByCustomerId(String customerId) {
        Customer customer = customerRepository.findByCustomerId(customerId);
        if (customer != null) {
            return Optional.of(customer);
        }

        return Optional.empty();
    }

    @Override
    public void insert(Customer customer) {
        Optional<Customer> foundCustomer = getByCustomerId(customer.getCustomerId());
        if (foundCustomer.isPresent()) {
            throw new IllegalArgumentException("Customer already exists.");
        }
        //insert in mongo
        customerRepository.insert(customer);
    }

    @Override
    public void update(Customer customer) {
        Optional<Customer> foundCustomer = getByCustomerId(customer.getCustomerId());
        if (!foundCustomer.isPresent()) {
            throw new IllegalArgumentException("Customer not found.");
        }
        //update in mongo
        customerRepository.save(customer);
    }

    @Override
    public void delete(String customerId) {
        Optional<Customer> foundCustomer = getByCustomerId(customerId);
        if (!foundCustomer.isPresent()) {
            throw new IllegalArgumentException("Customer not found.");
        }

        customerRepository.delete(foundCustomer.get());
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }
}