package com.eion.restapi.service;

import com.eion.restapi.payload.LoginDto;
import com.eion.restapi.payload.RegisterDto;

public interface AuthService {
    String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
}
