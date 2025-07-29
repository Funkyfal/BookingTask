package org.emobile.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Entity
@Table(name = "bookings", schema = "bookings")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Booking {
    @Id
    @Column(name = "book_ref", nullable = false, length = 6)
    @EqualsAndHashCode.Include
    private String bookRef;

    @Column(name = "book_date", nullable = false)
    private ZonedDateTime bookDate;

    @Column(name = "total_amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal totalAmount;
}