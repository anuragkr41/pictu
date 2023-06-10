package com.pictu.customerService.entities;

import com.pictu.iam.core.payloads.AuditableEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Customer extends AuditableEntity {
    @Id
    private String customerId;
    private String name;
    private String email;
    private String password;


    // other User properties to be filled here
    @Transient
    private List<Photo> photos = new ArrayList<>();

}
