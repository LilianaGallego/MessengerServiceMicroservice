package com.pragma.powerup.messengerservicemicroservice.configuration;

import com.pragma.powerup.messengerservicemicroservice.configuration.security.exception.TokenException;
import com.pragma.powerup.messengerservicemicroservice.configuration.security.exception.UserNotRoleAuthorized;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.Collections;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(UserNotRoleAuthorized.class)
    public ResponseEntity<Map<String, String>> handleUserNotRoleAuthorized(
            UserNotRoleAuthorized userNotRoleAuthorized) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Collections.singletonMap(Constants.RESPONSE_ERROR_MESSAGE_KEY, Constants.USER_NOT_ROLE_AUTHORIZED ));
    }

    @ExceptionHandler(TokenException.class)
    public ResponseEntity<Map<String, String>> handleTokenException(
            TokenException tokenException) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Collections.singletonMap(Constants.RESPONSE_ERROR_MESSAGE_KEY, Constants.RESPONSE_ERROR_MESSAGE_TOKEN));
    }
}
