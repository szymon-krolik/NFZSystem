package pl.backend.nfzBackend.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long contact_id;

    @Column
    private String street;

    @Column
    private String houseNumber;

    @Column
    private String apartmentNumber;

    @Column
    private String city;

    @Column
    private String postCode;

    @Column
    private String province;

    @Column
    private String phoneNumber;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    private Patient patient;




}
