package com.ORMTutorial.ORMAPP1.Repository;

import com.ORMTutorial.ORMAPP1.Entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer,Long> {
    List<Customer> findByLastName(String lastName);
    List<Customer> findByFirstName(String firstName);
    List<Customer> findByFullName(String fullName);
    Customer findById(long id);
}
