package com.isa.pharmacy.domain;

import javax.persistence.*;

@Entity
@Table
public class Diagnosis {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
}
