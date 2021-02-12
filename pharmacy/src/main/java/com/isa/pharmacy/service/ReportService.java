package com.isa.pharmacy.service;

import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.domain.Report;
import com.isa.pharmacy.repository.ReportRepository;
import com.isa.pharmacy.service.interfaces.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReportService implements IReportService {

    @Autowired
    private ReportRepository reportRepository;

    public Report save(Report report) {return reportRepository.save(report);}
    // dodati proveru za lekove - alergije

    public List<Report> getAll() {return reportRepository.findAll();}

    public Report update(Report r) {
        Report report = reportRepository.findReportById(r.getId());
        if(report == null)
            throw new NotFoundException("Report doesn't exists");
        report.setMedicines(r.getMedicines());
        reportRepository.save(report);
        return report;
    }
}
