package com.paylocity.benefits.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dependent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;


    DependentEnum dependentType;

    public Dependent() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DependentEnum getDependentType() {
        return dependentType;
    }

    public void setDependentType(DependentEnum dependentType) {
        this.dependentType = dependentType;
    }
}
