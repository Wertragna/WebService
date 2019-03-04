package com.epam.producing.testProject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Customer {
    private @Id
    @GeneratedValue
    long id;
    private String name;
    private String role;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<Address> addresses;

    public Customer(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public Customer() {
    }
}
