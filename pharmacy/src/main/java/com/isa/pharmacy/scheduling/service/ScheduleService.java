package com.isa.pharmacy.scheduling.service;

import com.isa.pharmacy.scheduling.domain.Schedule;
import com.isa.pharmacy.scheduling.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ScheduleService {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
    private static final SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private ScheduleRepository scheduleRepository;

    public Schedule save(Schedule schedule) { return scheduleRepository.save(schedule); }

    public List<Schedule> getAll(){ return scheduleRepository.findAll(); }

    public Schedule update(Schedule s) {
        Schedule schedule = scheduleRepository.findScheduleById(s.getId());
        schedule.setStartDate(s.getStartDate());
        schedule.setEndDate(s.getEndDate());
        schedule.setStartTime(s.getStartTime());
        schedule.setEndTime(s.getEndTime());
        scheduleRepository.save(schedule);
        return schedule;
    }

    // TODO: Premestiti metode u zasebnu klasu
    public Date mergeDateAndTime(Date date, Date time){
        Date res = new Date();
        try {
            res = sdf.parse(getDateFromFullDate(date).toString() + " " + getTimeFromDate(time).toString());
        } catch (ParseException e) {
        }
        return res;
    }

    public Date getTimeFromDate(Date date){
        Date res = new Date();
        try {
            res = sdfTime.parse(sdfTime.format(date));
        } catch (ParseException e) {

        }
        return res;
    }

    public Date getDateFromFullDate(Date date){
        Date res = new Date();
        try {
            res = sdfDate.parse(sdfDate.format(date));
        } catch (ParseException e) {
        }
        return res;
    }
}
