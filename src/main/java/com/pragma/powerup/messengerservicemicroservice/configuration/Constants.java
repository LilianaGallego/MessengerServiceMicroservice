package com.pragma.powerup.messengerservicemicroservice.configuration;

public class Constants {

    private Constants() {
        throw new IllegalStateException("Utility class");
    }

    public static final Long EMPLOYEE_ROLE_ID = 4L;
    public static final String RESPONSE_MESSAGE_KEY = "message";
    public static final String RESPONSE_ERROR_MESSAGE_KEY = "error";
    public static final String RESPONSE_ERROR_MESSAGE_TOKEN= "A problem with the token has occurred";
    public static final String SWAGGER_TITLE_MESSAGE = "Messenger service API Pragma Power Up";
    public static final String USER_NOT_ROLE_AUTHORIZED= "the user's role is not authorized";
    public static final String MESSAGE_ORDER_UPDATED = "Message sent to the customer by the status of the order updated";
    public static final String SWAGGER_DESCRIPTION_MESSAGE = "Messenger service microservice";
    public static final String SWAGGER_VERSION_MESSAGE = "1.0.0";
    public static final String SWAGGER_LICENSE_NAME_MESSAGE = "Apache 2.0";
    public static final String SWAGGER_LICENSE_URL_MESSAGE = "http://springdoc.org";
    public static final String SWAGGER_TERMS_OF_SERVICE_MESSAGE = "http://swagger.io/terms/";
}