package com.bookSmart.reserva.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "business")
public class BusinessModel {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(name="company_name")
private String name;

@Column(name = "description", length = 2000)
private String description;

@Column(name = "list_directives")
@OneToMany(mappedBy = "business", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
private Set<DirectiveModel> directiveModelSet;

@Column(name = "list_branches")
@OneToMany(mappedBy = "businessModel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<BranchModel> branchModelSet;
}
