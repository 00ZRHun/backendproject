package com.sabs.backendproject.repos;

import com.sabs.backendproject.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserModel, Integer> {

  Optional<UserModel> findByEmail(String email);

}
