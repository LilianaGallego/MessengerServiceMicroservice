package com.pragma.powerup.messengerservicemicroservice.adapters.driving.http.handlers.impl;

import com.pragma.powerup.messengerservicemicroservice.adapters.driving.http.handlers.IMessangerServiceHandler;
import com.pragma.powerup.messengerservicemicroservice.domain.api.IMessengerServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessengerServiceHandlerImpl implements IMessangerServiceHandler {

    private final IMessengerServicePort messengerServicePort;


    @Override
    public void sendMessageOrderReady(String message) {
        messengerServicePort.sendMessageOrderReady(message);
    }

}
