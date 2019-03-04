package com.epam.producing.testProject.repository;

import com.epam.producing.testProject.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface CustomersRepository extends JpaRepository<Customer,Long> {
}
