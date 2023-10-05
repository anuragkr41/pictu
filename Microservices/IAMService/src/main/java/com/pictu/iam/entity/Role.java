package com.pictu.iam.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Enumerated(EnumType.STRING)
	private RoleName name;

	@ManyToMany(mappedBy = "roles")
	private Set<UserCredential> users = new HashSet<>();

	public enum RoleName {
		ADMIN, CUSTOMER, PHOTOGRAPHER
	}
}
