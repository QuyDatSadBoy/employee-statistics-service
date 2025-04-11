package org.example.employeestatisticsservice.service;


import jakarta.persistence.EntityNotFoundException;
import org.example.employeestatisticsservice.dto.EmployeeStatsDTO;
import org.example.employeestatisticsservice.dto.StatsSummaryDTO;
import org.example.employeestatisticsservice.model.EmployeeStats;
import org.example.employeestatisticsservice.repository.EmployeeStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeStatsServiceImpl implements EmployeeStatsService {

    private final EmployeeStatsRepository employeeStatsRepository;

    @Autowired
    public EmployeeStatsServiceImpl(EmployeeStatsRepository employeeStatsRepository) {
        this.employeeStatsRepository = employeeStatsRepository;
    }

    @Override
    public EmployeeStatsDTO createOrUpdateEmployeeStats(EmployeeStatsDTO employeeStatsDTO) {
        EmployeeStats employeeStats;

        if (employeeStatsDTO.getEmployeeId() != null) {
            employeeStats = employeeStatsRepository.findByEmployeeId(employeeStatsDTO.getEmployeeId())
                    .orElse(new EmployeeStats());
        } else {
            employeeStats = new EmployeeStats();
        }

        employeeStats.setEmployeeId(employeeStatsDTO.getEmployeeId());
        employeeStats.setEmployeeCode(employeeStatsDTO.getEmployeeCode());
        employeeStats.setEmployeeName(employeeStatsDTO.getEmployeeName());
        employeeStats.setDepartment(employeeStatsDTO.getDepartment());
        employeeStats.setAccessLevel(employeeStatsDTO.getAccessLevel());
        employeeStats.setTotalAccesses(employeeStatsDTO.getTotalAccesses());
        employeeStats.setGrantedAccesses(employeeStatsDTO.getGrantedAccesses());
        employeeStats.setDeniedAccesses(employeeStatsDTO.getDeniedAccesses());
        employeeStats.setLastAccessTime(employeeStatsDTO.getLastAccessTime());

        EmployeeStats savedEmployeeStats = employeeStatsRepository.save(employeeStats);
        return convertToDTO(savedEmployeeStats);
    }

    @Override
    public EmployeeStatsDTO getEmployeeStatsById(Long id) {
        EmployeeStats employeeStats = employeeStatsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee stats not found with id: " + id));
        return convertToDTO(employeeStats);
    }

    @Override
    public EmployeeStatsDTO getEmployeeStatsByEmployeeId(Long employeeId) {
        EmployeeStats employeeStats = employeeStatsRepository.findByEmployeeId(employeeId)
                .orElseThrow(() -> new EntityNotFoundException("Employee stats not found for employee id: " + employeeId));
        return convertToDTO(employeeStats);
    }

    @Override
    public List<EmployeeStatsDTO> getAllEmployeeStats() {
        return employeeStatsRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeStatsDTO> getEmployeeStatsByDepartment(String department) {
        return employeeStatsRepository.findByDepartment(department).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeStatsDTO> getEmployeeStatsByAccessLevel(Integer accessLevel) {
        return employeeStatsRepository.findByAccessLevel(accessLevel).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StatsSummaryDTO getStatsSummary() {
        List<EmployeeStats> allStats = employeeStatsRepository.findAll();

        StatsSummaryDTO summary = new StatsSummaryDTO();
        summary.setTotalEmployees(allStats.size());

        Integer totalAccesses = employeeStatsRepository.countTotalAccesses();
        Integer grantedAccesses = employeeStatsRepository.countGrantedAccesses();
        Integer deniedAccesses = employeeStatsRepository.countDeniedAccesses();

        summary.setTotalAccesses(totalAccesses != null ? totalAccesses : 0);
        summary.setGrantedAccesses(grantedAccesses != null ? grantedAccesses : 0);
        summary.setDeniedAccesses(deniedAccesses != null ? deniedAccesses : 0);

        // Thống kê theo phòng ban
        summary.setItDepartmentCount((int) allStats.stream().filter(s -> "IT".equalsIgnoreCase(s.getDepartment())).count());
        summary.setHrDepartmentCount((int) allStats.stream().filter(s -> "HR".equalsIgnoreCase(s.getDepartment())).count());
        summary.setSecurityDepartmentCount((int) allStats.stream().filter(s -> "Security".equalsIgnoreCase(s.getDepartment())).count());
        summary.setOtherDepartmentCount(summary.getTotalEmployees() - summary.getItDepartmentCount()
                - summary.getHrDepartmentCount() - summary.getSecurityDepartmentCount());

        // Thống kê theo cấp độ truy cập
        summary.setLevel1AccessCount((int) allStats.stream().filter(s -> s.getAccessLevel() == 1).count());
        summary.setLevel2AccessCount((int) allStats.stream().filter(s -> s.getAccessLevel() == 2).count());
        summary.setLevel3AccessCount((int) allStats.stream().filter(s -> s.getAccessLevel() == 3).count());
        summary.setLevel4AccessCount((int) allStats.stream().filter(s -> s.getAccessLevel() == 4).count());

        return summary;
    }

    @Override
    public void deleteEmployeeStats(Long id) {
        if (!employeeStatsRepository.existsById(id)) {
            throw new EntityNotFoundException("Employee stats not found with id: " + id);
        }
        employeeStatsRepository.deleteById(id);
    }

    private EmployeeStatsDTO convertToDTO(EmployeeStats employeeStats) {
        EmployeeStatsDTO dto = new EmployeeStatsDTO();
        dto.setId(employeeStats.getId());
        dto.setEmployeeId(employeeStats.getEmployeeId());
        dto.setEmployeeCode(employeeStats.getEmployeeCode());
        dto.setEmployeeName(employeeStats.getEmployeeName());
        dto.setDepartment(employeeStats.getDepartment());
        dto.setAccessLevel(employeeStats.getAccessLevel());
        dto.setTotalAccesses(employeeStats.getTotalAccesses());
        dto.setGrantedAccesses(employeeStats.getGrantedAccesses());
        dto.setDeniedAccesses(employeeStats.getDeniedAccesses());
        dto.setLastAccessTime(employeeStats.getLastAccessTime());
        dto.setCreatedAt(employeeStats.getCreatedAt());
        dto.setUpdatedAt(employeeStats.getUpdatedAt());
        return dto;
    }
}
