package org.emobile.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(
        name = "boarding_passes",
        schema = "bookings",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_bp_flight_boardingno",
                        columnNames = {"flight_id", "boarding_no"}
                ),
                @UniqueConstraint(
                        name = "uk_bp_flight_seatno",
                        columnNames = {"flight_id", "seat_no"}
                )
        }
)
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BoardingPass {
    @EmbeddedId
    @EqualsAndHashCode.Include
    private BoardingPassId boardingPassId;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumns({
            @JoinColumn(
                    name = "ticket_no", referencedColumnName = "ticket_no",
                    nullable = false,
                    foreignKey = @ForeignKey(name = "fk_bp_ticketflight_ticket")
            ),
            @JoinColumn(
                    name = "flight_id", referencedColumnName = "flight_id",
                    nullable = false,
                    foreignKey = @ForeignKey(name = "fk_bp_ticketflight_flight")
            )
    })
    private TicketFlight ticketFlight;

    @Column(name = "boarding_no", nullable = false)
    private Integer boardingNo;

    @Column(name = "seat_no", nullable = false, length = 4)
    private String seatNo;
}

