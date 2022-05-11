package com.nosto.currencyconvertorapp.service;

import com.nosto.currencyconvertorapp.dto.CurrencyDto;
import com.nosto.currencyconvertorapp.dto.CurrencyResponseDto;

public interface CurrencyConvertorService {

    CurrencyResponseDto convertCurrency(CurrencyDto currencyDto, String optionalApikey);

    CurrencyResponseDto listCurrency(String optionalApikey);
}
