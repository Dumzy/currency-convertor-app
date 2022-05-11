package com.nosto.currencyconvertorapp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Currency Convertor API", version = "1.0", description = "Currency Convertor Information"))
public class CurrencyConvertorAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConvertorAppApplication.class, args);
	}

}
