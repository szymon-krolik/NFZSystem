package pl.backend.nfzBackend.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long prescription_id;

    @Column
    private String drugs;

    @Column
    private Date date;

    @Column
    private String number;

    @Column
    private Boolean used;



    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
}
