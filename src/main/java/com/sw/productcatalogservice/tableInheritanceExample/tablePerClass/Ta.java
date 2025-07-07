package com.sw.productcatalogservice.tableInheritanceExample.tablePerClass;

import jakarta.persistence.Entity;

@Entity(name="tpc_ta")
public class Ta extends User{
    private Long numberOfRatings;
}
