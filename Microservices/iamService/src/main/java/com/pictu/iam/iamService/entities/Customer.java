package com.pictu.iam.iamService.entities;

import com.pictu.core.payloads.AuditableEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer extends AuditableEntity {
    @Id
    @Column(name = "customer_Id")
    private String customerId;
    private String name;

    private String email;
    private String about;


    // other Customer properties to be filled here
    @Transient
    private Set<Photo> photos = new HashSet<>();

}
