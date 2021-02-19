package pl.backend.nfzBackend.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data

public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long visit_id;

    @Column
    private Boolean home;

    @Column
    private Date visit_date;

    @Column
    private String description;

    @Column
    private String number;



    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "visitTypeId")
    private VisitType visitType;
}
