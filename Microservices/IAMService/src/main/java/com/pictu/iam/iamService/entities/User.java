package com.pictu.iam.iamService.entities;
import com.pictu.core.payloads.AuditableEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User extends AuditableEntity {
    @Id
    private String userId;
    private String name;
    private String email;
    private String password;


    // other User properties to be filled here
    @Transient
    private List<Photo> photos = new ArrayList<>();

}
