package com.phapsuit.identity_service.controller;

import com.nimbusds.jose.JOSEException;
import com.phapsuit.identity_service.dto.request.ApiResponse;
import com.phapsuit.identity_service.dto.request.AuthenticationRequest;
import com.phapsuit.identity_service.dto.request.IntrospectRequest;
import com.phapsuit.identity_service.dto.response.AuthenticationResponse;
import com.phapsuit.identity_service.dto.response.IntrospectResponse;
import com.phapsuit.identity_service.service.AuthencationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthencationService authencationService;

    @PostMapping("/token")
    ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        var result = authencationService.authenticate(request);
        return ApiResponse.<AuthenticationResponse>builder()
                .result(result)
                .build();
    }

    @PostMapping("/introspect")
    ApiResponse<IntrospectResponse> authenticate(@RequestBody IntrospectRequest request) throws ParseException, JOSEException {
        var result = authencationService.introspect(request);
        return ApiResponse.<IntrospectResponse>builder()
                .result(result)
                .build();
    }
}
