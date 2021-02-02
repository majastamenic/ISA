package com.isa.pharmacy.service;

import com.isa.pharmacy.domain.Report;
import com.isa.pharmacy.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReportService {
    @Autowired
    private ReportRepository reportRepository;

    public Report save(Report report) {return reportRepository.save(report);}
    // dodati proveru za lekove - alergije

    public List<Report> getAll() {return reportRepository.findAll();}

    public Report update(Report r) {
        Report report = reportRepository.findReportById(r.getId());
        report.setCounseling(r.getCounseling());
        report.setNote(r.getNote());
        report.setMedicines(r.getMedicines());
        reportRepository.save(report);
        return report;
    }
}
