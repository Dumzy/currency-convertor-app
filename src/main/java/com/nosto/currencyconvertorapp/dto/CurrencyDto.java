package com.nosto.currencyconvertorapp.dto;

import com.nosto.currencyconvertorapp.constant.CurrencyValidationMessages;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CurrencyDto {

    @NotBlank(message = CurrencyValidationMessages.SOURCE_CURRENCY_REQUIRED)
    private String sourceCurrency;

    @NotBlank(message = CurrencyValidationMessages.TARGET_CURRENCY_REQUIRED)
    private String targetCurrency;

    @NotNull(message = CurrencyValidationMessages.MONETARY_VALUE_REQUIRED)
    private Double monetaryValue;

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

    public Double getMonetaryValue() {
        return monetaryValue;
    }

    public void setMonetaryValue(Double monetaryValue) {
        this.monetaryValue = monetaryValue;
    }
}
