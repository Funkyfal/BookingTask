package org.emobile.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Entity
@Table(name = "ticket_flights", schema = "bookings")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TicketFlight {
    @EmbeddedId
    @EqualsAndHashCode.Include
    private TicketFlightId ticketFlightId;

    @MapsId("ticketNo")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ticket_no", nullable = false,
            foreignKey = @ForeignKey(name = "fk_tf_ticket"))
    private Ticket ticket;

    @MapsId("flightId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "flight_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_tf_flight"))
    private Flight flight;

    @Column(name = "fare_conditions", nullable = false, length = 10)
    private String fareConditions;

    @Column(name = "amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;
}