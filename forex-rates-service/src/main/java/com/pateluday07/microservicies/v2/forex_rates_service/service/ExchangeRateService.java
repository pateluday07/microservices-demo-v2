package com.pateluday07.microservicies.v2.forex_rates_service.service;

import com.pateluday07.microservicies.v2.forex_rates_service.entity.ExchangeRate;

public interface ExchangeRateService {

  ExchangeRate getExchangeRate(String from, String to);
}
