package com.charter.charter.models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionDao extends CrudRepository<Transaction, Integer> {

}
