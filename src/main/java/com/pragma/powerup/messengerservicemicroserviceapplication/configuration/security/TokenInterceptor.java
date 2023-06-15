package com.pragma.powerup.messengerservicemicroserviceapplication.configuration.security;


import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.pragma.powerup.messengerservicemicroserviceapplication.configuration.security.exception.TokenException;
import com.pragma.powerup.messengerservicemicroserviceapplication.configuration.security.exception.UserNotRoleAuthorized;
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

        if (CONSUMER.equals(roleUser) && isClient(request.getRequestURI())) {
            return true;
        }


        if (EMPLOYEE.equals(roleUser) && isEmployee(request.getRequestURI())) {
            return true;
        }

        throw new UserNotRoleAuthorized();
    }

    private boolean isClient(String requestURI) {
        return requestURI.startsWith("/smallsquare/restaurants/all/");

    }

    private boolean isEmployee(String requestURI) {
        return requestURI.startsWith("/messengerservice/send/message");

    }
}

