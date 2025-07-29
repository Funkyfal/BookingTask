package org.emobile.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.NaturalId;

import java.time.ZonedDateTime;

@Entity
@Table(name = "flights", schema = "bookings")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Flight {
    @Id
    @Column(name = "flight_id", nullable = false)
    @EqualsAndHashCode.Include
    private Integer flightId;

    @NaturalId
    @Column(name = "flight_no", nullable = false, length = 6)
    private String flightNo;

    @NaturalId
    @Column(name = "scheduled_departure", nullable = false)
    private ZonedDateTime scheduledDeparture;

    @Column(name = "scheduled_arrival", nullable = false)
    private ZonedDateTime scheduledArrival;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "departure_airport", nullable = false,
            foreignKey = @ForeignKey(name = "fk_fl_departure_airport"))
    private Airport departureAirport;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "arrival_airport", nullable = false,
            foreignKey = @ForeignKey(name = "fk_fl_arrival_airport"))
    private Airport arrivalAirport;

    @Column(name = "status", nullable = false, length = 20)
    private String status;

    @ManyToOne
    @JoinColumn(name = "aircraft_code", nullable = false,
            foreignKey = @ForeignKey(name = "fk_fl_aircraft"))
    private Aircraft aircraft;

    @Column(name = "actual_departure")
    private ZonedDateTime actualDeparture;

    @Column(name = "actual_arrival")
    private ZonedDateTime actualArrival;
}