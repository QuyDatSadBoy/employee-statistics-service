package org.example.employeestatisticsservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeStatsDTO {

    private Long id;
    private Long employeeId;
    private String employeeCode;
    private String employeeName;
    private String department;
    private Integer accessLevel;
    private Integer totalAccesses;
    private Integer grantedAccesses;
    private Integer deniedAccesses;
    private LocalDateTime lastAccessTime;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
