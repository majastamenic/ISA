package com.isa.pharmacy.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Hospital implements Serializable {
    private static final long serialVersionUID = -7991547834909543834L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String email;
    @Column
    private String name;

    public Hospital() { }

    public Hospital(Long id, String email, String name) {
        super();
        this.id = id;
        this.email = email;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
