package com.sw.productcatalogservice.tableInheritanceExample.tablePerClass;

import jakarta.persistence.Entity;

@Entity(name="tpc_instructor")
public class Instructor extends User{
    private String companyName;
}

