package com.charter.charter.models.data;

import com.charter.charter.models.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CustomerDao extends CrudRepository<Customer, Integer> {
    public Customer findByName(String name);
}
