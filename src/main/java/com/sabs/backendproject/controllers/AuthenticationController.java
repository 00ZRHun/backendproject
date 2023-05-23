package com.sabs.backendproject.controllers;

import com.sabs.backendproject.dtos.AuthenticationRequestDto;
import com.sabs.backendproject.dtos.AuthenticationResponseDto;
import com.sabs.backendproject.services.AuthenticationService;
import com.sabs.backendproject.dtos.RegisterRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService service;

  @PostMapping("/register")
  public ResponseEntity<AuthenticationResponseDto> register(
      @RequestBody RegisterRequestDto request
  ) {
    return ResponseEntity.ok(service.register(request));
  }
  @PostMapping("/login")
  public ResponseEntity<AuthenticationResponseDto> authenticate(
      @RequestBody AuthenticationRequestDto request
  ) {
    return ResponseEntity.ok(service.authenticate(request));
  }


}
