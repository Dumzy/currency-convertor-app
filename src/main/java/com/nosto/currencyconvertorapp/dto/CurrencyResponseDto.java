package com.nosto.currencyconvertorapp.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CurrencyResponseDto {

    private double result;
    private Map<String, String> currencies;
    private String code;
    private String message;

    public CurrencyResponseDto(double result) {
        this.result = result;
    }

    public CurrencyResponseDto(Map<String, String> currencies) {
        this.currencies = currencies;
    }

    public CurrencyResponseDto(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public Map<String, String> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(Map<String, String> currencies) {
        this.currencies = currencies;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
