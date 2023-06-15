package com.pragma.powerup.messengerservicemicroserviceapplication.adapters.driven.jpa.twilio.adapter;

import com.pragma.powerup.messengerservicemicroserviceapplication.domain.spi.IMessengerServicePersistencePort;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class MessangerServiceAdapter implements IMessengerServicePersistencePort {

    public static final String ACCOUNT_SID = "ACef52a1c25e1e9649e68834138501d177";
    public static final String AUTH_TOKEN = "c098fad8a8d776332c07a1208c9ea62c";
    @Override
    public void sendMessageOrderReady(String message) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
         Message.creator(
                        new com.twilio.type.PhoneNumber("+573118688145"),
                        new com.twilio.type.PhoneNumber("+14028242306"),
                        message)
                .create();
    }
}
