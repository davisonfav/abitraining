package com.training.crud;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
        Optional<Customer> getByCustomerId(String customerId);
        void insert(Customer customer);
        void update(Customer customer);
        void delete(String customerId);
        List<Customer> getAll();
}
