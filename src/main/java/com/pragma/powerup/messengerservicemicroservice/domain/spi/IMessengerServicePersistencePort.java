package com.pragma.powerup.messengerservicemicroservice.domain.spi;

public interface IMessengerServicePersistencePort {
    void sendMessageOrderReady(String message);

}
