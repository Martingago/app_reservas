package com.bookSmart.reserva.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "booking_spaces")
public class BookingSpaceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_id", nullable = false)
    private BranchModel branchModel;

    @Column(name = "name_book")
    private String name;

    @Column(name="seats")
    private int seats;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "booking_status_id", nullable = false)
    private  BookingStatusModel bookingStatus;

    @OneToOne(mappedBy = "bookingSpaceModel", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private ReservationModel reservationModel;

}
