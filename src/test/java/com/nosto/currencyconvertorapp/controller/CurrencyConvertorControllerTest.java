package com.nosto.currencyconvertorapp.controller;

import com.nosto.currencyconvertorapp.dto.CurrencyDto;
import com.nosto.currencyconvertorapp.dto.CurrencyResponseDto;
import com.nosto.currencyconvertorapp.service.CurrencyConvertorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class CurrencyConvertorControllerTest {

    @Mock
    private CurrencyConvertorService currencyConvertorService;

    @InjectMocks
    private CurrencyConvertorController currencyConvertorController;

    @Test
    public void testGetCurrencies() {

        Map<String, String> currDetails = new HashMap<>();
        currDetails.put("AED", "United Arab Emirates Dirham");
        currDetails.put("AFN", "Afghan Afghani");

        CurrencyResponseDto currencyResponseDto = new CurrencyResponseDto(currDetails);

        Mockito.when(currencyConvertorService.listCurrency(Mockito.anyString())).thenReturn(currencyResponseDto);
        CurrencyResponseDto currencyResDto = currencyConvertorController.getCurrencies("");

        Assertions.assertNotNull(currencyResDto);
    }

    @Test
    public void testConvertCurrency() {

        CurrencyResponseDto currencyResponseDto = new CurrencyResponseDto(1266.113);

        Mockito.when(currencyConvertorService.convertCurrency(Mockito.any(CurrencyDto.class), Mockito.anyString())).thenReturn(currencyResponseDto);
        CurrencyResponseDto currencyResDto = currencyConvertorController.convertCurrency(new CurrencyDto(), "");

        Assertions.assertNotNull(currencyResDto);
    }

}
