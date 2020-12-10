package br.com.murilo.currency_conversion_istio.controller;

import br.com.murilo.currency_conversion_istio.bean.CurrencyConversionBean;
import br.com.murilo.currency_conversion_istio.service.InstanceInformationService;
import java.math.BigDecimal;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CurrencyConversionController.class);

	@Autowired
	private InstanceInformationService instanceInformationService;

	@Autowired
	private RestTemplate restTemplate;


	//CHANGE
	@Value("${CURRENCY_EXCHANGE_URI:http://localhost:8000}")
	private String currencyExchangeBaseUrl;

	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to,
												  @PathVariable BigDecimal quantity) {

		LOGGER.info("Received Request to convert from {} {} to {}. ", quantity, from, to);

		Optional<CurrencyConversionBean> optionalResponse = Optional.ofNullable(restTemplate.getForObject(
				currencyExchangeBaseUrl + "/currency-exchange/from/" + from + "/to/" + to, CurrencyConversionBean.class));

		BigDecimal convertedValue;
		convertedValue = new BigDecimal(0);

		CurrencyConversionBean response;
		response = new CurrencyConversionBean();

		if(optionalResponse.isPresent()){
			response = optionalResponse.get();
			convertedValue = quantity.multiply(response.getConversionMultiple());
		}

		String conversionEnvironmentInfo = instanceInformationService.retrieveInstanceInfo();

		return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity,
				convertedValue, response.getExchangeEnvironmentInfo(), conversionEnvironmentInfo);
	}
}