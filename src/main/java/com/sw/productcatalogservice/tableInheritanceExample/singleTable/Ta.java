package com.sw.productcatalogservice.tableInheritanceExample.singleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name="st_ta")
@DiscriminatorValue(value="12")
public class Ta extends User {
    private Long numberOfRatings;
}
