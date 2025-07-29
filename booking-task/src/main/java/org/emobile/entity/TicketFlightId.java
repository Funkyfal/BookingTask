package org.emobile.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketFlightId implements Serializable {
    @Column(name = "ticket_no", nullable = false, length = 13)
    private String ticketNo;

    @Column(name = "flight_id", nullable = false)
    private Integer flightId;
}