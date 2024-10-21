package com.pateluday07.microservicies.v2.forex_converter_service.service;

import com.pateluday07.microservicies.v2.forex_converter_service.dto.CurrencyConverterDto;

import java.math.BigDecimal;

public interface CurrencyConverterService {

  CurrencyConverterDto convert(String from, String to, BigDecimal amount);

}
