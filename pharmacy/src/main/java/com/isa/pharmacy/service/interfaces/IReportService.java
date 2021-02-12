package com.isa.pharmacy.service.interfaces;

import com.isa.pharmacy.domain.Report;

import java.util.List;

public interface IReportService {

    List<Report> getAll();

    Report update(Report r);

    Report save(Report r);
}
