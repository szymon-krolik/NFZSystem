package pl.backend.nfzBackend.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class SurgeryType {
@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long surgeryType_id;

    @Column
    private String description;

    @Column
    private Double price;

    @Column
    private boolean refund;



    @OneToMany(fetch = FetchType.LAZY, mappedBy = "surgeryType")
    private List<Surgery> surgeries;

}
