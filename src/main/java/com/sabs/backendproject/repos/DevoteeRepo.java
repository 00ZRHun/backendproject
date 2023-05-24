package com.sabs.backendproject.repos;

import com.sabs.backendproject.models.DevoteeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevoteeRepo extends JpaRepository <DevoteeModel, Long> {
}
