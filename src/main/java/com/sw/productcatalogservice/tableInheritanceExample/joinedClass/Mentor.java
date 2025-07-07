package com.sw.productcatalogservice.tableInheritanceExample.joinedClass;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name="jc_mentor")
@Inheritance(strategy = InheritanceType.JOINED)
public class Mentor extends User {
    private Long numberOfHours;
}
