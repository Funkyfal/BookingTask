package org.emobile.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeatId implements Serializable {
    @Column(name = "aircraft_code", nullable = false, length = 3)
    private String aircraftCode;

    @Column(name = "seat_no", nullable = false, length = 4)
    private String seatNo;
}