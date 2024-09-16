package com.bookSmart.reserva.model;

import jakarta.persistence.*;
import lombok.*;
import org.apache.catalina.User;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "roles")
public class RoleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name= "role", nullable = false, unique = true)
    private String role;

    @ManyToMany(mappedBy = "roleSet",fetch = FetchType.LAZY)
    private Set<UserModel> userSet = new HashSet<UserModel>();
}
