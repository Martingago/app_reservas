package com.bookSmart.reserva.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reservations")
public class ReservationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "client_id", nullable = false)
    private ClientModel clientModel;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "employee_id", nullable = false)
    private EmployeeModel employeeModel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_reservation_id", nullable = false)
    private StatusReservationModel statusReservationModel;

    @Column(name = "number_seats", nullable = false)
    private int numberSeats;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_space_id")
    private BookingSpaceModel bookingSpaceModel;

}
