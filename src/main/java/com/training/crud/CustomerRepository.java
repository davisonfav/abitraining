package com.training.crud;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

//    @Query(value = "{'customer.name': ?0}", fields = "{'customer' : 0}")
//    Customer findCustomerByName(String name);

    Customer findByCustomerId(String customerId);
}
