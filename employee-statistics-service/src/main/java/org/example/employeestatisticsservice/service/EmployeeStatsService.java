package org.example.employeestatisticsservice.service;


import org.example.employeestatisticsservice.dto.EmployeeStatsDTO;
import org.example.employeestatisticsservice.dto.StatsSummaryDTO;

import java.util.List;

public interface EmployeeStatsService {

    EmployeeStatsDTO createOrUpdateEmployeeStats(EmployeeStatsDTO employeeStatsDTO);

    EmployeeStatsDTO getEmployeeStatsById(Long id);

    EmployeeStatsDTO getEmployeeStatsByEmployeeId(Long employeeId);

    List<EmployeeStatsDTO> getAllEmployeeStats();

    List<EmployeeStatsDTO> getEmployeeStatsByDepartment(String department);

    List<EmployeeStatsDTO> getEmployeeStatsByAccessLevel(Integer accessLevel);

    StatsSummaryDTO getStatsSummary();

    void deleteEmployeeStats(Long id);
}
