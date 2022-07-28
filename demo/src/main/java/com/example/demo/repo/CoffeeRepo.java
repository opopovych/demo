package com.example.demo.repo;

import com.example.demo.model.Coffee;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeeRepo extends CrudRepository<Coffee,Long> {
}
