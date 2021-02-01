package com.isa.pharmacy.domain.Profile;

import com.isa.pharmacy.domain.Counseling;
import com.isa.pharmacy.domain.Examination;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Patient implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Long id;
    @OneToOne
    private User user;
    @OneToMany
    private List<Counseling> counselings;
    @OneToMany
    private List<Examination> examinations;

    public Patient(){}

    public Patient(Long id, User user, List<Counseling> counselings, List<Examination> examinations) {
        this.id = id;
        this.user = user;
        this.counselings = counselings;
        this.examinations = examinations;
    }

    public List<Examination> getExaminations() {
        return examinations;
    }

    public void setExaminations(List<Examination> examinations) {
        this.examinations = examinations;
    }

    public List<Counseling> getCounselings() {
        return counselings;
    }

    public void setCounselings(List<Counseling> counselings) {
        this.counselings = counselings;
    }

}
