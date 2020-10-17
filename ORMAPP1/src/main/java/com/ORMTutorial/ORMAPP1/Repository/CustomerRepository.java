package com.ORMTutorial.ORMAPP1.Repository;

import com.ORMTutorial.ORMAPP1.Entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer,Long> {
    List<Customer> findByLastName(String lastName);
    Customer findById(long id);
}
