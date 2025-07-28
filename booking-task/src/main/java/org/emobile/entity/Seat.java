package org.emobile.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "seats", schema = "bookings")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Seat {
    @EmbeddedId
    @EqualsAndHashCode.Include
    private SeatId id;

    @MapsId("aircraftCode")
    @ManyToOne(optional = false)
    @JoinColumn(name = "aircraft_code", nullable = false,
            foreignKey = @ForeignKey(name = "fk_seat_aircraft"))
    private Aircraft aircraft;

    @Column(name = "fare_conditions", nullable = false, length = 10)
    private String fareConditions;
}