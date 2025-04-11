package org.example.employeestatisticsservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "employee_stats")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_id", unique = true)
    private Long employeeId;

    @Column(name = "employee_code")
    private String employeeCode;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "department")
    private String department;

    @Column(name = "access_level")
    private Integer accessLevel;

    @Column(name = "total_accesses")
    private Integer totalAccesses = 0;

    @Column(name = "granted_accesses")
    private Integer grantedAccesses = 0;

    @Column(name = "denied_accesses")
    private Integer deniedAccesses = 0;

    @Column(name = "last_access_time")
    private LocalDateTime lastAccessTime;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}