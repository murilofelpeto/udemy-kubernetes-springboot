package br.com.murilo.currency_exchange_istio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.murilo.currency_exchange_istio.model.ExchangeValue;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {
	ExchangeValue findByFromAndTo(String from, String to);
}
