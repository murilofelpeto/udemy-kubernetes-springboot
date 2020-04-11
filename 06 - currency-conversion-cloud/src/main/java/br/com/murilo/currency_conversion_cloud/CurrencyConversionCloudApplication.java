package br.com.murilo.currency_conversion_cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("br.com.murilo.currency_conversion_cloud.proxy")
@EnableDiscoveryClient
public class CurrencyConversionCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionCloudApplication.class, args);
	}

}
