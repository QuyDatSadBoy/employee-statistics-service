package org.example.employeestatisticsservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatsSummaryDTO {

    private Integer totalEmployees;
    private Integer totalAccesses;
    private Integer grantedAccesses;
    private Integer deniedAccesses;

    // Thống kê theo phòng ban
    private Integer itDepartmentCount;
    private Integer hrDepartmentCount;
    private Integer securityDepartmentCount;
    private Integer otherDepartmentCount;

    // Thống kê theo cấp độ truy cập
    private Integer level1AccessCount;
    private Integer level2AccessCount;
    private Integer level3AccessCount;
    private Integer level4AccessCount;
}
