package com.pragma.powerup.messengerservicemicroserviceapplication.domain.usecase;

import com.pragma.powerup.messengerservicemicroserviceapplication.domain.api.IMessengerServicePort;
import com.pragma.powerup.messengerservicemicroserviceapplication.domain.spi.IMessengerServicePersistencePort;

public class MessengerServiceUseCase implements IMessengerServicePort {
    private final IMessengerServicePersistencePort messangerServicePersistencePort;

    public MessengerServiceUseCase(IMessengerServicePersistencePort messangerServicePersistencePort) {
        this.messangerServicePersistencePort = messangerServicePersistencePort;
    }

    @Override
    public void sendMessageOrderReady(String message) {
        messangerServicePersistencePort.sendMessageOrderReady(message);
    }

   }
