package com.isa.pharmacy.scheduling.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table
public class Schedule implements Serializable {
    private static final long serialVersionUID = -2158829881260056438L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+01:00")
    private Date startDate;
    @Column
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+01:00")
    private Date endDate;
    @Column
    @Temporal(TemporalType.TIME)
    @JsonFormat(pattern = "HH:mm:ss", timezone = "GMT+01:00")
    private Date startTime;
    @Column
    @Temporal(TemporalType.TIME)
    @JsonFormat(pattern = "HH:mm:ss", timezone = "GMT+01:00")
    private Date endTime;

    public Schedule(){}

    public Schedule(Long id, Date startDate, Date endDate, Date startTime, Date endTime) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date mergeStartDateAndTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date res = new Date();
        try {
            res = sdf.parse(this.startDate.toString() + " " + this.startTime.toString());
        } catch (ParseException e) {
        }
        return res;
    }

    public Date mergeEndDateAndTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date res = new Date();
        try {
            res = sdf.parse(this.endDate.toString() + " " + this.endTime.toString());
        } catch (ParseException e) {
        }
        return res;
    }

}
