package com.example.crudoperation.repository;

import com.example.crudoperation.model.GreetingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GreetingRepository extends JpaRepository<GreetingModel, Integer> {
   Optional<GreetingModel> findByFirstName(String name);
}
