package com.eion.restapi.service;

import com.eion.restapi.payload.LoginDto;

public interface AuthService {
    String login(LoginDto loginDto);
}
