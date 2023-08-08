/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.eureka.controller;

import com.bluehabit.eureka.common.BaseResponse;
import com.bluehabit.eureka.component.user.UserCredential;
import com.bluehabit.eureka.component.user.model.SignInResponse;
import com.bluehabit.eureka.component.user.model.SignInWithEmailRequest;
import com.bluehabit.eureka.component.user.model.SignInWithGoogleRequest;
import com.bluehabit.eureka.component.user.model.SignUpWithEmailRequest;
import com.bluehabit.eureka.component.user.model.SignUpWithGoogleRequest;
import com.bluehabit.eureka.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    @Autowired
    private UserService userService;

    @PostMapping(
        path = "/auth/sign-in-email",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<BaseResponse<SignInResponse>> signInWithEmail(@NonNull @RequestBody SignInWithEmailRequest req) {
        return userService.signInWithEmail(req);
    }

    @PostMapping(
        path = "/auth/sign-in-google",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<BaseResponse<SignInResponse>> signInWithGoogle(@NonNull @RequestBody SignInWithGoogleRequest req) {
        return userService.signInWithGoogle(req);
    }

    @PostMapping(
        path = "/auth/sign-up-email",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<BaseResponse<UserCredential>> signUpWithEmail(@NonNull @RequestBody SignUpWithEmailRequest request) {
        return userService.signUpWithEmail(request);
    }

    @PostMapping(
        path = "/auth/sign-up-google",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<BaseResponse<UserCredential>> signUpWithGoogle(@NonNull @RequestBody SignUpWithGoogleRequest request) {
        return userService.signUpWithGoogle(request);
    }

    @GetMapping(
        path = "/auth/refresh-token",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<BaseResponse<String>> refreshToken(
        @RequestHeader("Authorization") String token
    ) {
        return userService.refreshToken(token);
    }
}