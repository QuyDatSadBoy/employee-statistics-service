package org.example.employeestatisticsservice.repository;


import org.example.employeestatisticsservice.model.EmployeeStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeStatsRepository extends JpaRepository<EmployeeStats, Long> {

    Optional<EmployeeStats> findByEmployeeId(Long employeeId);

    List<EmployeeStats> findByDepartment(String department);

    List<EmployeeStats> findByAccessLevel(Integer accessLevel);

    @Query("SELECT SUM(e.totalAccesses) FROM EmployeeStats e")
    Integer countTotalAccesses();

    @Query("SELECT SUM(e.grantedAccesses) FROM EmployeeStats e")
    Integer countGrantedAccesses();

    @Query("SELECT SUM(e.deniedAccesses) FROM EmployeeStats e")
    Integer countDeniedAccesses();
}
