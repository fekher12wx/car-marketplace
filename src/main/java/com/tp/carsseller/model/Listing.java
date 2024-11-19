package com.tp.carsseller.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
public class Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private Double price;

    @Temporal(TemporalType.DATE)
    private Date postedDate;

    @ManyToOne
    @JoinColumn(name = "sellerId", referencedColumnName = "id", nullable = false)
    private User seller;

    @ManyToOne
    @JoinColumn(name = "carId", referencedColumnName = "id", nullable = false)
    private Car car;
}
