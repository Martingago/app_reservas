package com.bookSmart.reserva.repository;

import com.bookSmart.reserva.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleModel, Long> {

    @EntityGraph(attributePaths = {"userSet"})  // Cargar los usuarios junto con el rol
    Optional<RoleModel> findById(Long id);

    Optional<RoleModel> findByRole(String role);
}
