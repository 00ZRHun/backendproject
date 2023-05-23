package com.sabs.backendproject.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
// TODO: make it as dto & store under dtos/
public class AuthenticationRequest {

  private String email;
  String password;
}
