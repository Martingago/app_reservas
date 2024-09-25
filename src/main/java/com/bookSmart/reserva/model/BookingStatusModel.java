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
@Table(name = "booking_status")
public class BookingStatusModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status_name", nullable = false)
    private String statusName;

    @OneToMany(mappedBy = "bookingStatus", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<BookingSpaceModel> bookingSpaceModelSet;
}
