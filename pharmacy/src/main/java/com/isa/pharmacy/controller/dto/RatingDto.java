package com.isa.pharmacy.controller.dto;

public class RatingDto {

    private Long id;
    private Integer rating;
    private String patientEmail;
    private String ratedEntityId;

    public RatingDto(){}

    public RatingDto(Long id, Integer rating, String patientEmail, String ratedEntityName) {
        this.id = id;
        this.rating = rating;
        this.patientEmail = patientEmail;
        this.ratedEntityId = ratedEntityName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public String getRatedEntityId() {
        return ratedEntityId;
    }

    public void setRatedEntityId(String ratedEntityId) {
        this.ratedEntityId = ratedEntityId;
    }
}
