package com.pragma.powerup.messengerservicemicroservice.configuration.security;


import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.pragma.powerup.messengerservicemicroservice.configuration.security.exception.TokenException;
import com.pragma.powerup.messengerservicemicroservice.configuration.security.exception.UserNotRoleAuthorized;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;
import java.util.List;

@Component
public class TokenInterceptor implements HandlerInterceptor {
    private static final String TOKEN_PREFIX = "Bearer ";

    private static String token;
    @Setter
    private static Long idUser;
    private static final String CONSUMER= "ROLE_CONSUMER";
    private static final String EMPLOYEE= "ROLE_EMPLOYEE";


    public static String getAuthorizationToken() {
        return token;
    }
    public static Long getIdUser() {
        return idUser;
    }



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        token = request.getHeader("Authorization");
        if (token == null || !token.startsWith(TOKEN_PREFIX) ){
            throw  new TokenException();
        }

        String jwtToken = token.substring(TOKEN_PREFIX.length());
        List<String> roles;

        DecodedJWT decodedJWT = JWT.decode(jwtToken);
        roles = decodedJWT.getClaim("roles").asList(String.class);
        idUser = decodedJWT.getClaim("id").asLong();

        String roleUser = roles.get(0);

        if ((CONSUMER.equals(roleUser) || EMPLOYEE.equals(roleUser)) && isValid(request.getRequestURI())) {
            return true;
        }


        throw new UserNotRoleAuthorized();
    }

    private boolean isValid(String requestURI) {
        return requestURI.startsWith("/messengerservice/send/message");

    }


}

