package com.nosto.currencyconvertorapp.constant;

public final class CurrencyValidationMessages {

    public static final String SOURCE_CURRENCY_REQUIRED = "Source Currency is Mandatory";

    public static final String TARGET_CURRENCY_REQUIRED = "Target Currency is Mandatory";

    public static final String MONETARY_VALUE_REQUIRED = "Monetary Value is Mandatory";

    public static final String BAD_REQUEST = "The request was unacceptable, often due to missing a required parameter or invalid parameter value";

    public static final String UNAUTHORIZED_REQUEST = "No valid API key provided";

    public static final String NOT_FOUND_REQUEST = "The requested resource doesn't exist";

    public static final String TOO_MANY_REQUEST = "API request limit exceeded. Please use a different api key by passing as a query parameter to access the API route";

    public static final String SERVER_ERROR = "Server Error";

    private CurrencyValidationMessages() {
    }
}
