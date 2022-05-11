package com.nosto.currencyconvertorapp.dto;

import com.nosto.currencyconvertorapp.constant.CurrencyValidationMessages;

import javax.validation.constraints.NotBlank;

public class CurrencyDto {

    @NotBlank(message = CurrencyValidationMessages.SOURCE_CURRENCY_REQUIRED)
    private String sourceCurrency;

    @NotBlank(message = CurrencyValidationMessages.TARGET_CURRENCY_REQUIRED)
    private String targetCurrency;

    @NotBlank(message = CurrencyValidationMessages.MONETARY_VALUE_REQUIRED)
    private String monetaryValue;

    public String getSourceCurrency() {
        return sourceCurrency;
    }

    public void setSourceCurrency(String sourceCurrency) {
        this.sourceCurrency = sourceCurrency;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    public String getMonetaryValue() {
        return monetaryValue;
    }

    public void setMonetaryValue(String monetaryValue) {
        this.monetaryValue = monetaryValue;
    }
}
