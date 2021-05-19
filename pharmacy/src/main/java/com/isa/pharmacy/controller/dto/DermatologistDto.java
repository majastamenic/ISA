package com.isa.pharmacy.controller.dto;
import com.isa.pharmacy.users.domain.User;

public class DermatologistDto {

    private Long id;

    private User user;

    public DermatologistDto() {
    }

    public DermatologistDto(Long id, User user) {
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
