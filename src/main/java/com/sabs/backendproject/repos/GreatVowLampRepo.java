package com.sabs.backendproject.repos;

import com.sabs.backendproject.models.GreatVowLampModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreatVowLampRepo extends JpaRepository <GreatVowLampModel, Long> {
}
