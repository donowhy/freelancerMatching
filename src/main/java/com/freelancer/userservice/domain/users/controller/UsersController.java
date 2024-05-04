package com.freelancer.userservice.domain.users.controller;

import com.freelancer.userservice.domain.users.service.UserService;
import com.freelancer.userservice.domain.users.service.dto.AccessToken;
import com.freelancer.userservice.domain.users.service.dto.LoginInfo;
import com.freelancer.userservice.domain.users.service.dto.controllerDTO.Register;
import com.freelancer.userservice.domain.users.service.dto.serviceDTO.Password;
import com.freelancer.userservice.domain.users.service.dto.serviceDTO.UserInfoChange;
import com.freelancer.userservice.domain.users.service.dto.serviceDTO.UserResponse;
import com.freelancer.userservice.domain.util.UserInfo;
import com.freelancer.userservice.domain.util.UsersInfo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Long> register (@Valid @RequestBody Register register) {
        userService.registerUser(register.toServiceRequest());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/info")
    public ResponseEntity<UserResponse> userInfo (@UserInfo UsersInfo usersInfo) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserInfo(usersInfo.getId()));
    }

    @DeleteMapping("")
    public ResponseEntity<Void> deleteUser (@UserInfo UsersInfo usersInfo) {
        userService.deleteUser(usersInfo.getId());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/login")
    public ResponseEntity<AccessToken> login (@Valid @RequestBody LoginInfo loginInfo) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.login(loginInfo));
    }

    @PutMapping("/password")
    public ResponseEntity<Void> updateUserPassword (@Valid @RequestBody Password password,
                                                    @UserInfo UsersInfo usersInfo) throws NoSuchAlgorithmException, IllegalAccessException {
        userService.updateUserPassword(password, usersInfo.getId());
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/info/change")
    public ResponseEntity<Void> updateUserInfo(@Valid @RequestBody UserInfoChange userInfo,
                                               @UserInfo UsersInfo usersInfo) {
        userService.updateUserInfo(userInfo, usersInfo.getId());
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
