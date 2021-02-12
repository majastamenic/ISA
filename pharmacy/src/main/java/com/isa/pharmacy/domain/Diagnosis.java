package com.isa.pharmacy.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Diagnosis implements Serializable {
    private static final long serialVersionUID = 3336503350882355176L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;

    public Diagnosis(){}

    public Diagnosis(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
