package com.pictu.iam.iamService.entities;
import com.pictu.core.payloads.AuditableEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
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
