package com.real.realoasis.domain.auth.util;

import com.real.realoasis.domain.auth.data.dto.LoginDto;
import com.real.realoasis.domain.auth.data.dto.SearchPwDto;
import com.real.realoasis.domain.auth.data.dto.SignupDto;
import com.real.realoasis.domain.auth.data.dto.TokenDto;
import com.real.realoasis.domain.auth.data.request.LoginRequest;
import com.real.realoasis.domain.auth.data.request.SearchPwRequest;
import com.real.realoasis.domain.auth.data.request.SignUpRequest;
import com.real.realoasis.domain.auth.data.response.SearchPwResponse;
import com.real.realoasis.domain.auth.data.response.SignupResponse;
import com.real.realoasis.domain.auth.data.response.TokenResponse;
import com.real.realoasis.domain.user.data.entity.User;

public interface AuthConverter {
    SignupDto toDto(SignUpRequest signupRequest);

    User toEntity(SignupDto signupDto);

    SignupResponse toResponse(String code);

    LoginDto toDto(LoginRequest loginRequest);

    TokenDto toDto(String accessToken, String refreshToken, Long expireAt, User user);

    TokenResponse toResponse(TokenDto tokenDto);

    SearchPwDto toDto(SearchPwRequest searchPWRequest);

    SearchPwResponse toSearchPwResponse(String pw);
}
