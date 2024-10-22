package com.pateluday07.microservicies.v2.forex_rates_service.repository;

import java.util.Optional;

import com.pateluday07.microservicies.v2.forex_rates_service.entity.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {

  Optional<ExchangeRate> findByFromAndTo(String from, String to);
}
