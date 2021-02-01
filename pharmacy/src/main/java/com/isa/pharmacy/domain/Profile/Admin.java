package com.isa.pharmacy.domain.Profile;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Admin implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    @OneToOne
    private User user;

    public Admin(){}

    public Admin(Long id, User user) {
        this.id = id;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
