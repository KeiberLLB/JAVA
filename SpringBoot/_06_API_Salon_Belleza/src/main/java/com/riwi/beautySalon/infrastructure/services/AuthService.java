package com.riwi.beautySalon.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.beautySalon.api.dto.request.LoginReq;
import com.riwi.beautySalon.api.dto.request.RegisterReq;
import com.riwi.beautySalon.api.dto.response.AuthResp;
import com.riwi.beautySalon.api.exceptions.BadRequestException;
import com.riwi.beautySalon.domain.entities.User;
import com.riwi.beautySalon.domain.repositories.UserRepository;
import com.riwi.beautySalon.infrastructure.abstract_services.IAuthService;
import com.riwi.beautySalon.infrastructure.helpers.JwtService;
import com.riwi.beautySalon.utils.enums.Role;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthService implements IAuthService {

  @Autowired
  private final UserRepository userRepository;

  @Autowired
  private final JwtService jwtService;

  @Override
  public AuthResp login(LoginReq request) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'login'");
  }

  @Override
  public AuthResp register(RegisterReq request) {
    // 1. Validar que userName no exita
    User exist = this.findByUserName(request.getUsername());
    if (exist != null) {
      throw new BadRequestException("User already exists");
    }
    // 2. Construimos el nuevo usuario
    User user = User.builder()
        .userName(request.getUsername())
        .password(request.getPassword())
        .role(Role.CLIENT)
        .build();
    // 3. Guardar el nuevo usuario en la db
    this.userRepository.save(user);

    return AuthResp.builder()
        .message("Se registró exitosamente")
        .token(this.jwtService.getToken(user))
        .build();
  }

  private User findByUserName(String userName) {
    return this.userRepository.findByUserName(userName).orElse(null);
  }

}
