package com.sw.productcatalogservice.tableInheritanceExample.singleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name="st_mentor")
@DiscriminatorValue(value="14")
public class Mentor extends User {
    private Long numberOfHours;
}
