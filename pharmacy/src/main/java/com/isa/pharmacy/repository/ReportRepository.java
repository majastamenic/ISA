package com.isa.pharmacy.repository;

import com.isa.pharmacy.domain.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {

    List<Report> findAll();

    Report save(Report report);

    Report findReportById(Long id);
}
