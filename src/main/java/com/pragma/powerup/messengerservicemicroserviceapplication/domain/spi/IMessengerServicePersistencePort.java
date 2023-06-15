package com.pragma.powerup.messengerservicemicroserviceapplication.domain.spi;

public interface IMessengerServicePersistencePort {
    void sendMessageOrderReady(String message);

}
