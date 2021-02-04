package com.isa.pharmacy.controller.dto;

public class PasswordChangeDto {

    private String email;
    private String oldPass;
    private String newPass;
    private String newPassRepeat;

    public PasswordChangeDto(String email, String oldPass, String newPass, String newPassRepeat) {
        this.email = email;
        this.oldPass = oldPass;
        this.newPass = newPass;
        this.newPassRepeat = newPassRepeat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOldPass() {
        return oldPass;
    }

    public void setOldPass(String oldPass) {
        this.oldPass = oldPass;
    }

    public String getNewPass() {
        return newPass;
    }

    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }

    public String getNewPassRepeat() {
        return newPassRepeat;
    }

    public void setNewPassRepeat(String newPassRepeat) {
        this.newPassRepeat = newPassRepeat;
    }
}
