package com.jm.portfolio.domain.users.controller;

import com.jm.portfolio.domain.model.Email;
import com.jm.portfolio.domain.users.domain.Users;
import com.jm.portfolio.domain.users.dto.UserDetailsImpl;
import com.jm.portfolio.domain.users.dto.response.UserResponse;
import com.jm.portfolio.domain.users.service.UserRetrieveService;
import com.jm.portfolio.global.common.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Tag(name="회원", description = "회원 관련 API")
@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRetrieveService userRetrieveService;
//    private final UserModificateService

    @Operation(summary = "회원 본인의 정보", description = "회원 본인의 정보를 조회하는 메소드")
    @GetMapping(value = "/info")
    public ResponseEntity<ApiResponse> myInfo () {

        UserDetailsImpl principal = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Users user = principal.getUser();

        return ResponseEntity.ok().body(new ApiResponse(HttpStatus.OK, "success", new UserResponse(user)));
    }

//    @Operation(summary = "회원 정보 수정", description = "회원 본인의 정보를 수정하는 메소드")
//    @GetMapping(value = "/{email}")
//    public ResponseEntity<ApiResponse> myInfo (@PathVariable("email") @Valid String userEmail) {
//        return ResponseEntity.ok().body(new ApiResponse(HttpStatus.OK, "success", userRetrieveService.myInfo(Email.of(userEmail))));
//    }
}