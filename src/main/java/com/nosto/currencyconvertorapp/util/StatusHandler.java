package com.nosto.currencyconvertorapp.util;

import com.nosto.currencyconvertorapp.constant.CurrencyValidationMessages;
import com.nosto.currencyconvertorapp.dto.CurrencyResponseDto;
import com.nosto.currencyconvertorapp.dto.ResponseDto;
import org.springframework.stereotype.Component;

@Component
public class StatusHandler {

    public CurrencyResponseDto checkStatus(ResponseDto responseDtos) {

        if (responseDtos.getMessage() != null) {
            return new CurrencyResponseDto("401", CurrencyValidationMessages.UNAUTHORIZED_OR_TOO_MANY_REQUEST);
        } else {
            switch (responseDtos.getError().getCode()) {
                case "201":
                case "202":
                case "401":
                case "402":
                case "403":
                    return new CurrencyResponseDto("400", CurrencyValidationMessages.BAD_REQUEST);
                case "404":
                    return new CurrencyResponseDto(responseDtos.getError().getCode(), CurrencyValidationMessages.NOT_FOUND_REQUEST);
                default:
                    return new CurrencyResponseDto(responseDtos.getError().getCode(), CurrencyValidationMessages.SERVER_ERROR);
            }
        }
    }

}
