package com.tp.carsseller.model;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
public class payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    @Temporal(TemporalType.DATE)
    private Date paymentDate;

    private String paymentStatus;

    @ManyToOne
    @JoinColumn(name = "offerId", referencedColumnName = "id", nullable = false)
    private Offer offer;
}
