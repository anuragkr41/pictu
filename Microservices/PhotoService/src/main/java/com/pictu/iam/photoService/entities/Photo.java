package com.pictu.iam.photoService.entities;

import com.pictu.iam.core.payloads.AuditableEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table
public class Photo extends AuditableEntity {
    @Id
    private String photoId;
    private String customerId;
    private String name;
    private String location;
    private String about;

    
    



}
