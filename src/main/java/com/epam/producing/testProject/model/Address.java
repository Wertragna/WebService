package com.epam.producing.testProject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
@Entity
@Data
@NamedQuery(query = "select a from Address a join a.customer b where b.id = :customerId",name = "Address.find")
public class Address {
    @Id
    @GeneratedValue
    private long id;

    private String city;

    @JsonIgnore
    @ManyToOne
    @JoinColumn
    private Customer customer;

    public Address(String city, Customer
            customer) {
        this.city = city;
        this.customer = customer;
    }

    public Address() {
    }
}
