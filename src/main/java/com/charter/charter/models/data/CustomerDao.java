package com.charter.charter.models.data;

import com.charter.charter.models.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CustomerDao extends CrudRepository<Customer, Integer> {
    public Customer findByName(String name);

    //Custom Query to indicate whether or not a customer's name already exists in the database
    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN 'true' ELSE 'false' END FROM Customer u WHERE u.name = ?1")
    public Boolean existsByName(String name);
}
