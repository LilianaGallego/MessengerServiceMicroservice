package com.pragma.powerup.messengerservicemicroservice.domain.usecase;

import com.pragma.powerup.messengerservicemicroservice.domain.api.IMessengerServicePort;
import com.pragma.powerup.messengerservicemicroservice.domain.spi.IMessengerServicePersistencePort;

public class MessengerServiceUseCase implements IMessengerServicePort {
    private final IMessengerServicePersistencePort messangerServicePersistencePort;

    public MessengerServiceUseCase(IMessengerServicePersistencePort messangerServicePersistencePort) {
        this.messangerServicePersistencePort = messangerServicePersistencePort;
    }

    @Override
    public void sendMessageStateOrderUpdated(String message) {
        messangerServicePersistencePort.sendMessageStateOrderUpdated(message);
    }
}
