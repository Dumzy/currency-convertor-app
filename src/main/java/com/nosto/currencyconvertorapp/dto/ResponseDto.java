package com.nosto.currencyconvertorapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseDto {

    private double result;
    private Map<String, Double> quotes;
    private Map<String, String> currencies;
    private boolean success;
    private ErrorDto error;
    private String message;

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public Map<String, Double> getQuotes() {
        return quotes;
    }

    public void setQuotes(Map<String, Double> quotes) {
        this.quotes = quotes;
    }

    public Map<String, String> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(Map<String, String> currencies) {
        this.currencies = currencies;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ErrorDto getError() {
        return error;
    }

    public void setError(ErrorDto error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
