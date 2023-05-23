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
public class RegisterRequest {

  private String firstname;
  private String lastname;
  private String email;
  private String password;
}
