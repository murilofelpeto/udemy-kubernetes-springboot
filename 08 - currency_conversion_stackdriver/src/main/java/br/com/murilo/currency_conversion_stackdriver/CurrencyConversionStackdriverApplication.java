package br.com.murilo.currency_conversion_stackdriver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("br.com.murilo.currency_conversion_stackdriver")
public class CurrencyConversionStackdriverApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionStackdriverApplication.class, args);
	}

}
