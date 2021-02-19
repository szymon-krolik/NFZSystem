package pl.backend.nfzBackend.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class VisitType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long visitType_id;

    @Column
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "visitType")
    private List<Visit> visits;

}
