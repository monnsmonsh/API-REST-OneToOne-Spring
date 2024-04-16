package com.management.Management.repository;

import com.management.Management.models.Management;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IManagementRepository extends JpaRepository<Management, Integer> {
}
