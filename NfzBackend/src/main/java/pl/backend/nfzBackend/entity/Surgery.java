package pl.backend.nfzBackend.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Data
@Entity
public class Surgery {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long surgery_id;

    @Column
    private String description;

    @Column
    private Date date;

    @Column
    private boolean done;



    @ManyToMany(mappedBy = "surgeries")
    private Set<Patient> patients;

    @ManyToMany(mappedBy = "surgeries")
    private Set<User> users;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "surgeryTypeId")
    private SurgeryType surgeryType;

    @OneToOne(mappedBy = "surgery")
    private Rfe rfe;
}
