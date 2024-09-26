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
@Table(name = "clients")
public class ClientModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private UserModel userModel;

    @OneToMany(mappedBy = "clientModel", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Set<ReservationModel> reservationModelSet;

}
