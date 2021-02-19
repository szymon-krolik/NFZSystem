package pl.backend.nfzBackend.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long user_id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private Date hiredDate;

    @Column
    private String personalIdentityNumber;

    @Column
    private String login;

    @Column
    private String password;

    @Column
    private String licenseNumber;

    @Column
    private String specialization;

    @OneToOne(mappedBy = "user")
    private Contact contact;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Visit> visits;

    @ManyToMany
    @JoinTable(
            name = "user_surgery",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "surgery_id")
    )
    private Set<Surgery> surgeries;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Prescription> prescriptions;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Rfe> rfes;

   @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userTypeId")
    private UserType userType;

}
