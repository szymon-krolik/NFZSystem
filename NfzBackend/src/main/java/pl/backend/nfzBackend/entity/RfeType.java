package pl.backend.nfzBackend.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class RfeType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long rfeType_id;

    @Column
    private String name;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rfeType")
    private List<Rfe> rfes;
}
