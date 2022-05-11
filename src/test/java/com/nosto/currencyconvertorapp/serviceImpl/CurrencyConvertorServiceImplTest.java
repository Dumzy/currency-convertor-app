package com.nosto.currencyconvertorapp.serviceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nosto.currencyconvertorapp.dto.CurrencyDto;
import com.nosto.currencyconvertorapp.dto.ResponseDto;
import com.nosto.currencyconvertorapp.util.HttpClient;
import okhttp3.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.util.ReflectionTestUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class CurrencyConvertorServiceImplTest {

    @Mock
    private HttpClient httpClient;

    @Mock
    private ObjectMapper objectMapper;

    @InjectMocks
    private CurrencyConvertorServiceImpl currencyConvertorServiceImpl;

    private String apikey = "t8npDqK4jposiI6OWdZO7m8ynwpc6MOZ";
    private String url = "https://api.apilayer.com/currency_data/convert";
    private String listURL = "https://api.apilayer.com/currency_data/list";

    @BeforeEach
    public void setup() {
        ReflectionTestUtils.setField(currencyConvertorServiceImpl, "apiKey", apikey);
        ReflectionTestUtils.setField(currencyConvertorServiceImpl, "url", url);
        ReflectionTestUtils.setField(currencyConvertorServiceImpl, "listURL", listURL);
    }

    @Test
    public void testConvertCurrency() throws IOException {

        File resource = new ClassPathResource("Currency_Convert.json").getFile();
        String content = new String(Files.readAllBytes(resource.toPath()));
        ResponseDto responseDto = new ObjectMapper().readValue(content, ResponseDto.class);

        Mockito.when(httpClient.getRequest(Mockito.anyMap(), Mockito.anyString(), Mockito.anyMap())).thenReturn(Mockito.any(Response.class));
        Mockito.lenient().when(objectMapper.readValue(Mockito.anyString(), ResponseDto.class)).thenReturn(responseDto);

        CurrencyDto currencyDto = new CurrencyDto();
        currencyConvertorServiceImpl.convertCurrency(currencyDto, "");

        Mockito.verify(httpClient, Mockito.times(1)).getRequest(Mockito.anyMap(),
                Mockito.anyString(), Mockito.anyMap());
    }

    @Test
    public void testListCurrency() throws IOException {

        File resource = new ClassPathResource("Currency_List.json").getFile();
        String contents = new String(Files.readAllBytes(resource.toPath()));
        ResponseDto responseDto = new ObjectMapper().readValue(contents, ResponseDto.class);

        Mockito.lenient().when(httpClient.getRequest(Mockito.anyMap(), Mockito.anyString(), Mockito.anyMap())).thenReturn(Mockito.any(Response.class));
        Mockito.lenient().when(objectMapper.readValue(Mockito.anyString(), ResponseDto.class)).thenReturn(responseDto);

        currencyConvertorServiceImpl.listCurrency( "");

        Mockito.verify(httpClient, Mockito.times(0)).getRequest(Mockito.anyMap(), Mockito.anyString(),
                Mockito.anyMap());
    }

}
