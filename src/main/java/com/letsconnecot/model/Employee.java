package com.letsconnecot.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String email;
	private String description;
	private String password;
	private String role;

//	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
//	@JoinColumn(name = "role_id") 

//	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},fetch = FetchType.EAGER)
//	@JoinTable(name = "employee_roles",
//		joinColumns = @JoinColumn(name = "employee_id"),
//		inverseJoinColumns = @JoinColumn(name= "role_id")
//	)

//	 @OneToOne(cascade = CascadeType.ALL)
//	 @JoinColumn(name = "role_id", referencedColumnName = "id")
//	 private Roles role;
/*
		private String role;

	    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL,orphanRemoval = true)
	    private Set<Permissions> permissions;*/

}
