package com.tp.carsseller.model;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
public class review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Short rating;
    private String comment;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "carId", referencedColumnName = "id", nullable = false)
    private Car car;

    @Temporal(TemporalType.DATE)
    private Date reviewDate;
}
