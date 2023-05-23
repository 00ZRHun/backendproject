package com.sabs.backendproject.services;

import com.sabs.backendproject.config.JwtService;
import com.sabs.backendproject.dtos.AuthenticationRequestDto;
import com.sabs.backendproject.dtos.AuthenticationResponseDto;
import com.sabs.backendproject.dtos.RegisterRequestDto;
import com.sabs.backendproject.enums.RoleEnum;
import com.sabs.backendproject.models.UserModel;
import com.sabs.backendproject.repos.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
  private final UserRepo repository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  public AuthenticationResponseDto register(RegisterRequestDto request) {
    var user = UserModel.builder()
        .firstname(request.getFirstname())
        .lastname(request.getLastname())
        .email(request.getEmail())
        .password(passwordEncoder.encode(request.getPassword()))
        .role(RoleEnum.USER)
        .build();
    repository.save(user);
    var jwtToken = jwtService.generateToken(user);
    return AuthenticationResponseDto.builder()
        .token(jwtToken)
        .build();
  }

  public AuthenticationResponseDto authenticate(AuthenticationRequestDto request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            request.getEmail(),
            request.getPassword()
        )
    );
    var user = repository.findByEmail(request.getEmail())
        .orElseThrow();
    var jwtToken = jwtService.generateToken(user);
    return AuthenticationResponseDto.builder()
        .token(jwtToken)
        .build();
  }
}
