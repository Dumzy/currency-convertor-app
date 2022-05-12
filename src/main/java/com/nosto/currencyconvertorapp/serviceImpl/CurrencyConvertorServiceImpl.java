package com.nosto.currencyconvertorapp.serviceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nosto.currencyconvertorapp.constant.CurrencyValidationMessages;
import com.nosto.currencyconvertorapp.constant.HeaderParameters;
import com.nosto.currencyconvertorapp.constant.PathParameters;
import com.nosto.currencyconvertorapp.dto.CurrencyDto;
import com.nosto.currencyconvertorapp.dto.CurrencyResponseDto;
import com.nosto.currencyconvertorapp.dto.ResponseDto;
import com.nosto.currencyconvertorapp.service.CurrencyConvertorService;
import com.nosto.currencyconvertorapp.util.HttpClient;
import com.nosto.currencyconvertorapp.util.StatusHandler;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Service
public class CurrencyConvertorServiceImpl implements CurrencyConvertorService {

    Logger logger = LoggerFactory.getLogger(CurrencyConvertorServiceImpl.class);

    @Autowired
    private HttpClient httpClient;

    @Autowired
    private StatusHandler statusHandler;

    @Value("${api.key}")
    private String apiKey;

    @Value("${currency.data.convertURL}")
    private String convertURL;

    @Value("${currency.list.url}")
    private String listURL;

    /**
     * Convert the specified monetary value.
     *
     * @param currencyDto
     * @param optionalApikey
     * @return converted currency value
     */
    @Override
    public CurrencyResponseDto convertCurrency(CurrencyDto currencyDto, String optionalApikey) {

        try {

            Map<String, String> pathParams = new HashMap<>();
            pathParams.put(PathParameters.CURRENCIES, currencyDto.getTargetCurrency());
            pathParams.put(PathParameters.SOURCE, currencyDto.getSourceCurrency());

            ResponseDto responseDto = transformObject(initializeRequest(optionalApikey, convertURL, pathParams));

            if (responseDto.isSuccess()) {

                Double rate = 0.0;

                Iterator<Double> iterator = responseDto.getQuotes().values().iterator();
                while (iterator.hasNext()) {
                    rate = iterator.next();
                }

                responseDto.setResult(currencyDto.getMonetaryValue()*rate);
                return new CurrencyResponseDto(responseDto.getResult());

            } else {
                return statusHandler.checkStatus(responseDto);
            }

        } catch (Exception e) {

            logger.error(e.getMessage());
            return new CurrencyResponseDto(String.valueOf(HttpStatus.BAD_REQUEST.value()), CurrencyValidationMessages.SERVER_ERROR);
        }
    }

    /**
     * To check the existing currencies
     *
     * @param optionalApikey
     * @return list of currencies
     */
    @Override
    public CurrencyResponseDto listCurrency(String optionalApikey) {

        try {

            ResponseDto responseDto = transformObject(initializeRequest(optionalApikey, listURL, null));

            if (responseDto.isSuccess()) {
                return new CurrencyResponseDto(responseDto.getCurrencies());
            } else {
                return statusHandler.checkStatus(responseDto);
            }

        } catch (Exception e) {
            logger.error(e.getMessage());
            return new CurrencyResponseDto(String.valueOf(HttpStatus.BAD_REQUEST.value()), CurrencyValidationMessages.SERVER_ERROR);
        }
    }

    private Response initializeRequest(String optionalApikey, String url, Map<String, String> pathParameters) throws IOException {

        Map<String, String> headerValues = new HashMap<>();
        if (optionalApikey != null) {
            headerValues.put(HeaderParameters.API_KEY, optionalApikey);
        } else {
            headerValues.put(HeaderParameters.API_KEY, apiKey);
        }

        return httpClient.getRequest(headerValues, url, pathParameters);
    }

    private ResponseDto transformObject(Response responses) throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(responses.body().string(), ResponseDto.class);
    }

}
