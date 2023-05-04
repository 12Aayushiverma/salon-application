package com.letsconnecot.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Table(name = "role")
//public class Roles {
//	
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer id;
//	private String name;
////	@OneToMany(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
////	 @JoinColumn(nullable = true)
////	private List<Permissions> permissions = new ArrayList<>();
//	
////	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
////	@JoinTable(name = "role_permissions",
////		joinColumns = @JoinColumn(name = "role_id"),
////		inverseJoinColumns = @JoinColumn(name = "permission_id"))
//	
//	 @OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
//	 private Set<Permissions> permissions = new HashSet<>();
//}
