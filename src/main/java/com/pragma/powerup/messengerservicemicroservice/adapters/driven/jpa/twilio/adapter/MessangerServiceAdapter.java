package com.pragma.powerup.messengerservicemicroservice.adapters.driven.jpa.twilio.adapter;

import com.pragma.powerup.messengerservicemicroservice.domain.spi.IMessengerServicePersistencePort;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;


@RequiredArgsConstructor
public class MessangerServiceAdapter implements IMessengerServicePersistencePort {

    @Value("${my.variables.accountSid}")
    String accountSid;
    @Value("${my.variables.authToken}")
    String authToken;
    @Value("${my.variables.phoneNumberTo}")
    String phoneNumberTo;
    @Value("${my.variables.phoneNumberFrom}")
    String phoneNumberFrom;

    @Override
    public void sendMessageOrderReady(String message) {
        Twilio.init(accountSid, authToken);
         Message.creator(
                        new com.twilio.type.PhoneNumber(phoneNumberTo),
                        new com.twilio.type.PhoneNumber(phoneNumberFrom),
                        message)
                .create();
    }
}
