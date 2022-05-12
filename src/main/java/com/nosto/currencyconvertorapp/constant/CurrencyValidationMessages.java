package com.nosto.currencyconvertorapp.constant;

public final class CurrencyValidationMessages {

    public static final String SOURCE_CURRENCY_REQUIRED = "Source Currency is Mandatory";

    public static final String TARGET_CURRENCY_REQUIRED = "Target Currency is Mandatory";

    public static final String MONETARY_VALUE_REQUIRED = "Monetary Value is Mandatory";

    public static final String BAD_REQUEST = "The request was unacceptable, often due to missing a required parameter or invalid parameter value";

    public static final String UNAUTHORIZED_OR_TOO_MANY_REQUEST = "Check if the API key is valid or if the request limit has been exceeded";

    public static final String NOT_FOUND_REQUEST = "The requested resource doesn't exist";

    public static final String SERVER_ERROR = "Server Error";

    private CurrencyValidationMessages() {
    }
}
