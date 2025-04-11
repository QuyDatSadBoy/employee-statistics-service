package org.example.employeestatisticsservice.controller;

import org.example.employeestatisticsservice.dto.EmployeeStatsDTO;
import org.example.employeestatisticsservice.dto.StatsSummaryDTO;
import org.example.employeestatisticsservice.service.EmployeeStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/statistics")
public class EmployeeStatsController {

    private final EmployeeStatsService employeeStatsService;

    @Autowired
    public EmployeeStatsController(EmployeeStatsService employeeStatsService) {
        this.employeeStatsService = employeeStatsService;
    }

    @PostMapping("/employees")
    public ResponseEntity<EmployeeStatsDTO> createOrUpdateEmployeeStats(@RequestBody EmployeeStatsDTO employeeStatsDTO) {
        return new ResponseEntity<>(employeeStatsService.createOrUpdateEmployeeStats(employeeStatsDTO), HttpStatus.CREATED);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeStatsDTO> getEmployeeStatsById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeStatsService.getEmployeeStatsById(id));
    }

    @GetMapping("/employees/employee/{employeeId}")
    public ResponseEntity<EmployeeStatsDTO> getEmployeeStatsByEmployeeId(@PathVariable Long employeeId) {
        return ResponseEntity.ok(employeeStatsService.getEmployeeStatsByEmployeeId(employeeId));
    }

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeStatsDTO>> getAllEmployeeStats() {
        return ResponseEntity.ok(employeeStatsService.getAllEmployeeStats());
    }

    @GetMapping("/employees/department/{department}")
    public ResponseEntity<List<EmployeeStatsDTO>> getEmployeeStatsByDepartment(@PathVariable String department) {
        return ResponseEntity.ok(employeeStatsService.getEmployeeStatsByDepartment(department));
    }

    @GetMapping("/employees/access-level/{accessLevel}")
    public ResponseEntity<List<EmployeeStatsDTO>> getEmployeeStatsByAccessLevel(@PathVariable Integer accessLevel) {
        return ResponseEntity.ok(employeeStatsService.getEmployeeStatsByAccessLevel(accessLevel));
    }

    @GetMapping("/summary")
    public ResponseEntity<StatsSummaryDTO> getStatsSummary() {
        return ResponseEntity.ok(employeeStatsService.getStatsSummary());
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Void> deleteEmployeeStats(@PathVariable Long id) {
        employeeStatsService.deleteEmployeeStats(id);
        return ResponseEntity.noContent().build();
    }
}
