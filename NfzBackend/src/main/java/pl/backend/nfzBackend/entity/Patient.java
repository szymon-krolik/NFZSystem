package pl.backend.nfzBackend.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long patient_id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private Date birthday;

    @Column
    private String personalIdentityNumber;

    @Column
    private Boolean nfz;

    @Column
    private String socialSecurityNumber;

    @Column
    private String idNumber;

    @OneToOne(mappedBy = "patient")
    private Contact contact;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
    private List<Prescription> prescriptions;

    @ManyToMany
    @JoinTable(
            name = "patient_surgery",
            joinColumns = @JoinColumn(name = "patiet_id"),
            inverseJoinColumns = @JoinColumn(name = "surgery_id")
    )
    private Set<Surgery> surgeries;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
    private List<Visit> visits;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
    private List<Rfe> rfes;
}
