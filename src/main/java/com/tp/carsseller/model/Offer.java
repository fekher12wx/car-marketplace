package com.tp.carsseller.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double offerPrice;

    @Temporal(TemporalType.DATE)
    private Date offreDate;

    private String status;

    @ManyToOne
    @JoinColumn(name = "buyerId", referencedColumnName = "id", nullable = false)
    private User buyer;

    @ManyToOne
    @JoinColumn(name = "listingId", referencedColumnName = "id", nullable = false)
    private Listing listing;
}
