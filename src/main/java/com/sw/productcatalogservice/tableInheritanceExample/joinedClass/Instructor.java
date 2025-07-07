package com.sw.productcatalogservice.tableInheritanceExample.joinedClass;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name="jc_instructor")
@PrimaryKeyJoinColumn(name="user_id_")
public class Instructor extends User {
    private String companyName;
}

