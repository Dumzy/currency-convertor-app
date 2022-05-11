package com.nosto.currencyconvertorapp.controller;

import com.nosto.currencyconvertorapp.dto.CurrencyDto;
import com.nosto.currencyconvertorapp.dto.CurrencyResponseDto;
import com.nosto.currencyconvertorapp.service.CurrencyConvertorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/v1/currency")
@Tag(name = "Currency V1 API")
public class CurrencyConvertorController {

    Logger logger = LoggerFactory.getLogger(CurrencyConvertorController.class);

    @Autowired
    private CurrencyConvertorService currencyConvertorService;

    @GetMapping(value = "/list")
    @ResponseStatus(HttpStatus.OK)
    @Operation(description = "Retrieve all the currency details")
    public CurrencyResponseDto getCurrencies(@RequestParam(required = false) String apikey) {

        logger.info("List Currencies");

        return currencyConvertorService.listCurrency(apikey);
    }

    @PostMapping(value = "/convert")
    @ResponseStatus(HttpStatus.OK)
    @Operation(description = "Convert the currency")
    public CurrencyResponseDto convertCurrency(@RequestBody @Valid CurrencyDto currencyDto, @RequestParam(required = false) String apikey) {

        logger.info("Convert Currency : From : {}  To : {}  Amount : {}", currencyDto.getSourceCurrency(),
                currencyDto.getTargetCurrency(), currencyDto.getMonetaryValue());

        return currencyConvertorService.convertCurrency(currencyDto, apikey);
    }
}
