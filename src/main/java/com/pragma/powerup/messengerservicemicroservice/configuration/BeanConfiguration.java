package com.pragma.powerup.messengerservicemicroservice.configuration;

import com.pragma.powerup.messengerservicemicroservice.adapters.driven.jpa.twilio.adapter.MessangerServiceAdapter;
import com.pragma.powerup.messengerservicemicroservice.domain.api.IMessengerServicePort;
import com.pragma.powerup.messengerservicemicroservice.domain.spi.IMessengerServicePersistencePort;
import com.pragma.powerup.messengerservicemicroservice.domain.usecase.MessengerServiceUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {


    @Bean
    public IMessengerServicePersistencePort messengerServicePersistencePort() {
        return new MessangerServiceAdapter();
    }

    @Bean
    public IMessengerServicePort messengerServicePort() {
        return new MessengerServiceUseCase(messengerServicePersistencePort());
    }
}
