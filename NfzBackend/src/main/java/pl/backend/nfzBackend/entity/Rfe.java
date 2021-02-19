package pl.backend.nfzBackend.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
public class Rfe {
@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long rfe_id;

    @Column
    private Date date;

    @Column
    private Date expiredDate;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "surgery_id")
    private Surgery surgery;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rfeTypeId")
    private RfeType rfeType;

}
