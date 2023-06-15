package com.pragma.powerup.messengerservicemicroserviceapplication.adapters.driving.http.handlers.impl;

import com.pragma.powerup.messengerservicemicroserviceapplication.adapters.driving.http.handlers.IMessangerServiceHandler;
import com.pragma.powerup.messengerservicemicroserviceapplication.domain.api.IMessengerServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessengerServiceHandlerImpl implements IMessangerServiceHandler {

    private final IMessengerServicePort messengerServicePort;


    @Override
    public void sendMessageOrderReady(String message) {
        messengerServicePort.sendMessageOrderReady(message);
    }

}
