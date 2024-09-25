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
@Table(name = "branches")
public class BranchModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_id", nullable = false)
    private BusinessModel businessModel;

    @Column(name = "list_booking_spaces")
    @OneToMany(mappedBy = "branchModel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<BookingSpaceModel> bookingSpaceModelSet;

    @Column(name = "list_employees")
    @OneToMany(mappedBy = "branchModel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<EmployeeModel> employeeModelSet;

    @ManyToMany(mappedBy = "branchModelSet", fetch = FetchType.LAZY)
    private Set<ManagerModel> managerModelSet;

    @Column(name = "address", nullable = false)
    private String address;

}
