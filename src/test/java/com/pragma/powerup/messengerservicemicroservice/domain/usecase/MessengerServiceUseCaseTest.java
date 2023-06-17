package com.pragma.powerup.messengerservicemicroservice.domain.usecase;

import com.pragma.powerup.messengerservicemicroservice.domain.api.IMessengerServicePort;
import com.pragma.powerup.messengerservicemicroservice.domain.spi.IMessengerServicePersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MessengerServiceUseCaseTest {

    @Mock
    private IMessengerServicePersistencePort messengerServicePersistencePort;
    private IMessengerServicePort servicePort;
    @BeforeEach
    void setUp() {
        servicePort = new MessengerServiceUseCase(messengerServicePersistencePort);
    }
    @Test
    void testSendMessageOrderReady_ValidOrder_Success() {
        // Arrange
        String bodyMessage = "Estimado cliente, su pedido está listo para reclamar.";



        // Act
        servicePort.sendMessageStateOrderUpdated(bodyMessage);

        // Assert
        verify(messengerServicePersistencePort, times(1)).sendMessageStateOrderUpdated(bodyMessage);
    }

}