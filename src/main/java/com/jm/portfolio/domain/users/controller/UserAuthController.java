package com.jm.portfolio.domain.users.controller;

import com.jm.portfolio.domain.users.dto.request.SignInRequest;
import com.jm.portfolio.domain.users.dto.request.SignupRequest;
import com.jm.portfolio.domain.users.service.SignInService;
import com.jm.portfolio.domain.users.service.SignUpService;
import com.jm.portfolio.global.common.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Tag(name="회원", description = "회원 관련 API")
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserAuthController {

    private final SignUpService signUpService;
    private final SignInService signinService;

    /**
     * 회원 가입 기능
     * @param newUser
     * @return
     */
    @Operation(summary = "회원가입", description = "회원가입 메소드")
    @PostMapping(value = "/signup")
    public ResponseEntity<ApiResponse> signUp (@RequestBody @Valid SignupRequest newUser) {
        return ResponseEntity.ok().body(new ApiResponse(HttpStatus.OK, "success", signUpService.signUp(newUser)));
    }

    @Operation(summary = "로그인", description = "로그인 메소드")
    @PostMapping(value = "/signin")
    public ResponseEntity<ApiResponse> signIn (@RequestBody @Valid SignInRequest user) {
        return ResponseEntity.ok().body(new ApiResponse(HttpStatus.OK, "success", signinService.signIn(user)));
    }

    @Operation(summary = "토큰 재발급", description = "Access 토큰 재발급 메소드")
    @PostMapping(value = "/reissue-access-token")
    public ResponseEntity<ApiResponse> reissueAccessToken (@RequestBody @Valid String refreshToken) {
        return ResponseEntity.ok().body(new ApiResponse(HttpStatus.OK, "success", signinService.reissueAccessToken(refreshToken)));
    }
}