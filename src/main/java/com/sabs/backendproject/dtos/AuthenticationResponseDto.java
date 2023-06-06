package com.sabs.backendproject.dtos;

import com.sabs.backendproject.models.UserModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponseDto {

  private String token;
  private UserModel user;

}
