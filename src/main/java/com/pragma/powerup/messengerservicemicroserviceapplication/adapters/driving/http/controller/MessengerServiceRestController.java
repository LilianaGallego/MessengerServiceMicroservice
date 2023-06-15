package com.pragma.powerup.messengerservicemicroserviceapplication.adapters.driving.http.controller;

import com.pragma.powerup.messengerservicemicroserviceapplication.adapters.driving.http.handlers.IMessangerServiceHandler;
import com.pragma.powerup.messengerservicemicroserviceapplication.configuration.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/messengerservice")
@RequiredArgsConstructor
public class MessengerServiceRestController {
    private final IMessangerServiceHandler messangerServiceHandler;

    @SecurityRequirement(name = "jwt")
    @Operation(summary = "Send a new message",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Messenger Service created",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "409", description = "Messenger Service already exists",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error"))),
                    })
    @SecurityRequirement(name = "jwt")
    @PostMapping("/send/message")
    public ResponseEntity<Map<String, String>> sendMessageOrderReady(@Valid @RequestBody String message) {
        messangerServiceHandler.sendMessageOrderReady(message);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, Constants.MESSAGE_ORDER_READY));
    }


}

