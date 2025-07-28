package org.emobile.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "aircrafts", schema = "bookings")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Aircraft {
    @Id
    @Column(name = "aircraft_code", nullable = false, columnDefinition = "char(3)")
    @EqualsAndHashCode.Include
    private String aircraftCode;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "range", nullable = false)
    private Integer range;
}